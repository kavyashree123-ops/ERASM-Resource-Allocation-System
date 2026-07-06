package com.skillmanager.service;

import java.util.List;

import com.skillmanager.dto.EmployeeSkillDTO;
import com.skillmanager.entity.EmployeeSkill;

public interface EmployeeSkillService {

    EmployeeSkill saveEmployeeSkill(EmployeeSkill employeeSkill);

    List<EmployeeSkillDTO> getAllEmployeeSkills();

    EmployeeSkillDTO getEmployeeSkillById(Long id);

    EmployeeSkill updateEmployeeSkill(Long id, EmployeeSkill employeeSkill);

    void deleteEmployeeSkill(Long id);
}