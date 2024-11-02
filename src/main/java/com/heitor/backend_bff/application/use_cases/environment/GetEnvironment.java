package com.heitor.backend_bff.application.use_cases.environment;

import com.heitor.backend_bff.domain.model.Environment;
import com.heitor.backend_bff.infrastructure.adapter.EnvironmentAdapter;

public class GetEnvironment {

    private final EnvironmentAdapter environmentAdapter;

    public GetEnvironment(EnvironmentAdapter environmentAdapter) {
        this.environmentAdapter = environmentAdapter;
    }

    public Environment execute(String environmentId) {
        return environmentAdapter.getEnvironment(environmentId);
    }
}