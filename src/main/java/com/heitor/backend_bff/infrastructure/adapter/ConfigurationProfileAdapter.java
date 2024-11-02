package com.heitor.backend_bff.infrastructure.adapter;

import com.heitor.backend_bff.domain.model.ConfigurationProfile;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import software.amazon.awssdk.services.appconfig.model.CreateConfigurationProfileRequest;
import software.amazon.awssdk.services.appconfig.model.CreateConfigurationProfileResponse;
import software.amazon.awssdk.services.appconfig.model.ListConfigurationProfilesRequest;
import software.amazon.awssdk.services.appconfig.model.ListConfigurationProfilesResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ConfigurationProfileAdapter {

    private final AppConfigClient appConfigClient;

    public ConfigurationProfileAdapter(AppConfigClient appConfigClient) {
        this.appConfigClient = appConfigClient;
    }

    public void createConfigurationProfile(ConfigurationProfile configurationProfile) {
        CreateConfigurationProfileRequest request = CreateConfigurationProfileRequest.builder()
                .applicationId(configurationProfile.getApplicationId())
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

    public List<ConfigurationProfile> getAllConfigurationProfiles() {
        ListConfigurationProfilesRequest request = ListConfigurationProfilesRequest.builder()
                .applicationId("your-application-id")
                .build();

        ListConfigurationProfilesResponse response = appConfigClient.listConfigurationProfiles(request);

        return response.items().stream()
                .map(profile -> {
                    ConfigurationProfile configurationProfile = new ConfigurationProfile();
                    configurationProfile.setId(profile.id());
                    configurationProfile.setName(profile.name());
                    return configurationProfile;
                })
                .collect(Collectors.toList());
    }
}