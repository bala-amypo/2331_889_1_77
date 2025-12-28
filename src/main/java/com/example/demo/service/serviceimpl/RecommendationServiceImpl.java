package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecommendationRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RecommendationService;

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
        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        
        List<AssessmentResult> assessments = assessmentResultRepository.findByStudentProfileIdAndSkillId(studentId, skillId);
        
        double currentScore = 0.0;
        if (!assessments.isEmpty()) {
            AssessmentResult latest = assessments.get(assessments.size() - 1);
            currentScore = (latest.getScore() / latest.getMaxScore()) * 100;
        }
        
        double targetScore = skill.getMinCompetencyScore() != null ? skill.getMinCompetencyScore() : 70.0;
        double gapScore = Math.max(0, targetScore - currentScore);
        
        String priority = gapScore > 20 ? "HIGH" : gapScore > 10 ? "MEDIUM" : "LOW";
        String action = "Focus on improving " + skill.getName() + " skills";
        
        SkillGapRecommendation recommendation = SkillGapRecommendation.builder()
                .studentProfile(student)
                .skill(skill)
                .recommendedAction(action)
                .priority(priority)
                .gapScore(gapScore)
                .generatedBy("SYSTEM")
                .build();
        
        return skillGapRecommendationRepository.save(recommendation);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {
        List<Skill> activeSkills = skillRepository.findByActiveTrue();
        List<SkillGapRecommendation> recommendations = new ArrayList<>();
        
        for (Skill skill : activeSkills) {
            SkillGapRecommendation rec = computeRecommendationForStudentSkill(studentId, skill.getId());
            recommendations.add(rec);
        }
        
        return recommendations;
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return skillGapRecommendationRepository.findByStudentOrdered(studentId);
    }

    @Override
    public List<SkillGapRecommendation> generateRecommendations(Long studentProfileId) {
        return computeRecommendationsForStudent(studentProfileId);
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsByStudent(Long studentId) {
        return skillGapRecommendationRepository.findByStudentProfileIdOrderByGeneratedAtDesc(studentId);
    }
}