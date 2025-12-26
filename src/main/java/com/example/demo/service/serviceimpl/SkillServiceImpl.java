package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.exception.ResourceNotFoundException;
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
        if (skillRepository.findBySkillName(skill.getSkillName()).isPresent()) {
            throw new IllegalArgumentException("Skill name must be unique");
        }
        if (skill.getMinCompetencyScore() < 0 || skill.getMinCompetencyScore() > 100) {
            throw new IllegalArgumentException("Min competency score must be between 0 and 100");
        }
        return skillRepository.save(skill);
    }
    
    @Override
    public Skill updateSkill(Long id, Skill skill) {
        Skill existing = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
        
        if (!existing.getSkillName().equals(skill.getSkillName()) && 
            skillRepository.findBySkillName(skill.getSkillName()).isPresent()) {
            throw new IllegalArgumentException("Skill name must be unique");
        }
        
        if (skill.getMinCompetencyScore() < 0 || skill.getMinCompetencyScore() > 100) {
            throw new IllegalArgumentException("Min competency score must be between 0 and 100");
        }
        
        existing.setSkillName(skill.getSkillName());
        existing.setCategory(skill.getCategory());
        existing.setDescription(skill.getDescription());
        existing.setMinCompetencyScore(skill.getMinCompetencyScore());
        existing.setActive(skill.getActive());
        
        return skillRepository.save(existing);
    }
    
    @Override
    public Skill getById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
    }
    
    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
    
    @Override
    public List<Skill> getActiveSkills() {
        return skillRepository.findByActiveTrue();
    }
    
    @Override
    public void deactivateSkill(Long id) {
        Skill skill = getById(id);
        skill.setActive(false);
        skillRepository.save(skill);
    }
}