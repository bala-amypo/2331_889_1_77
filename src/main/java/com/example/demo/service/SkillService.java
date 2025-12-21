package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository repository;

    @Override
    public Skill saveSkill(Skill skill) {

        // Default active flag
        if (skill.getActive() == null) {
            skill.setActive(true);
        }

        return repository.save(skill);
    }

    @Override
    public Skill getSkillById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Skill getSkillByName(String skillName) {
        return repository.findBySkillName(skillName);
    }

    @Override
    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    @Override
    public Skill updateSkill(Long id, Skill skill) {
        Skill existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setSkillName(skill.getSkillName());
            existing.setCategory(skill.getCategory());
            existing.setDescription(skill.getDescription());
            existing.setMinCompetencyScore(skill.getMinCompetencyScore());
            existing.setActive(skill.getActive());

            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteSkill(Long id) {
        repository.deleteById(id);
    }
}
