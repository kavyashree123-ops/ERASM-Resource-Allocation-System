package com.skillmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillmanager.entity.ResourceRequest;

public interface ResourceRequestRepository extends JpaRepository<ResourceRequest, Long> {

    List<ResourceRequest> findByProjectId(Long projectId);

    List<ResourceRequest> findByStatus(String status);

}