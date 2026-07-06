package com.skillmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillmanager.dto.AllocationDTO;
import com.skillmanager.entity.Allocation;
import com.skillmanager.repository.AllocationRepository;
import com.skillmanager.service.AllocationService;
import com.skillmanager.service.AuditLogService;
import com.skillmanager.util.SecurityUtil;

@Service
public class AllocationServiceImpl implements AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    @Autowired
    private AuditLogService auditLogService;

    @Override
    public Allocation saveAllocation(Allocation allocation) {

        List<Allocation> allocations =
                allocationRepository.findByEmployeeId(
                        allocation.getEmployee().getId());

        int totalAllocation = allocation.getAllocationPercentage();


        for (Allocation a : allocations) {
            totalAllocation += a.getAllocationPercentage();
        }


        if (totalAllocation > 100) {
            throw new RuntimeException("Employee allocation exceeds 100%");
        }

        Allocation savedAllocation = allocationRepository.save(allocation);

        auditLogService.log(
                "CREATE",
                "Allocation",
                savedAllocation.getId(),
                SecurityUtil.getCurrentUser());

        return savedAllocation;
    }

    @Override
    public List<AllocationDTO> getAllAllocations() {

        List<Allocation> allocations = allocationRepository.findAll();

        return allocations.stream()
                .map(allocation -> new AllocationDTO(
                        allocation.getId(),
                        allocation.getEmployee().getUser().getName(),
                        allocation.getProject().getProjectName(),
                        allocation.getAllocationDate(),
                        allocation.getAllocationStatus()))
                .toList();
    }

    @Override
    public AllocationDTO getAllocationById(Long id) {

        Allocation allocation =
                allocationRepository.findById(id).orElse(null);

        if (allocation == null) {
            return null;
        }

        return new AllocationDTO(
                allocation.getId(),
                allocation.getEmployee().getUser().getName(),
                allocation.getProject().getProjectName(),
                allocation.getAllocationDate(),
                allocation.getAllocationStatus());
    }

    @Override
    public Allocation updateAllocation(Long id,
                                       Allocation allocation) {

        Allocation existing =
                allocationRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        List<Allocation> allocations =
                allocationRepository.findByEmployeeId(
                        allocation.getEmployee().getId());

        int totalAllocation = allocation.getAllocationPercentage();

        for (Allocation a : allocations) {

            if (!a.getId().equals(id)) {
                totalAllocation += a.getAllocationPercentage();
            }
        }

        if (totalAllocation > 100) {
            throw new RuntimeException(
                    "Employee allocation exceeds 100%");
        }

        existing.setEmployee(allocation.getEmployee());
        existing.setProject(allocation.getProject());
        existing.setAllocationDate(allocation.getAllocationDate());
        existing.setAllocationStatus(allocation.getAllocationStatus());
        existing.setAllocationPercentage(
                allocation.getAllocationPercentage());

        Allocation updatedAllocation = allocationRepository.save(existing);

        auditLogService.log(
                "UPDATE",
                "Allocation",
                updatedAllocation.getId(),
                SecurityUtil.getCurrentUser());

        return updatedAllocation;
    }

    @Override
    public void deleteAllocation(Long id) {

        allocationRepository.deleteById(id);

        auditLogService.log(
                "DELETE",
                "Allocation",
                id,
                SecurityUtil.getCurrentUser());
    }

    @Override
    public Allocation releaseAllocation(Long id) {

        Allocation allocation =
                allocationRepository.findById(id).orElse(null);

        if (allocation != null) {

            allocation.setAllocationStatus("RELEASED");

            Allocation releasedAllocation =
                    allocationRepository.save(allocation);

            auditLogService.log(
                    "RELEASE",
                    "Allocation",
                    releasedAllocation.getId(),
                    SecurityUtil.getCurrentUser());

            return releasedAllocation;
        }

        return null;
    }
}