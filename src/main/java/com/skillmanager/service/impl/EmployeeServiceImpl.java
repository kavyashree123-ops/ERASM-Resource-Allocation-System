package com.skillmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skillmanager.service.AuditLogService;
import com.skillmanager.dto.EmployeeDTO;
import com.skillmanager.entity.Employee;
import com.skillmanager.repository.EmployeeRepository;
import com.skillmanager.service.EmployeeService;
import com.skillmanager.util.SecurityUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AuditLogService auditLogService;

    @Override
    public Employee saveEmployee(Employee employee) {
    	Employee savedEmployee = employeeRepository.save(employee);

    	auditLogService.log(
    	        "CREATE",
    	        "Employee",
    	        savedEmployee.getId(),
    	        SecurityUtil.getCurrentUser());

    	return savedEmployee;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employee -> new EmployeeDTO(
                        employee.getId(),
                        employee.getEmployeeCode(),
                        employee.getDepartment(),
                        employee.getDesignation(),
                        employee.getExperience(),
                        employee.getUser().getName()))
                .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee == null) {
            return null;
        }

        return new EmployeeDTO(
                employee.getId(),
                employee.getEmployeeCode(),
                employee.getDepartment(),
                employee.getDesignation(),
                employee.getExperience(),
                employee.getUser().getName());
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {

            existingEmployee.setEmployeeCode(employee.getEmployeeCode());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setDesignation(employee.getDesignation());
            existingEmployee.setExperience(employee.getExperience());
            existingEmployee.setUser(employee.getUser());

            Employee updatedEmployee = employeeRepository.save(existingEmployee);

            auditLogService.log(
                    "UPDATE",
                    "Employee",
                    updatedEmployee.getId(),
                    SecurityUtil.getCurrentUser());

            return updatedEmployee;
        }

        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
    	employeeRepository.deleteById(id);

    	auditLogService.log(
    	        "DELETE",
    	        "Employee",
    	        id,
    	        SecurityUtil.getCurrentUser());
    }
}