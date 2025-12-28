package com.example.demo.service;

import com.example.demo.entity.Skill;
import java.util.List;

public interface SkillService {
    Skill createSkill(Skill skill);
    Skill updateSkill(Long id, Skill skill);
    Skill getSkillById(Long id);
    Skill getById(Long id);
    List<Skill> getAllSkills();
    List<Skill> getActiveSkills();
    void deactivateSkill(Long id);
}