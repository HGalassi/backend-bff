package com.heitor.backend_bff.domain.model;

public class DeploymentStrategy {
    private String id;
    private String name;

    // Construtores, getters e setters
    public DeploymentStrategy() {}

    public DeploymentStrategy(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}