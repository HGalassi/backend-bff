package com.heitor.backend_bff.gateway.controller;

import com.heitor.backend_bff.domain.model.Environment;
import com.heitor.backend_bff.infrastructure.adapter.EnvironmentAdapter;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/environments")
public class EnvironmentController {

    private final EnvironmentAdapter environmentAdapter;

    public EnvironmentController(EnvironmentAdapter environmentAdapter) {
        this.environmentAdapter = environmentAdapter;
    }

    @PostMapping
    public ResponseEntity<Environment> createEnvironment(@RequestBody Environment environment) {
        environmentAdapter.createEnvironment(environment);
        return ResponseEntity.ok(environment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Environment> getEnvironmentById(@PathParam("environmentId") String id,@PathParam("applicationId") String applicationId) {
        Environment environment = environmentAdapter.getEnvironment(id,applicationId);
        return ResponseEntity.ok(environment);
    }

    @GetMapping
    public ResponseEntity<List<Environment>> getAllEnvironments(@PathParam("applicationId") String applicationId) {
        List<Environment> allEnvironments = environmentAdapter.getAllEnvironments(applicationId);
        return ResponseEntity.ok(allEnvironments);
    }
}