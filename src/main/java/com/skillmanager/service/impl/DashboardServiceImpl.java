package com.skillmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillmanager.dto.DashboardSummaryDTO;
import com.skillmanager.dto.EmployeeDashboardDTO;
import com.skillmanager.entity.Allocation;
import com.skillmanager.entity.Employee;
import com.skillmanager.repository.AllocationRepository;
import com.skillmanager.repository.EmployeeRepository;
import com.skillmanager.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AllocationRepository allocationRepository;

    @Override
    public DashboardSummaryDTO getDashboardSummary() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDashboardDTO> employeeStatus = new ArrayList<>();

        long totalEmployees = employees.size();

        long allocatedEmployees = 0;
        long benchEmployees = 0;

        long fullyUtilizedEmployees = 0;
        long partiallyUtilizedEmployees = 0;

        for (Employee employee : employees) {

            List<Allocation> allocations =
                    allocationRepository.findByEmployeeId(employee.getId());

            int totalAllocation = allocations.stream()
                    .filter(a -> "ALLOCATED".equalsIgnoreCase(a.getAllocationStatus()))
                    .mapToInt(Allocation::getAllocationPercentage)
                    .sum();

            String status;

            if (totalAllocation == 0) {

                status = "Bench";
                benchEmployees++;

            } else {

                allocatedEmployees++;

                if (totalAllocation >= 100) {

                    status = "Fully Utilized";
                    fullyUtilizedEmployees++;

                } else {

                    status = "Partially Utilized";
                    partiallyUtilizedEmployees++;
                }
            }

            employeeStatus.add(
                    new EmployeeDashboardDTO(
                            employee.getId(),
                            employee.getUser().getName(),
                            totalAllocation,
                            status));
        }

        double billablePercentage = 0;
        double benchPercentage = 0;

        if (totalEmployees > 0) {

            billablePercentage =
                    (allocatedEmployees * 100.0) / totalEmployees;

            benchPercentage =
                    (benchEmployees * 100.0) / totalEmployees;
        }

        return new DashboardSummaryDTO(
                totalEmployees,
                allocatedEmployees,
                benchEmployees,
                billablePercentage,
                benchPercentage,
                fullyUtilizedEmployees,
                partiallyUtilizedEmployees,
                employeeStatus);
    }
}