package com.heitor.backend_bff.infrastructure.adapter;

import com.heitor.backend_bff.domain.model.Environment;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import software.amazon.awssdk.services.appconfig.model.CreateEnvironmentRequest;
import software.amazon.awssdk.services.appconfig.model.CreateEnvironmentResponse;

public class EnvironmentAdapter {

    private final AppConfigClient appConfigClient;

    public EnvironmentAdapter(AppConfigClient appConfigClient) {
        this.appConfigClient = appConfigClient;
    }

    public void createEnvironment(Environment environment) {
        CreateEnvironmentRequest request = CreateEnvironmentRequest.builder()
                .applicationId("your-application-id")
                .name(environment.getName())
                .build();

        CreateEnvironmentResponse response = appConfigClient.createEnvironment(request);

        // Lógica adicional para lidar com a resposta, se necessário
    }

    public Environment getEnvironment(String environmentId) {
        // Implementação para recuperar um environment
        return new Environment(); // Exemplo de retorno
    }
}