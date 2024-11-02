package com.heitor.backend_bff.infrastructure.adapter;

import com.heitor.backend_bff.domain.model.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import software.amazon.awssdk.services.appconfig.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationAdapter {

    private final AppConfigClient appConfigClient;
    private final AppConfigSessionAdapter appConfigSessionAdapter;
    private static final Logger logger = LoggerFactory.getLogger(ApplicationAdapter.class);

    public ApplicationAdapter(AppConfigClient appConfigClient, AppConfigSessionAdapter appConfigSessionAdapter) {
        this.appConfigClient = appConfigClient;
        this.appConfigSessionAdapter = appConfigSessionAdapter;
    }

    public List<Application> getApplications() {
        logger.info("Nome da sessão: " + appConfigSessionAdapter.getSessionName());
        ListApplicationsRequest request = ListApplicationsRequest.builder().build();
        ListApplicationsResponse response = appConfigClient.listApplications(request);

        return response.items().stream().map(appSummary -> {
            Application app = new Application();
            app.setId(appSummary.id());
            app.setName(appSummary.name());
            return app;
        }).collect(Collectors.toList());
    }

    public void createAppConfig(Application appConfig) {
        CreateApplicationRequest request = CreateApplicationRequest.builder()
                .name(appConfig.getName())
                .build();

        CreateApplicationResponse response = appConfigClient.createApplication(request);

        // Lógica adicional para lidar com a resposta, se necessário
        appConfig.setId(response.id());
    }
}