package com.skillmanager.dto;

import java.util.List;

public class DashboardSummaryDTO {

    private long totalEmployees;
    private long allocatedEmployees;
    private long benchEmployees;

    private double billablePercentage;
    private double benchPercentage;

    private long fullyUtilizedEmployees;
    private long partiallyUtilizedEmployees;

    private List<EmployeeDashboardDTO> employeeStatus;

    public DashboardSummaryDTO() {
    }

    public DashboardSummaryDTO(long totalEmployees,
            long allocatedEmployees,
            long benchEmployees,
            double billablePercentage,
            double benchPercentage,
            long fullyUtilizedEmployees,
            long partiallyUtilizedEmployees,
            List<EmployeeDashboardDTO> employeeStatus) {

this.totalEmployees = totalEmployees;
this.allocatedEmployees = allocatedEmployees;
this.benchEmployees = benchEmployees;
this.billablePercentage = billablePercentage;
this.benchPercentage = benchPercentage;
this.fullyUtilizedEmployees = fullyUtilizedEmployees;
this.partiallyUtilizedEmployees = partiallyUtilizedEmployees;
this.employeeStatus = employeeStatus;
}

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public long getAllocatedEmployees() {
        return allocatedEmployees;
    }

    public void setAllocatedEmployees(long allocatedEmployees) {
        this.allocatedEmployees = allocatedEmployees;
    }

    public long getBenchEmployees() {
        return benchEmployees;
    }

    public void setBenchEmployees(long benchEmployees) {
        this.benchEmployees = benchEmployees;
    }

    public double getBillablePercentage() {
        return billablePercentage;
    }

    public void setBillablePercentage(double billablePercentage) {
        this.billablePercentage = billablePercentage;
    }

    public double getBenchPercentage() {
        return benchPercentage;
    }

    public void setBenchPercentage(double benchPercentage) {
        this.benchPercentage = benchPercentage;
    }

    public long getFullyUtilizedEmployees() {
        return fullyUtilizedEmployees;
    }

    public void setFullyUtilizedEmployees(long fullyUtilizedEmployees) {
        this.fullyUtilizedEmployees = fullyUtilizedEmployees;
    }

    public long getPartiallyUtilizedEmployees() {
        return partiallyUtilizedEmployees;
    }

    public void setPartiallyUtilizedEmployees(long partiallyUtilizedEmployees) {
        this.partiallyUtilizedEmployees = partiallyUtilizedEmployees;
    }

    public List<EmployeeDashboardDTO> getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(List<EmployeeDashboardDTO> employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
}