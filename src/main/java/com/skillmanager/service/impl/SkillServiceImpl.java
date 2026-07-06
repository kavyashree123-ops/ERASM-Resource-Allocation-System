package com.skillmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillmanager.entity.Skill;
import com.skillmanager.repository.SkillRepository;
import com.skillmanager.service.AuditLogService;
import com.skillmanager.service.SkillService;
import com.skillmanager.util.SecurityUtil;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
    private AuditLogService auditLogService;

    @Override
    public Skill saveSkill(Skill skill) {

        Skill savedSkill = skillRepository.save(skill);

        auditLogService.log(
                "CREATE",
                "Skill",
                savedSkill.getId(),
                SecurityUtil.getCurrentUser());

        return savedSkill;
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public Skill updateSkill(Long id, Skill skill) {

        Skill existingSkill = skillRepository.findById(id).orElse(null);

        if (existingSkill != null) {

            existingSkill.setSkillName(skill.getSkillName());

            Skill updatedSkill = skillRepository.save(existingSkill);

            auditLogService.log(
                    "UPDATE",
                    "Skill",
                    updatedSkill.getId(),
                    SecurityUtil.getCurrentUser());

            return updatedSkill;
        }

        return null;
    }

    @Override
    public void deleteSkill(Long id) {

        skillRepository.deleteById(id);

        auditLogService.log(
                "DELETE",
                "Skill",
                id,
                SecurityUtil.getCurrentUser());
    }
}