package com.skillmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillmanager.entity.Skill;
import com.skillmanager.service.SkillService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping
    public Skill saveSkill(@Valid @RequestBody Skill skill) {
        return skillService.saveSkill(skill);
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return "Skill deleted successfully";
    }
    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id,
                            @Valid @RequestBody Skill skill) {

        return skillService.updateSkill(id, skill);
    }
}