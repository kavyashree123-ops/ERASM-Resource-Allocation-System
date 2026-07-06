package com.skillmanager.dto;

import java.time.LocalDate;

public class ProjectDTO {

    private Long id;
    private String projectName;
    private String description;
    private String clientName;
    private String technologyStack;
    private Double budget;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String managerName;

    public ProjectDTO() {
    }

    public ProjectDTO(Long id,
                      String projectName,
                      String description,
                      String clientName,
                      String technologyStack,
                      Double budget,
                      LocalDate startDate,
                      LocalDate endDate,
                      String status,
                      String managerName) {

        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.clientName = clientName;
        this.technologyStack = technologyStack;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.managerName = managerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getTechnologyStack() {
        return technologyStack;
    }

    public void setTechnologyStack(String technologyStack) {
        this.technologyStack = technologyStack;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}