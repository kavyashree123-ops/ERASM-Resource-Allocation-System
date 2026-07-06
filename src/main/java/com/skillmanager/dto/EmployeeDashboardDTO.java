package com.skillmanager.dto;

public class EmployeeDashboardDTO {

    private Long employeeId;
    private String employeeName;
    private Integer allocation;
    private String status;

    public EmployeeDashboardDTO() {
    }

    public EmployeeDashboardDTO(Long employeeId,
                                String employeeName,
                                Integer allocation,
                                String status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.allocation = allocation;
        this.status = status;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getAllocation() {
        return allocation;
    }

    public void setAllocation(Integer allocation) {
        this.allocation = allocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}