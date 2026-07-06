package com.skillmanager.service;

import java.util.List;

import com.skillmanager.dto.ProjectDTO;
import com.skillmanager.dto.SkillGapDTO;
import com.skillmanager.entity.Project;

public interface ProjectService {

    Project saveProject(Project project);

    List<ProjectDTO> getAllProjects();

    ProjectDTO getProjectById(Long id);

    Project updateProject(Long id, Project project);

    void deleteProject(Long id);
    
    Project assignSkills(Long projectId, List<Long> skillIds);
    
    SkillGapDTO getSkillGap(Long projectId);
}