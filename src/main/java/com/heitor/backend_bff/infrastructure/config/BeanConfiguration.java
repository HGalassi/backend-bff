package com.heitor.backend_bff.infrastructure.config;

import com.heitor.backend_bff.application.use_cases.application.GetApplication;
import com.heitor.backend_bff.application.use_cases.application.CreateApplication;
import com.heitor.backend_bff.infrastructure.adapter.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
@Configuration
public class BeanConfiguration {

    @Value("${aws.roleArn}")
    private String roleArn;
    @Bean
    public AppConfigSessionAdapter appConfigSessionAdapter() {
        AppConfigSessionAdapter appConfigSessionAdapter = new AppConfigSessionAdapter(roleArn, Region.SA_EAST_1);
        appConfigSessionAdapter.createSession();
        return appConfigSessionAdapter;
    }
    @Bean
    public EnvironmentAdapter environmentAdapter() {
        return new EnvironmentAdapter(appConfigClient());
    }
    @Bean
    public DeploymentStrategyAdapter deploymentStrategyAdapter() {
        return new DeploymentStrategyAdapter(appConfigClient());
    }
    @Bean
    public ConfigurationProfileDeploymentAdapter configurationProfileDeploymentAdapter() {
        return new ConfigurationProfileDeploymentAdapter(appConfigClient());
    }

    @Bean
    public ConfigurationProfileAdapter configurationProfileAdapter() {
        return new ConfigurationProfileAdapter(appConfigClient());
    }
    @Bean
    public AppConfigClient appConfigClient() {
        return AppConfigClient.builder().build();
    }

    @Bean
    public ApplicationAdapter appConfigAdapter(AppConfigClient appConfigClient) {
        return new ApplicationAdapter(appConfigClient, appConfigSessionAdapter());
    }

    @Bean
    public GetApplication getAppConfig(ApplicationAdapter appConfigAdapter) {
        return new GetApplication(appConfigAdapter);
    }

    @Bean
    public CreateApplication createAppConfig(ApplicationAdapter appConfigAdapter) {
        return new CreateApplication(appConfigAdapter);
    }
}