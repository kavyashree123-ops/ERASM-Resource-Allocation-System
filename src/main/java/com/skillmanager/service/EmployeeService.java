package com.skillmanager.service;

import java.util.List;

import com.skillmanager.dto.EmployeeDTO;
import com.skillmanager.entity.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}