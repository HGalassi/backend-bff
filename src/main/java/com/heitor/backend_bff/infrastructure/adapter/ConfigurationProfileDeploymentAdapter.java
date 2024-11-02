package com.heitor.backend_bff.infrastructure.adapter;

import com.heitor.backend_bff.domain.model.ConfigurationDeploy;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import software.amazon.awssdk.services.appconfig.model.CreateHostedConfigurationVersionRequest;
import software.amazon.awssdk.services.appconfig.model.CreateHostedConfigurationVersionResponse;
import software.amazon.awssdk.services.appconfig.model.StartDeploymentRequest;
import software.amazon.awssdk.services.appconfig.model.StartDeploymentResponse;

public class ConfigurationProfileDeploymentAdapter {

    private final AppConfigClient appConfigClient;

    public ConfigurationProfileDeploymentAdapter(AppConfigClient appConfigClient) {
        this.appConfigClient = appConfigClient;
    }

    public void deployNewVersion(ConfigurationDeploy configurationProfile) {
        // Cria uma nova versão do hosted configuration
        CreateHostedConfigurationVersionRequest createRequest = CreateHostedConfigurationVersionRequest.builder()
                .applicationId(configurationProfile.getApplicationId())
                .configurationProfileId(configurationProfile.getConfigurationProfileId())
                .content(SdkBytes.fromByteArray(configurationProfile.getValue().getBytes()))
                .contentType("text/plain") // ou "application/json" dependendo do tipo de conteúdo
                .build();

        CreateHostedConfigurationVersionResponse createResponse = appConfigClient.createHostedConfigurationVersion(createRequest);

        // Inicia o deployment da nova versão criada
        StartDeploymentRequest startRequest = StartDeploymentRequest.builder()
                .applicationId(configurationProfile.getApplicationId())
                .configurationProfileId(configurationProfile.getConfigurationProfileId())
                .configurationVersion(createResponse.versionNumber().toString())
                .environmentId(configurationProfile.getEnvironmentId())
                .deploymentStrategyId(configurationProfile.getDeploymentStrategyId())
                .build();

        StartDeploymentResponse startResponse = appConfigClient.startDeployment(startRequest);

        // Lógica adicional para lidar com a resposta, se necessário
    }
}