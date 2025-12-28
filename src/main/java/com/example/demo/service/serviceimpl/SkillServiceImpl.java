package com.example.demo.serviceimpl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill createSkill(Skill skill) {
        if (skillRepository.findByCode(skill.getCode()).isPresent()) {
            throw new IllegalArgumentException("Skill code must be unique");
        }
        if (skill.getMinCompetencyScore() != null && (skill.getMinCompetencyScore() < 0 || skill.getMinCompetencyScore() > 100)) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        return skillRepository.save(skill);
    }

    @Override
    public Skill updateSkill(Long id, Skill skill) {
        Skill existing = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        if (skill.getMinCompetencyScore() != null && (skill.getMinCompetencyScore() < 0 || skill.getMinCompetencyScore() > 100)) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        if (skill.getName() != null) existing.setName(skill.getName());
        if (skill.getCategory() != null) existing.setCategory(skill.getCategory());
        if (skill.getDescription() != null) existing.setDescription(skill.getDescription());
        if (skill.getMinCompetencyScore() != null) existing.setMinCompetencyScore(skill.getMinCompetencyScore());
        return skillRepository.save(existing);
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
    }

    public Skill getById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public List<Skill> getActiveSkills() {
        return skillRepository.findByActiveTrue();
    }

    @Override
    public void deactivateSkill(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
        skill.setActive(false);
        skillRepository.save(skill);
    }
}