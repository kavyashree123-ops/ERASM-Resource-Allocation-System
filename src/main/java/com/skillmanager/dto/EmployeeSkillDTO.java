package com.skillmanager.dto;

public class EmployeeSkillDTO {

    private Long id;
    private String employeeName;
    private String skillName;
    private String skillLevel;
    private Integer yearsOfExperience;

    public EmployeeSkillDTO() {
    }

    public EmployeeSkillDTO(Long id,
                            String employeeName,
                            String skillName,
                            String skillLevel,
                            Integer yearsOfExperience) {

        this.id = id;
        this.employeeName = employeeName;
        this.skillName = skillName;
        this.skillLevel = skillLevel;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}