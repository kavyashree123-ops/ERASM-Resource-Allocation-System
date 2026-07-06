package com.skillmanager.dto;

import java.util.List;

public class SkillGapDTO {

    private String projectName;
    private List<String> requiredSkills;
    private List<String> availableSkills;
    private List<String> missingSkills;
    private List<String> recommendedEmployees;

    public SkillGapDTO() {
    }

    public SkillGapDTO(String projectName,
                       List<String> requiredSkills,
                       List<String> availableSkills,
                       List<String> missingSkills,
                       List<String> recommendedEmployees) {
        this.projectName = projectName;
        this.requiredSkills = requiredSkills;
        this.availableSkills = availableSkills;
        this.missingSkills = missingSkills;
        this.recommendedEmployees = recommendedEmployees;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public List<String> getAvailableSkills() {
        return availableSkills;
    }

    public void setAvailableSkills(List<String> availableSkills) {
        this.availableSkills = availableSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public List<String> getRecommendedEmployees() {
        return recommendedEmployees;
    }

    public void setRecommendedEmployees(List<String> recommendedEmployees) {
        this.recommendedEmployees = recommendedEmployees;
    }
}