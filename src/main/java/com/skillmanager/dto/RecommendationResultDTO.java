package com.skillmanager.dto;

public class RecommendationResultDTO {

    private Long employeeId;
    private String employeeName;
    private String skill;
    private String skillLevel;
    private Integer experience;
    private Integer allocation;
    private Integer recommendationScore;

    public RecommendationResultDTO() {
    }

    public RecommendationResultDTO(Long employeeId,
                                   String employeeName,
                                   String skill,
                                   String skillLevel,
                                   Integer experience,
                                   Integer allocation,
                                   Integer recommendationScore) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.skill = skill;
        this.skillLevel = skillLevel;
        this.experience = experience;
        this.allocation = allocation;
        this.recommendationScore = recommendationScore;
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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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

    public Integer getAllocation() {
        return allocation;
    }

    public void setAllocation(Integer allocation) {
        this.allocation = allocation;
    }

    public Integer getRecommendationScore() {
        return recommendationScore;
    }

    public void setRecommendationScore(Integer recommendationScore) {
        this.recommendationScore = recommendationScore;
    }
}