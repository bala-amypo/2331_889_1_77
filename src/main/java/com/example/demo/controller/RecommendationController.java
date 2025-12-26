package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecommendation;
import com.example.demo.service.RecommendationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@Tag(name = "Recommendations", description = "Recommendation operations")
public class RecommendationController {
    
    private final RecommendationService recommendationService;
    
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }
    
    @PostMapping("/generate/{studentId}")
    public ResponseEntity<List<SkillGapRecommendation>> generateRecommendations(@PathVariable Long studentId) {
        List<SkillGapRecommendation> recommendations = recommendationService.computeRecommendationsForStudent(studentId);
        return ResponseEntity.ok(recommendations);
    }
    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<SkillGapRecommendation>> getRecommendationsForStudent(@PathVariable Long studentId) {
        List<SkillGapRecommendation> recommendations = recommendationService.getRecommendationsForStudent(studentId);
        return ResponseEntity.ok(recommendations);
    }
}