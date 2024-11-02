package com.heitor.backend_bff.gateway.controller;

import com.heitor.backend_bff.domain.model.Application;
import com.heitor.backend_bff.application.use_cases.application.GetApplication;
import com.heitor.backend_bff.application.use_cases.application.CreateApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppConfigController {

    private final GetApplication getAppConfig;
    private final CreateApplication createAppConfig;

    public AppConfigController(GetApplication getAppConfig, CreateApplication createAppConfig) {
        this.getAppConfig = getAppConfig;
        this.createAppConfig = createAppConfig;
    }

    @GetMapping("/applications/{applicationId}")
    public List<Application> getAppConfig(@PathVariable String applicationId) {
        return getAppConfig.execute(applicationId);
    }

    @PostMapping("/applications")
    public void createAppConfig(@RequestBody Application appConfig) {
        createAppConfig.execute(appConfig);
    }
}