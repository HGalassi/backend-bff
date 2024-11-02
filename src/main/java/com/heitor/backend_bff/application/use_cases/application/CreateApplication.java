package com.heitor.backend_bff.application.use_cases.application;

import com.heitor.backend_bff.domain.model.Application;
import com.heitor.backend_bff.infrastructure.adapter.ApplicationAdapter;

public class CreateApplication {

    private final ApplicationAdapter appConfigAdapter;

    public CreateApplication(ApplicationAdapter appConfigAdapter) {
        this.appConfigAdapter = appConfigAdapter;
    }

    public void execute(Application appConfig) {
        appConfigAdapter.createAppConfig(appConfig);
    }
}