package com.skillmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillmanager.dto.EmployeeSkillDTO;
import com.skillmanager.entity.EmployeeSkill;
import com.skillmanager.service.EmployeeSkillService;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    @Autowired
    private EmployeeSkillService employeeSkillService;

    @PostMapping
    public EmployeeSkillDTO saveEmployeeSkill(@RequestBody EmployeeSkill employeeSkill) {

        EmployeeSkill saved = employeeSkillService.saveEmployeeSkill(employeeSkill);

        return employeeSkillService.getEmployeeSkillById(saved.getId());
    }

    @GetMapping
    public List<EmployeeSkillDTO> getAllEmployeeSkills() {
        return employeeSkillService.getAllEmployeeSkills();
    }

    @GetMapping("/{id}")
    public EmployeeSkillDTO getEmployeeSkillById(@PathVariable Long id) {
        return employeeSkillService.getEmployeeSkillById(id);
    }

    @PutMapping("/{id}")
    public EmployeeSkillDTO updateEmployeeSkill(@PathVariable Long id,
                                                @RequestBody EmployeeSkill employeeSkill) {

        EmployeeSkill updated =
                employeeSkillService.updateEmployeeSkill(id, employeeSkill);

        return employeeSkillService.getEmployeeSkillById(updated.getId());
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeSkill(@PathVariable Long id) {
        employeeSkillService.deleteEmployeeSkill(id);
        return "Employee Skill deleted successfully";
    }
}