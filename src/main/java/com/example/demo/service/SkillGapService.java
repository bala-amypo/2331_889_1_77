package com.example.demo.service.impl;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.entity.AssessmentResult;
import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillGapRepository;
import com.example.demo.service.AssessmentResultService;
import com.example.demo.service.SkillService;
import com.example.demo.service.SkillGapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    @Autowired
    private SkillService skillService;

    @Autowired
    private AssessmentResultService resultService;

    @Autowired
    private SkillGapRepository gapRepository;

    @Override
    public void computeGaps(Long studentProfileId) {
        List<Skill> activeSkills = skillService.getAllSkills().stream()
                .filter(Skill::isActive)
                .toList();

        for (Skill skill : activeSkills) {
            List<AssessmentResult> results = resultService.getResultsByStudentAndSkill(studentProfileId, skill.getId());
            double latestScore = results.isEmpty() ? 0.0 : results.get(results.size() - 1).getScoreObtained();
            double gap = skill.getTargetScore() - latestScore;

            SkillGapRecord record = new SkillGapRecord();
            record.setStudentProfileId(studentProfileId);
            record.setSkillId(skill.getId());
            record.setGap(gap);

            gapRepository.save(record);
        }
    }

    @Override
    public List<SkillGapRecord> getGapsByStudent(Long studentId) {
        return gapRepository.findByStudentProfileId(studentId);
    }
}
