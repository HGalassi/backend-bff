package com.heitor.backend_bff.application.use_cases.application;

import com.heitor.backend_bff.domain.model.Application;
import com.heitor.backend_bff.infrastructure.adapter.ApplicationAdapter;

import java.util.List;

public class GetApplication {

    private final ApplicationAdapter appConfigAdapter;

    public GetApplication(ApplicationAdapter appConfigAdapter) {
        this.appConfigAdapter = appConfigAdapter;
    }

    public List<Application> execute(String configId) {
        return appConfigAdapter.getApplications();
    }
}