package com.example.demo.entity;

import jakarta.persistence.*;
public class AssessmentResult{
    @Id
    private Long id;
    private Double scoreObtained;
    private Double maxScore;
    private LocalDate assessedAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getScoreObtained() {
        return scoreObtained;
    }
    public void setScoreObtained(Double scoreObtained) {
        this.scoreObtained = scoreObtained;
    }
    public Double getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }
    public LocalDate getAssessedAt() {
        return assessedAt;
    }
    public void setAssessedAt(LocalDate assessedAt) {
        this.assessedAt = assessedAt;
    }
    public AssessmentResult(Long id, Double scoreObtained, Double maxScore, LocalDate assessedAt) {
        this.id = id;
        this.scoreObtained = scoreObtained;
        this.maxScore = maxScore;
        this.assessedAt = assessedAt;
    }
    public AssessmentResult() {
    }
    

}