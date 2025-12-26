package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    private final AssessmentResultRepository assessmentRepository;
    private final SkillGapRecommendationRepository recommendationRepository;
    private final StudentProfileRepository profileRepository;
    private final SkillRepository skillRepository;

    public RecommendationServiceImpl(AssessmentResultRepository assessmentRepository,
                                   SkillGapRecommendationRepository recommendationRepository,
                                   StudentProfileRepository profileRepository,
                                   SkillRepository skillRepository) {
        this.assessmentRepository = assessmentRepository;
        this.recommendationRepository = recommendationRepository;
        this.profileRepository = profileRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillGapRecommendation computeRecommendationForStudentSkill(Long studentId, Long skillId) {
        StudentProfile profile = profileRepository.findById(studentId).orElseThrow();
        Skill skill = skillRepository.findById(skillId).orElseThrow();
        
        List<AssessmentResult> assessments = assessmentRepository.findByStudentProfileIdAndSkillId(studentId, skillId);
        double gapScore = assessments.isEmpty() ? 100.0 : 
            Math.max(0, 100 - assessments.get(assessments.size() - 1).getScore());
        
        SkillGapRecommendation recommendation = SkillGapRecommendation.builder()
            .studentProfile(profile)
            .skill(skill)
            .gapScore(gapScore)
            .generatedBy("SYSTEM")
            .build();
            
        return recommendationRepository.save(recommendation);
    }

    @Override
    public List<SkillGapRecommendation> computeRecommendationsForStudent(Long studentId) {
        StudentProfile profile = profileRepository.findById(studentId).orElseThrow();
        List<Skill> activeSkills = skillRepository.findByActiveTrue();
        
        return activeSkills.stream()
            .map(skill -> computeRecommendationForStudentSkill(studentId, skill.getId()))
            .collect(Collectors.toList());
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsForStudent(Long studentId) {
        return recommendationRepository.findByStudentOrdered(studentId);
    }
}