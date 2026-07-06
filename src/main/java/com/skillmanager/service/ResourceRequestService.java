package com.skillmanager.service;

import java.util.List;

import com.skillmanager.dto.RecommendationResultDTO;
import com.skillmanager.dto.ResourceRequestDTO;
import com.skillmanager.entity.ResourceRequest;

public interface ResourceRequestService {

    ResourceRequest saveResourceRequest(ResourceRequest request);

    List<ResourceRequestDTO> getAllResourceRequests();

    ResourceRequestDTO getResourceRequestById(Long id);

    ResourceRequest updateResourceRequest(Long id, ResourceRequest request);

    void deleteResourceRequest(Long id);
    ResourceRequest approveRequest(Long id);

    ResourceRequest rejectRequest(Long id);
    List<RecommendationResultDTO> recommendEmployees(Long requestId);
    String test();
}