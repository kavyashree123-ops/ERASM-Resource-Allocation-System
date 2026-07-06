package com.skillmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillmanager.dto.EmployeeDTO;
import com.skillmanager.entity.Employee;
import com.skillmanager.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO saveEmployee(@Valid @RequestBody Employee employee) {

        Employee saved = employeeService.saveEmployee(employee);

        return employeeService.getEmployeeById(saved.getId());
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id,
                                      @Valid @RequestBody Employee employee) {

        Employee updated = employeeService.updateEmployee(id, employee);

        return employeeService.getEmployeeById(updated.getId());
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}