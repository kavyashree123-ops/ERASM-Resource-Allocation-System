package com.skillmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.skillmanager.dto.RecommendationResultDTO;
import com.skillmanager.dto.ResourceRequestDTO;
import com.skillmanager.entity.ResourceRequest;
import com.skillmanager.service.ResourceRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/resource-requests")
public class ResourceRequestController {

    @Autowired
    private ResourceRequestService resourceRequestService;

    @PostMapping
    public ResourceRequestDTO saveResourceRequest(
            @Valid @RequestBody ResourceRequest request) {

        ResourceRequest saved =
                resourceRequestService.saveResourceRequest(request);

        return resourceRequestService.getResourceRequestById(saved.getId());
    }

    @GetMapping
    public List<ResourceRequestDTO> getAllResourceRequests() {
        return resourceRequestService.getAllResourceRequests();
    }

    @GetMapping("/{id}")
    public ResourceRequestDTO getResourceRequestById(@PathVariable Long id) {
        return resourceRequestService.getResourceRequestById(id);
    }

    @PutMapping("/{id}")
    public ResourceRequestDTO updateResourceRequest(
            @PathVariable Long id,
            @Valid @RequestBody ResourceRequest request) {

        ResourceRequest updated =
                resourceRequestService.updateResourceRequest(id, request);

        if (updated == null) {
            return null;  
        }

        return resourceRequestService.getResourceRequestById(updated.getId());
    }

    @DeleteMapping("/{id}")
    public String deleteResourceRequest(@PathVariable Long id) {
        resourceRequestService.deleteResourceRequest(id);
        return "Resource Request deleted successfully";
    }
    @PutMapping("/{id}/approve")
    public ResourceRequestDTO approveRequest(@PathVariable Long id) {

        ResourceRequest approved =
                resourceRequestService.approveRequest(id);

        return resourceRequestService.getResourceRequestById(approved.getId());
    }

    @PutMapping("/{id}/reject")
    public ResourceRequestDTO rejectRequest(@PathVariable Long id) {

        ResourceRequest rejected =
                resourceRequestService.rejectRequest(id);

        return resourceRequestService.getResourceRequestById(rejected.getId());
    }
    @GetMapping("/{id}/recommendations")
    public List<RecommendationResultDTO>recommendEmployees(@PathVariable Long id) {
        return resourceRequestService.recommendEmployees(id);
    }
}