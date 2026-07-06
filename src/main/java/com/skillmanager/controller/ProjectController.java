package com.skillmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillmanager.dto.ProjectDTO;
import com.skillmanager.dto.SkillGapDTO;
import com.skillmanager.entity.Project;
import com.skillmanager.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ProjectDTO saveProject(@Valid @RequestBody Project project) {

        Project saved = projectService.saveProject(project);

        return projectService.getProjectById(saved.getId());
    }

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id,
            @Valid @RequestBody Project project) {

        System.out.println("Incoming Manager = " + project.getManager());

        if (project.getManager() != null) {
            System.out.println("Incoming Manager Id = " + project.getManager().getId());
        }

        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "Project deleted successfully";
    }
    
    @PutMapping("/{projectId}/skills")
    public Project assignSkills(@PathVariable Long projectId,
                                @RequestBody List<Long> skillIds) {

        return projectService.assignSkills(projectId, skillIds);
    }
    
    @GetMapping("/{projectId}/skill-gap")
    public SkillGapDTO getSkillGap(@PathVariable Long projectId) {

        return projectService.getSkillGap(projectId);
    }
}