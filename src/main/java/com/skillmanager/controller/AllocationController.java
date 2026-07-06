package com.skillmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillmanager.dto.AllocationDTO;
import com.skillmanager.entity.Allocation;
import com.skillmanager.service.AllocationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/allocations")
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    @PostMapping
    public AllocationDTO saveAllocation(@Valid @RequestBody Allocation allocation) {

        Allocation saved = allocationService.saveAllocation(allocation);

        return allocationService.getAllocationById(saved.getId());
    }

    @GetMapping
    public List<AllocationDTO> getAllAllocations() {
        return allocationService.getAllAllocations();
    }

    @GetMapping("/{id}")
    public AllocationDTO getAllocationById(@PathVariable Long id) {
        return allocationService.getAllocationById(id);
    }

    @PutMapping("/{id}")
    public AllocationDTO updateAllocation(@PathVariable Long id,
                                          @Valid @RequestBody Allocation allocation) {

        Allocation updated = allocationService.updateAllocation(id, allocation);

        return allocationService.getAllocationById(updated.getId());
    }

    @DeleteMapping("/{id}")
    public String deleteAllocation(@PathVariable Long id) {
        allocationService.deleteAllocation(id);
        return "Allocation deleted successfully";
    }
    @PutMapping("/{id}/release")
    public AllocationDTO releaseAllocation(@PathVariable Long id) {

        Allocation released = allocationService.releaseAllocation(id);

        return allocationService.getAllocationById(released.getId());
    }
}