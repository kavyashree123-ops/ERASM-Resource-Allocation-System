package com.skillmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillmanager.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findBySkillName(String skillName);

}