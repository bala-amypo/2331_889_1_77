package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    private final AssessmentResultRepository assessmentResultRepository;
    private final SkillGapRecommendationRepository skillGapRecommendationRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final SkillRepository skillRepository;

    public RecommendationServiceImpl(AssessmentResultRepository assessmentResultRepository,
     SkillGapRecommendationRepository skillGapRecommendationRepository,
                                   StudentProfileRepository studentProfileRepository,
                                   SkillRepository skillRepository) {
        this.assessmentResultRepository = assessmentResultRepository;
        this.skillGapRecommendationRepository = skillGapRecommendationRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId) {
        if (studentId == null || skillId == null) {
            return null;
        }
        
        StudentProfile studentProfile = studentProfileRepository.findById(studentId).orElse(null);
        Skill skill = skillRepository.findById(skillId).orElse(null);
        
        if (studentProfile == null || skill == null) {
            return null;
        }
        
        List<AssessmentResult> results = assessmentResultRepository.findByStudentProfileIdAndSkillId(studentId, skillId);
        
        double currentScore = 0.0;
        if (!results.isEmpty()) {
            currentScore = results.get(results.size() - 1).getScore();
        }
        
        double gapScore = skill.getMinCompetencyScore() - currentScore;
        String priority = gapScore >= 20 ? "HIGH" : gapScore >= 10 ? "MEDIUM" : "LOW";
        String action = "Practice " + skill.getSkillName() + " to improve proficiency";
        
        SkillGapRecommendation recommendation = new SkillGapRecommendation(studentProfile, skill, action, priority, gapScore);
        return skillGapRecommendationRepository.save(recommendation);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {
        List<Skill> activeSkills = skillRepository.findByActiveTrue();
        List<SkillGapRecommendation> recommendations = new ArrayList<>();
        
        for (Skill skill : activeSkills) {
            SkillGapRecommendation recommendation = computeRecommendationForStudentSkill(studentId, skill.getId());
            if (recommendation != null) {
                recommendations.add(recommendation);
            }
        }
        
        return recommendations;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return skillGapRecommendationRepository.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}