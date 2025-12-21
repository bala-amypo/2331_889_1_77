package com.example.demo.service.impl;

import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import com.example.demo.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository repository;

    @Override
    public Skill createSkill(Skill skill) {
        return repository.save(skill);
    }

    @Override
    public Skill updateSkill(Long id, Skill skill) {
        Skill existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with id: " + id));
        existing.setName(skill.getName());
        existing.setActive(skill.isActive());
        return repository.save(existing);
    }

    @Override
    public Skill getSkillById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with id: " + id));
    }

    @Override
    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    @Override
    public void deactivateSkill(Long id) {
        Skill skill = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with id: " + id));
        skill.setActive(false);
        repository.save(skill);
    }
}
