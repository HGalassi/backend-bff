package com.heitor.backend_bff.application.use_cases.configuration_profile;

import com.heitor.backend_bff.domain.model.ConfigurationProfile;
import com.heitor.backend_bff.infrastructure.adapter.ConfigurationProfileAdapter;

public class GetConfigurationProfile {

    private final ConfigurationProfileAdapter configurationProfileAdapter;

    public GetConfigurationProfile(ConfigurationProfileAdapter configurationProfileAdapter) {
        this.configurationProfileAdapter = configurationProfileAdapter;
    }

    public ConfigurationProfile execute(String configurationProfileId) {
        return configurationProfileAdapter.getConfigurationProfile(configurationProfileId);
    }
}