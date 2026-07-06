package com.skillmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillmanager.dto.EmployeeSkillDTO;
import com.skillmanager.entity.EmployeeSkill;
import com.skillmanager.repository.EmployeeSkillRepository;
import com.skillmanager.service.EmployeeSkillService;
import com.skillmanager.entity.Employee;
import com.skillmanager.entity.Skill;
import com.skillmanager.repository.EmployeeRepository;
import com.skillmanager.repository.SkillRepository;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillRepository skillRepository;


    @Override
    public EmployeeSkill saveEmployeeSkill(EmployeeSkill employeeSkill) {
        return employeeSkillRepository.save(employeeSkill);
    }

    @Override
    public List<EmployeeSkillDTO> getAllEmployeeSkills() {

        List<EmployeeSkill> employeeSkills = employeeSkillRepository.findAll();

        return employeeSkills.stream()
                .map(es -> new EmployeeSkillDTO(
                        es.getId(),
                        es.getEmployee().getUser().getName(),
                        es.getSkill().getSkillName(),
                        es.getSkillLevel(),
                        es.getEmployee().getExperience()))
                .toList();
    }

    @Override
    public EmployeeSkillDTO getEmployeeSkillById(Long id) {

        EmployeeSkill employeeSkill =
                employeeSkillRepository.findById(id).orElse(null);

        if (employeeSkill == null) {
            return null;
        }

        return new EmployeeSkillDTO(
                employeeSkill.getId(),
                employeeSkill.getEmployee().getUser().getName(),
                employeeSkill.getSkill().getSkillName(),
                employeeSkill.getSkillLevel(),
                employeeSkill.getEmployee().getExperience());
    }

    @Override
    public EmployeeSkill updateEmployeeSkill(Long id,
                                             EmployeeSkill employeeSkill) {

        EmployeeSkill existing =
                employeeSkillRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        Employee employee = employeeRepository
                .findById(employeeSkill.getEmployee().getId())
                .orElse(null);

        Skill skill = skillRepository
                .findById(employeeSkill.getSkill().getId())
                .orElse(null);

        existing.setEmployee(employee);
        existing.setSkill(skill);
        existing.setSkillLevel(employeeSkill.getSkillLevel());

        return employeeSkillRepository.save(existing);
    }

    @Override
    public void deleteEmployeeSkill(Long id) {
        employeeSkillRepository.deleteById(id);
    }
}