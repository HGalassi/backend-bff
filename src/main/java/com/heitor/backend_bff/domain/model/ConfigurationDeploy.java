package com.heitor.backend_bff.domain.model;

public class ConfigurationDeploy {
    private String applicationId;
    private String name;
    private String version;
    private String configurationProfileId;
    private String key;
    private String value;
    private String environmentId;

    private String deploymentStrategyId;

    public String getDeploymentStrategyId() {
        return deploymentStrategyId;
    }

    public void setDeploymentStrategyId(String deploymentStrategyId) {
        this.deploymentStrategyId = deploymentStrategyId;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
    }

    // Getters and setters
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getConfigurationProfileId() {
        return configurationProfileId;
    }

    public void setConfigurationProfileId(String configurationProfileId) {
        this.configurationProfileId = configurationProfileId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}