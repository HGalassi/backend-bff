package com.heitor.backend_bff.infrastructure.adapter;

import com.heitor.backend_bff.domain.model.Environment;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import software.amazon.awssdk.services.appconfig.model.CreateEnvironmentRequest;
import software.amazon.awssdk.services.appconfig.model.CreateEnvironmentResponse;
import software.amazon.awssdk.services.appconfig.model.GetEnvironmentRequest;
import software.amazon.awssdk.services.appconfig.model.GetEnvironmentResponse;
import software.amazon.awssdk.services.appconfig.model.ListEnvironmentsRequest;
import software.amazon.awssdk.services.appconfig.model.ListEnvironmentsResponse;

import java.util.List;
import java.util.stream.Collectors;

public class EnvironmentAdapter {

    private final AppConfigClient appConfigClient;

    public EnvironmentAdapter(AppConfigClient appConfigClient) {
        this.appConfigClient = appConfigClient;
    }

    public void createEnvironment(Environment environment) {
        CreateEnvironmentRequest request = CreateEnvironmentRequest.builder()
                .applicationId(environment.getApplicationId())
                .name(environment.getName())
                .build();

        CreateEnvironmentResponse response = appConfigClient.createEnvironment(request);

        // Lógica adicional para lidar com a resposta, se necessário
    }

    public Environment getEnvironment(String environmentId, String applicationId) {
        GetEnvironmentRequest request = GetEnvironmentRequest.builder()
                .applicationId(environmentId)
                .environmentId(applicationId)
                .build();

        GetEnvironmentResponse response = appConfigClient.getEnvironment(request);

        Environment output = new Environment();
        output.setId(response.id());
        output.setName(response.name());
        return output;
    }

    public List<Environment> getAllEnvironments(String applicationId) {
        ListEnvironmentsRequest request = ListEnvironmentsRequest.builder()
                .applicationId(applicationId)
                .build();

        ListEnvironmentsResponse response = appConfigClient.listEnvironments(request);

        return response.items().stream()
                .map(env -> {
                    Environment environment = new Environment();
                    environment.setId(env.id());
                    environment.setName(env.name());
                    return environment;
                })
                .collect(Collectors.toList());
    }
}