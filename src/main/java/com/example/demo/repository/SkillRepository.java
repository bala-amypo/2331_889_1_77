package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Skill;
public interface SkillRepository extends JpaRepository<Skill,Long>{
    
}