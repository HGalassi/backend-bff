package com.heitor.backend_bff.application.use_cases.environment;

import com.heitor.backend_bff.domain.model.Environment;
import com.heitor.backend_bff.infrastructure.adapter.EnvironmentAdapter;

public class CreateEnvironment {

    private final EnvironmentAdapter environmentAdapter;

    public CreateEnvironment(EnvironmentAdapter environmentAdapter) {
        this.environmentAdapter = environmentAdapter;
    }

    public void execute(Environment environment) {
        environmentAdapter.createEnvironment(environment);
    }
}