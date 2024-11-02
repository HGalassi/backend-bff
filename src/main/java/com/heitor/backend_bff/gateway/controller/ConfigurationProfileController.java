package com.heitor.backend_bff.gateway.controller;

import com.heitor.backend_bff.domain.model.ConfigurationProfile;
import com.heitor.backend_bff.infrastructure.adapter.ConfigurationProfileAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration-profiles")
public class ConfigurationProfileController {

    private final ConfigurationProfileAdapter configurationProfileAdapter;

    public ConfigurationProfileController(ConfigurationProfileAdapter configurationProfileAdapter) {
        this.configurationProfileAdapter = configurationProfileAdapter;
    }

    @PostMapping
    public ResponseEntity<ConfigurationProfile> createConfigurationProfile(@RequestBody ConfigurationProfile configurationProfile) {
        configurationProfileAdapter.createConfigurationProfile(configurationProfile);
        return ResponseEntity.ok(configurationProfile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfigurationProfile> getConfigurationProfileById(@PathVariable String id) {
        ConfigurationProfile configurationProfile = configurationProfileAdapter.getConfigurationProfile(id);
        return ResponseEntity.ok(configurationProfile);
    }

    @GetMapping
    public ResponseEntity<List<ConfigurationProfile>> getAllConfigurationProfiles() {
        List<ConfigurationProfile> allConfigurationProfiles = configurationProfileAdapter.getAllConfigurationProfiles();
        return ResponseEntity.ok(allConfigurationProfiles);
    }
}