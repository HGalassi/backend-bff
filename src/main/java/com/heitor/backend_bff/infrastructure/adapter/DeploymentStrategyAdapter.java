package com.heitor.backend_bff.infrastructure.adapter;

import com.heitor.backend_bff.domain.model.DeploymentStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.appconfig.AppConfigClient;
import software.amazon.awssdk.services.appconfig.model.ListDeploymentStrategiesRequest;
import software.amazon.awssdk.services.appconfig.model.ListDeploymentStrategiesResponse;

import java.util.List;
import java.util.stream.Collectors;

public class DeploymentStrategyAdapter {

    private static final Logger logger = LoggerFactory.getLogger(DeploymentStrategyAdapter.class);
    private final AppConfigClient appConfigClient;

    public DeploymentStrategyAdapter(AppConfigClient appConfigClient) {
        this.appConfigClient = appConfigClient;
    }

    public List<DeploymentStrategy> listAllDeploymentStrategies() {
        ListDeploymentStrategiesRequest request = ListDeploymentStrategiesRequest.builder().build();
        ListDeploymentStrategiesResponse response = appConfigClient.listDeploymentStrategies(request);

        logger.info("Listando todas as estratégias de implantação");
        return response.items().stream()
                .map(strategy -> new DeploymentStrategy(strategy.id(), strategy.name()))
                .collect(Collectors.toList());
    }
}