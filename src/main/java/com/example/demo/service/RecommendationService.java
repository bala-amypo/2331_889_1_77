package com.example.demo.service;

import com.example.demo.entity.SkillGapRecommendation;
import java.util.List;

public interface RecommendationService {
    SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId);
    List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId);
    List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId);
}