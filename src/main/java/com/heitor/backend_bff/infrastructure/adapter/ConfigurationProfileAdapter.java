package com.heitor.backend_bff.infrastructure.adapter;

import com.heitor.backend_bff.domain.model.ConfigurationProfile;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import software.amazon.awssdk.services.appconfig.model.CreateConfigurationProfileRequest;
import software.amazon.awssdk.services.appconfig.model.CreateConfigurationProfileResponse;

public class ConfigurationProfileAdapter {

    private final AppConfigClient appConfigClient;

    public ConfigurationProfileAdapter(AppConfigClient appConfigClient) {
        this.appConfigClient = appConfigClient;
    }

    public void createConfigurationProfile(ConfigurationProfile configurationProfile) {
        CreateConfigurationProfileRequest request = CreateConfigurationProfileRequest.builder()
                .applicationId("your-application-id")
                .name(configurationProfile.getName())
                .locationUri("hosted")
                .build();

        CreateConfigurationProfileResponse response = appConfigClient.createConfigurationProfile(request);

        // Lógica adicional para lidar com a resposta, se necessário
    }

    public ConfigurationProfile getConfigurationProfile(String configurationProfileId) {
        // Implementação para recuperar um configuration profile
        return new ConfigurationProfile(); // Exemplo de retorno
    }
}