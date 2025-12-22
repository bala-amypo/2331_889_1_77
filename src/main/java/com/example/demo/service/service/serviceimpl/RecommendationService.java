package com.example.demo.service.impl;

import com.example.demo.entity.SkillGap;
import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRepository;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private SkillGapRepository gapRepository;

    @Override
    public void generateRecommendations(Long studentProfileId) {
        // Fetch gap records for the student
        List<SkillGap> gaps = gapRepository.findByStudentProfileId(studentProfileId);

        for (SkillGap gapRecord : gaps) {
            SkillGapRecommendation recommendation = new SkillGapRecommendation();
            recommendation.setStudentProfileId(studentProfileId);
            recommendation.setSkillId(gapRecord.getSkillId());
            
            // Logic: If gap > 20 -> HIGH priority
            if (gapRecord.getGapValue() > 20) {
                recommendation.setPriority("HIGH");
            } else {
                recommendation.setPriority("NORMAL");
            }

            recommendationRepository.save(recommendation);
        }
    }

    @Override
    public List<SkillGapRecommendation> getRecommendationsByStudent(Long studentId) {
        return recommendationRepository.findByStudentId(studentId);
    }
}