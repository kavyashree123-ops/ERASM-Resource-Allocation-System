package com.skillmanager.dto;

import java.time.LocalDate;

public class AllocationDTO {

    private Long id;
    private String employeeName;
    private String projectName;
    private LocalDate allocationDate;
    private String allocationStatus;

    public AllocationDTO() {
    }

    public AllocationDTO(Long id, String employeeName, String projectName,
                         LocalDate allocationDate, String allocationStatus) {
        this.id = id;
        this.employeeName = employeeName;
        this.projectName = projectName;
        this.allocationDate = allocationDate;
        this.allocationStatus = allocationStatus;
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public LocalDate getAllocationDate() {
        return allocationDate;
    }

    public String getAllocationStatus() {
        return allocationStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setAllocationDate(LocalDate allocationDate) {
        this.allocationDate = allocationDate;
    }

    public void setAllocationStatus(String allocationStatus) {
        this.allocationStatus = allocationStatus;
    }
}