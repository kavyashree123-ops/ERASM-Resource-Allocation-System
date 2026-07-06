package com.skillmanager.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.skillmanager.dto.RecommendationResultDTO;
import com.skillmanager.dto.ResourceRequestDTO;
import com.skillmanager.entity.Allocation;
import com.skillmanager.entity.EmployeeSkill;
import com.skillmanager.entity.ResourceRequest;
import com.skillmanager.repository.AllocationRepository;
import com.skillmanager.repository.EmployeeSkillRepository;
import com.skillmanager.repository.ResourceRequestRepository;
import com.skillmanager.service.AuditLogService;
import com.skillmanager.service.ResourceRequestService;
import com.skillmanager.util.SecurityUtil;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    @Autowired
    private ResourceRequestRepository resourceRequestRepository;

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    @Autowired
    private AuditLogService auditLogService;
    
    @Autowired
    private AllocationRepository allocationRepository;

    @Override
    public ResourceRequest saveResourceRequest(ResourceRequest request) {

        ResourceRequest savedRequest =
                resourceRequestRepository.save(request);

        auditLogService.log(
                "CREATE",
                "ResourceRequest",
                savedRequest.getId(),
                SecurityUtil.getCurrentUser());

        return savedRequest;
    }

    @Override
    public List<ResourceRequestDTO> getAllResourceRequests() {

        List<ResourceRequest> requests = resourceRequestRepository.findAll();

        return requests.stream()
                .map(request -> new ResourceRequestDTO(
                        request.getId(),
                        request.getProject().getProjectName(),
                        request.getRequiredSkill().getSkillName(),
                        request.getNumberOfEmployees(),
                        request.getPriority(),
                        request.getStatus(),
                        request.getRequestedDate()))
                .toList();
    }

    @Override
    public ResourceRequestDTO getResourceRequestById(Long id) {

        ResourceRequest request =
                resourceRequestRepository.findById(id).orElse(null);

        if (request == null) {
            return null;
        }

        return new ResourceRequestDTO(
                request.getId(),
                request.getProject().getProjectName(),
                request.getRequiredSkill().getSkillName(),
                request.getNumberOfEmployees(),
                request.getPriority(),
                request.getStatus(),
                request.getRequestedDate());
    }

    @Override
    public ResourceRequest updateResourceRequest(Long id,
                                                 ResourceRequest request) {

        ResourceRequest existing =
                resourceRequestRepository.findById(id).orElse(null);

        if (existing != null) {

            existing.setProject(request.getProject());
            existing.setRequiredSkill(request.getRequiredSkill());
            existing.setNumberOfEmployees(request.getNumberOfEmployees());
            existing.setPriority(request.getPriority());
            existing.setStatus(request.getStatus());
            existing.setRequestedDate(request.getRequestedDate());

            ResourceRequest updatedRequest =
                    resourceRequestRepository.save(existing);

            auditLogService.log(
                    "UPDATE",
                    "ResourceRequest",
                    updatedRequest.getId(),
                    SecurityUtil.getCurrentUser());

            return updatedRequest;
        }

        return null;
    }

    @Override
    public void deleteResourceRequest(Long id) {

        resourceRequestRepository.deleteById(id);

        auditLogService.log(
                "DELETE",
                "ResourceRequest",
                id,
                SecurityUtil.getCurrentUser());
    }

    @Override
    public ResourceRequest approveRequest(Long id) {

        ResourceRequest request =
                resourceRequestRepository.findById(id).orElse(null);

        if (request != null) {

            request.setStatus("APPROVED");

            ResourceRequest approved =
                    resourceRequestRepository.save(request);

            auditLogService.log(
                    "APPROVE",
                    "ResourceRequest",
                    approved.getId(),
                    SecurityUtil.getCurrentUser());

            return approved;
        }

        return null;
    }

    @Override
    public ResourceRequest rejectRequest(Long id) {

        ResourceRequest request =
                resourceRequestRepository.findById(id).orElse(null);

        if (request != null) {

            request.setStatus("REJECTED");

            ResourceRequest rejected =
                    resourceRequestRepository.save(request);

            auditLogService.log(
                    "REJECT",
                    "ResourceRequest",
                    rejected.getId(),
                    SecurityUtil.getCurrentUser());

            return rejected;
        }

        return null;
    }

    @Override
    public List<RecommendationResultDTO> recommendEmployees(Long requestId) {

        ResourceRequest request =
                resourceRequestRepository.findById(requestId).orElse(null);

        if (request == null) {
            return List.of();
        }

        String requiredSkill =
                request.getRequiredSkill().getSkillName();

        List<EmployeeSkill> employeeSkills =
                employeeSkillRepository.findBySkillSkillName(requiredSkill);

        return employeeSkills.stream()
                .map(es -> {

                    int score = 0;

                    // Skill Level
                    switch (es.getSkillLevel().toUpperCase()) {

                        case "EXPERT":
                            score += 40;
                            break;

                        case "INTERMEDIATE":
                            score += 25;
                            break;

                        default:
                            score += 10;
                    }

                    // Experience
                    Integer experience = es.getEmployee().getExperience();

                    if (experience != null) {
                        score += Math.min(experience * 2, 20);
                    } else {
                        experience = 0;
                    }

                    // Allocation
                    List<Allocation> allocations =
                            allocationRepository.findByEmployeeId(
                                    es.getEmployee().getId());

                    int allocation = allocations.stream()
                            .mapToInt(Allocation::getAllocationPercentage)
                            .sum();

                    if (allocation == 0) {
                        score += 20;
                    } else if (allocation <= 50) {
                        score += 10;
                    } else if (allocation < 100) {
                        score += 5;
                    }

                    return new RecommendationResultDTO(
                            es.getEmployee().getId(),
                            es.getEmployee().getUser().getName(),
                            es.getSkill().getSkillName(),
                            es.getSkillLevel(),
                            experience,
                            allocation,
                            score
                    );

                })
                .sorted(Comparator.comparing(
                        RecommendationResultDTO::getRecommendationScore)
                        .reversed())
                .toList();
    }

    @Override
    public String test() {
        return null;
    }
}