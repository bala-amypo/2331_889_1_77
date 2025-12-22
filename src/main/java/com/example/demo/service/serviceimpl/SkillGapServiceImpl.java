package com.example.demo.serviceimpl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.entity.SkillGapRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.repository.SkillGapRecordRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillGapService;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {
    private final SkillGapRecordRepository skillGapRecordRepository;
    private final SkillRepository skillRepository;
    private final AssessmentResultRepository assessmentResultRepository;
    private final StudentProfileService studentProfileService;

    public SkillGapServiceImpl(SkillGapRecordRepository skillGapRecordRepository, 
                              SkillRepository skillRepository, 
                              AssessmentResultRepository assessmentResultRepository,
                              StudentProfileService studentProfileService) {
        this.skillGapRecordRepository = skillGapRecordRepository;
        this.skillRepository = skillRepository;
        this.assessmentResultRepository = assessmentResultRepository;
        this.studentProfileService = studentProfileService;
    }

    @Override
    public List<SkillGapRecord> computeGaps(Long studentProfileId) {
        StudentProfile studentProfile = studentProfileService.getProfileById(studentProfileId);
        List<Skill> activeSkills = skillRepository.findByActiveTrue();
        List<SkillGapRecord> gaps = new ArrayList<>();
        
        for (Skill skill : activeSkills) {
            List<AssessmentResult> results = assessmentResultRepository.findByStudentProfileIdAndSkillId(studentProfileId, skill.getId());
            
            double currentScore = 0.0;
            if (!results.isEmpty()) {
                currentScore = results.get(results.size() - 1).getScore(); // Latest score
            }
            
            double targetScore = skill.getMinCompetencyScore();
            
            SkillGapRecord gap = new SkillGapRecord(studentProfile, skill, currentScore, targetScore);
            gaps.add(skillGapRecordRepository.save(gap));
        }
        
        return gaps;
    }

    @Override
    public List<SkillGapRecord> getGapsByStudent(Long studentId) {
        return skillGapRecordRepository.findByStudentProfileId(studentId);
    }
}