package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        StudentProfile student = studentProfileRepository.findById(studentId).orElse(null);
        Skill skill = skillRepository.findById(skillId).orElse(null);
        
        if (student == null || skill == null) {
            return null;
        }
        
        List<AssessmentResult> assessments = assessmentResultRepository.findByStudentProfileIdAndSkillId(studentId, skillId);
        Double currentScore = assessments.stream()
                .mapToDouble(AssessmentResult::getScore)
                .max()
                .orElse(0.0);
        
        Double gapScore = skill.getMinCompetencyScore() - currentScore;
        String priority = gapScore >= 20 ? "HIGH" : gapScore >= 10 ? "MEDIUM" : "LOW";
        String action = gapScore > 0 ? "Practice more exercises for " + skill.getSkillName() : "Skill proficient";
        
        SkillGapRecommendation recommendation = new SkillGapRecommendation(
                student, skill, action, priority, gapScore, "SYSTEM"
        );
        
        return skillGapRecommendationRepository.save(recommendation);
    }
    
    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {
        StudentProfile student = studentProfileRepository.findById(studentId).orElse(null);
        if (student == null) {
            return new ArrayList<>();
        }
        
        List<Skill> activeSkills = skillRepository.findByActiveTrue();
        List<AssessmentResult> assessments = assessmentResultRepository.findByStudentProfileId(studentId);
        
        Map<Long, Double> latestScores = assessments.stream()
                .collect(Collectors.groupingBy(
                        a -> a.getSkill().getId(),
                        Collectors.collectingAndThen(
                                Collectors.maxBy((a1, a2) -> a1.getAssessedAt().compareTo(a2.getAssessedAt())),
                                opt -> opt.map(AssessmentResult::getScore).orElse(0.0)
                        )
                ));
        
        List<SkillGapRecommendation> recommendations = new ArrayList<>();
        for (Skill skill : activeSkills) {
            Double currentScore = latestScores.getOrDefault(skill.getId(), 0.0);
            Double gapScore = skill.getMinCompetencyScore() - currentScore;
            String priority = gapScore >= 20 ? "HIGH" : gapScore >= 10 ? "MEDIUM" : "LOW";
            String action = gapScore > 0 ? "Practice more exercises for " + skill.getSkillName() : "Skill proficient";
            
            SkillGapRecommendation recommendation = new SkillGapRecommendation(
                    student, skill, action, priority, gapScore, "SYSTEM"
            );
            
            recommendations.add(skillGapRecommendationRepository.save(recommendation));
        }
        
        return recommendations;
    }
    
    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return skillGapRecommendationRepository.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}