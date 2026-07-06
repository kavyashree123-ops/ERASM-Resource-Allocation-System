package com.skillmanager.dto;

public class UtilizationDTO {

    private Long employeeId;
    private String employeeName;
    private int totalAllocation;
    private String status;

    public UtilizationDTO() {
    }

    public UtilizationDTO(Long employeeId,
                          String employeeName,
                          int totalAllocation,
                          String status) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.totalAllocation = totalAllocation;
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

    public int getTotalAllocation() {
        return totalAllocation;
    }

    public void setTotalAllocation(int totalAllocation) {
        this.totalAllocation = totalAllocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}