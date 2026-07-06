package com.skillmanager.dto;

import java.time.LocalDate;

public class ResourceRequestDTO {

    private Long id;
    private String projectName;
    private String requiredSkill;
    private Integer numberOfEmployees;
    private String priority;
    private String status;
    private LocalDate requestedDate;

    public ResourceRequestDTO() {
    }

    public ResourceRequestDTO(Long id,
                              String projectName,
                              String requiredSkill,
                              Integer numberOfEmployees,
                              String priority,
                              String status,
                              LocalDate requestedDate) {

        this.id = id;
        this.projectName = projectName;
        this.requiredSkill = requiredSkill;
        this.numberOfEmployees = numberOfEmployees;
        this.priority = priority;
        this.status = status;
        this.requestedDate = requestedDate;
    }

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getRequestedDate() {
        return requestedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRequestedDate(LocalDate requestedDate) {
        this.requestedDate = requestedDate;
    }
}