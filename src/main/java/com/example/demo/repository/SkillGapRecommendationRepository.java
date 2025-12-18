package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.SkillGapRecommendation;
public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation,Long>{
    
}