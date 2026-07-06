package com.skillmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillmanager.entity.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {

    List<Allocation> findByEmployeeId(Long employeeId);

    List<Allocation> findByProjectId(Long projectId);

}