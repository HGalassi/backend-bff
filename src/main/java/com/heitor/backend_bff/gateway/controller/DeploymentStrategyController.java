package com.heitor.backend_bff.gateway.controller;

import com.heitor.backend_bff.domain.model.DeploymentStrategy;
import com.heitor.backend_bff.infrastructure.adapter.DeploymentStrategyAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deployment-strategies")
public class DeploymentStrategyController {

    private final DeploymentStrategyAdapter deploymentStrategyAdapter;

    public DeploymentStrategyController(DeploymentStrategyAdapter deploymentStrategyAdapter) {
        this.deploymentStrategyAdapter = deploymentStrategyAdapter;
    }

    @GetMapping
    public List<DeploymentStrategy> listAllDeploymentStrategies() {
        return deploymentStrategyAdapter.listAllDeploymentStrategies();
    }
}