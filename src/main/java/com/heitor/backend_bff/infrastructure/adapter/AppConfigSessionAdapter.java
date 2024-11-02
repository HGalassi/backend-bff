package com.heitor.backend_bff.infrastructure.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import software.amazon.awssdk.services.sts.StsClient;
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
import software.amazon.awssdk.services.sts.model.AssumeRoleResponse;

public class AppConfigSessionAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AppConfigSessionAdapter.class);

    private final String roleArn;
    private final Region region;
    private AwsSessionCredentials awsSessionCredentials;
    private String sessionName;

    public AppConfigSessionAdapter(String roleArn, Region region) {
        this.roleArn = roleArn;
        this.region = region;
    }

    public AppConfigClient createSession() {
        logger.info("Iniciando a assunção de role com STS");

        StsClient stsClient = StsClient.builder().region(region).build();

        AssumeRoleRequest assumeRoleRequest = AssumeRoleRequest.builder()
                .roleArn(roleArn)
                .roleSessionName("appConfigSession")
                .durationSeconds(900) // 15 minutos
                .build();

        AssumeRoleResponse assumeRoleResponse = stsClient.assumeRole(assumeRoleRequest);

        awsSessionCredentials = AwsSessionCredentials.create(
                assumeRoleResponse.credentials().accessKeyId(),
                assumeRoleResponse.credentials().secretAccessKey(),
                assumeRoleResponse.credentials().sessionToken()
        );

        sessionName = assumeRoleRequest.roleSessionName();

        logger.info("Assunção de role realizada com sucesso");

        return AppConfigClient.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(awsSessionCredentials))
                .build();
    }

    public AwsSessionCredentials getSessionCredentials() {
        return awsSessionCredentials;
    }

    public String getSessionName() {
        return sessionName;
    }
}