package com.skillmanager.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillmanager.dto.ProjectDTO;
import com.skillmanager.dto.SkillGapDTO;
import com.skillmanager.entity.Employee;
import com.skillmanager.entity.EmployeeSkill;
import com.skillmanager.entity.Project;
import com.skillmanager.entity.Skill;
import com.skillmanager.repository.EmployeeRepository;
import com.skillmanager.repository.EmployeeSkillRepository;
import com.skillmanager.repository.ProjectRepository;
import com.skillmanager.repository.SkillRepository;
import com.skillmanager.service.AuditLogService;
import com.skillmanager.service.ProjectService;
import com.skillmanager.util.SecurityUtil;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private AuditLogService auditLogService;
    
    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    @Override
    public Project saveProject(Project project) {

        Project savedProject = projectRepository.save(project);

        auditLogService.log(
                "CREATE",
                "Project",
                savedProject.getId(),
                SecurityUtil.getCurrentUser());

        return savedProject;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {

        List<Project> projects = projectRepository.findAll();

        return projects.stream()
                .map(project -> new ProjectDTO(
                        project.getId(),
                        project.getProjectName(),
                        project.getDescription(),
                        project.getClientName(),
                        project.getTechnologyStack(),
                        project.getBudget(),
                        project.getStartDate(),
                        project.getEndDate(),
                        project.getStatus(),
                        project.getManager().getUser().getName()))
                .toList();
    }

    @Override
    public ProjectDTO getProjectById(Long id) {

        Project project = projectRepository.findById(id).orElse(null);

        if (project == null) {
            return null;
        }

        return new ProjectDTO(
                project.getId(),
                project.getProjectName(),
                project.getDescription(),
                project.getClientName(),
                project.getTechnologyStack(),
                project.getBudget(),
                project.getStartDate(),
                project.getEndDate(),
                project.getStatus(),
                project.getManager().getUser().getName());
    }

    @Override
    public Project updateProject(Long id, Project project) {

        Project existingProject = projectRepository.findById(id).orElse(null);

        if (existingProject != null) {

            existingProject.setProjectName(project.getProjectName());
            existingProject.setDescription(project.getDescription());
            existingProject.setStartDate(project.getStartDate());
            existingProject.setEndDate(project.getEndDate());
            existingProject.setStatus(project.getStatus());
            existingProject.setManager(project.getManager());
            if (project.getManager() != null) {

                Employee manager = employeeRepository
                        .findById(project.getManager().getId())
                        .orElse(null);

                existingProject.setManager(manager);
            }
            existingProject.setClientName(project.getClientName());
            existingProject.setTechnologyStack(project.getTechnologyStack());
            existingProject.setBudget(project.getBudget());

            Project updatedProject = projectRepository.save(existingProject);

            auditLogService.log(
                    "UPDATE",
                    "Project",
                    updatedProject.getId(),
                    SecurityUtil.getCurrentUser());

            return updatedProject;
        }

        return null;
    }

    @Override
    public void deleteProject(Long id) {

        projectRepository.deleteById(id);

        auditLogService.log(
                "DELETE",
                "Project",
                id,
                SecurityUtil.getCurrentUser());
    }
    
    @Override
    public Project assignSkills(Long projectId, List<Long> skillIds) {

        Project project =
                projectRepository.findById(projectId).orElse(null);

        if (project == null) {
            return null;
        }

        List<Skill> skills =
                skillRepository.findAllById(skillIds);

        project.setRequiredSkills(skills);

        return projectRepository.save(project);
    }
    
    @Override
    public SkillGapDTO getSkillGap(Long projectId) {

        Project project = projectRepository.findById(projectId).orElse(null);

        if (project == null) {
            return null;
        }

        List<Skill> requiredSkills = project.getRequiredSkills();

        List<String> required = new ArrayList<>();
        List<String> available = new ArrayList<>();
        List<String> missing = new ArrayList<>();

        Set<String> recommendedEmployees = new HashSet<>();

        List<EmployeeSkill> employeeSkills =
                employeeSkillRepository.findAll();

        for (Skill skill : requiredSkills) {

            required.add(skill.getSkillName());

            boolean found = false;

            for (EmployeeSkill es : employeeSkills) {

                if (es.getSkill().getId().equals(skill.getId())) {

                    found = true;

                    recommendedEmployees.add(
                            es.getEmployee()
                              .getUser()
                              .getName());

                }
            }

            if (found) {
                available.add(skill.getSkillName());
            } else {
                missing.add(skill.getSkillName());
            }
        }

        return new SkillGapDTO(
                project.getProjectName(),
                required,
                available,
                missing,
                new ArrayList<>(recommendedEmployees));
    }
}