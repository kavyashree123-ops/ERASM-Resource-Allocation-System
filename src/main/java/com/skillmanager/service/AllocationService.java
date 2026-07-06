package com.skillmanager.service;

import java.util.List;

import com.skillmanager.dto.AllocationDTO;
import com.skillmanager.entity.Allocation;

public interface AllocationService {

    Allocation saveAllocation(Allocation allocation);

    List<AllocationDTO> getAllAllocations();

    AllocationDTO getAllocationById(Long id);

    Allocation updateAllocation(Long id, Allocation allocation);

    void deleteAllocation(Long id);

    Allocation releaseAllocation(Long id);

}