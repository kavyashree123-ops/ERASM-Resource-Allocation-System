package com.skillmanager.dto;

public class EmployeeDTO {

    private Long id;
    private String employeeCode;
    private String department;
    private String designation;
    private int experience;
    private String userName;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String employeeCode,
                       String department,
                       String designation,
                       int experience,
                       String userName) {

        this.id = id;
        this.employeeCode = employeeCode;
        this.department = department;
        this.designation = designation;
        this.experience = experience;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}