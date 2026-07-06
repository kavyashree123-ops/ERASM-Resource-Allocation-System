package com.skillmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillmanager.entity.EmployeeSkill;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployeeId(Long employeeId);

    List<EmployeeSkill> findBySkillSkillName(String skillName);

}