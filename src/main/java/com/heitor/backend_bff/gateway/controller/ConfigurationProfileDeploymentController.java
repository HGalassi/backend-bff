package com.heitor.backend_bff.gateway.controller;

import com.heitor.backend_bff.domain.model.ConfigurationDeploy;
import com.heitor.backend_bff.domain.model.ConfigurationProfile;
import com.heitor.backend_bff.infrastructure.adapter.ConfigurationProfileDeploymentAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuration-profiles")
public class ConfigurationProfileDeploymentController {

    private final ConfigurationProfileDeploymentAdapter configurationProfileDeploymentAdapter;

    public ConfigurationProfileDeploymentController(ConfigurationProfileDeploymentAdapter configurationProfileDeploymentAdapter) {
        this.configurationProfileDeploymentAdapter = configurationProfileDeploymentAdapter;
    }

    @PostMapping("/deploy")
    public ResponseEntity<Void> deployNewVersion(@RequestBody ConfigurationDeploy configurationProfile) {
        configurationProfileDeploymentAdapter.deployNewVersion(configurationProfile);
        return ResponseEntity.ok().build();
    }
}