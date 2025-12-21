package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.repository.SkillGapRecommendationRepository;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private SkillGapRecommendationRepository repository;

    @Override
    public SkillGapRecommendation saveRecommendation(SkillGapRecommendation recommendation) {
        return repository.save(recommendation);
    }

    @Override
    public SkillGapRecommendation getRecommendationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SkillGapRecommendation> getAllRecommendations() {
        return repository.findAll();
    }

    @Override
    public SkillGapRecommendation updateRecommendation(Long id, SkillGapRecommendation recommendation) {
        SkillGapRecommendation existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setRecommendedAction(recommendation.getRecommendedAction());
            existing.setHigh(recommendation.getHigh());
            existing.setMedium(recommendation.getMedium());
            existing.setLow(recommendation.getLow());
            existing.setGapScore(recommendation.getGapScore());
            existing.setGeneratedAt(recommendation.getGeneratedAt());
            existing.setGeneratedBy(recommendation.getGeneratedBy());

            return repository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteRecommendation(Long id) {
        repository.deleteById(id);
    }
}
