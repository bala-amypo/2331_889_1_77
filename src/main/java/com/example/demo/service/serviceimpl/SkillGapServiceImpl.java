package com.example.demo.serviceimpl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.SkillGapService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final SkillGapRecordRepository skillGapRecordRepository;
    private final SkillRepository skillRepository;
    private final AssessmentResultRepository assessmentResultRepository;

    public SkillGapServiceImpl(SkillGapRecordRepository skillGapRecordRepository, SkillRepository skillRepository, AssessmentResultRepository assessmentResultRepository) {
        this.skillGapRecordRepository = skillGapRecordRepository;
        this.skillRepository = skillRepository;
        this.assessmentResultRepository = assessmentResultRepository;
    }

    @Override
    public List<SkillGapRecord> computeGaps(Long studentProfileId) {
        List<Skill> activeSkills = skillRepository.findByActiveTrue();
        List<AssessmentResult> assessments = assessmentResultRepository.findByStudentProfileId(studentProfileId);
        List<SkillGapRecord> gaps = new ArrayList<>();
        
        for (Skill skill : activeSkills) {
            Double currentScore = 0.0;
            for (AssessmentResult assessment : assessments) {
                if (assessment.getSkill().getId().equals(skill.getId())) {
                    currentScore = (assessment.getScore() / assessment.getMaxScore()) * 100;
                    break;
                }
            }
            
            Double targetScore = skill.getMinCompetencyScore() != null ? skill.getMinCompetencyScore() : 70.0;
            Double gapScore = Math.max(0, targetScore - currentScore);
            
            StudentProfile studentProfile = new StudentProfile();
            studentProfile.setId(studentProfileId);
            
            SkillGapRecord gap = SkillGapRecord.builder()
                    .studentProfile(studentProfile)
                    .skill(skill)
                    .currentScore(currentScore)
                    .targetScore(targetScore)
                    .gapScore(gapScore)
                    .build();
            gaps.add(skillGapRecordRepository.save(gap));
        }
        
        return gaps;
    }

    @Override
    public List<SkillGapRecord> getGapsByStudent(Long studentId) {
        return skillGapRecordRepository.findByStudentProfileId(studentId);
    }
}