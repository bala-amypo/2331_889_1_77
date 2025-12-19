package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.service.RecommendationService;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    
    @PostMapping
    public SkillGapRecommendation createRecommendation(
            @RequestBody SkillGapRecommendation recommendation) {
        return recommendationService.saveRecommendation(recommendation);
    }

    
    @GetMapping("/{id}")
    public SkillGapRecommendation getRecommendationById(@PathVariable Long id) {
        return recommendationService.getRecommendationById(id);
    }

    
    @GetMapping
    public List<SkillGapRecommendation> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }

    
    @PutMapping("/{id}")
    public SkillGapRecommendation updateRecommendation(
            @PathVariable Long id,
            @RequestBody SkillGapRecommendation recommendation) {
        return recommendationService.updateRecommendation(id, recommendation);
    }

    
    @DeleteMapping("/{id}")
    public String deleteRecommendation(@PathVariable Long id) {
        recommendationService.deleteRecommendation(id);
        return "Recommendation deleted successfully";
    }
}
