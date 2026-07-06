package com.skillmanager.dto;

public class RecommendationDTO {

    private Long employeeId;
    private String employeeName;
    private String skillName;
    private String skillLevel;
    private Integer experience;

    public RecommendationDTO() {
    }

    public RecommendationDTO(Long employeeId,
                             String employeeName,
                             String skillName,
                             String skillLevel,
                             Integer experience) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.skillName = skillName;
        this.skillLevel = skillLevel;
        this.experience = experience;
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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

}