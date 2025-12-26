package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "assessment_results")
public class AssessmentResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String assessmentId;
    private Double score;
    private Double maxScore = 100.0;
    private Instant attemptedAt = Instant.now();
    
    @ManyToOne
    @JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;
    
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    
    public AssessmentResult() {}
    
    public AssessmentResult(Long id, String assessmentId, Double score, Double maxScore, Instant attemptedAt, StudentProfile studentProfile, Skill skill) {
        this.id = id;
        this.assessmentId = assessmentId;
        this.score = score;
        this.maxScore = maxScore != null ? maxScore : 100.0;
        this.attemptedAt = attemptedAt != null ? attemptedAt : Instant.now();
        this.studentProfile = studentProfile;
        this.skill = skill;
    }
    
    public static AssessmentResultBuilder builder() {
        return new AssessmentResultBuilder();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAssessmentId() { return assessmentId; }
    public void setAssessmentId(String assessmentId) { this.assessmentId = assessmentId; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    public Double getMaxScore() { return maxScore; }
    public void setMaxScore(Double maxScore) { this.maxScore = maxScore; }
    public Instant getAttemptedAt() { return attemptedAt; }
    public void setAttemptedAt(Instant attemptedAt) { this.attemptedAt = attemptedAt; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    
    public static class AssessmentResultBuilder {
        private Long id;
        private String assessmentId;
        private Double score;
        private Double maxScore = 100.0;
        private Instant attemptedAt = Instant.now();
        private StudentProfile studentProfile;
        private Skill skill;
        
        public AssessmentResultBuilder id(Long id) { this.id = id; return this; }
        public AssessmentResultBuilder assessmentId(String assessmentId) { this.assessmentId = assessmentId; return this; }
        public AssessmentResultBuilder score(Double score) { this.score = score; return this; }
        public AssessmentResultBuilder maxScore(Double maxScore) { this.maxScore = maxScore; return this; }
        public AssessmentResultBuilder attemptedAt(Instant attemptedAt) { this.attemptedAt = attemptedAt; return this; }
        public AssessmentResultBuilder studentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; return this; }
        public AssessmentResultBuilder skill(Skill skill) { this.skill = skill; return this; }
        
        public AssessmentResult build() {
            return new AssessmentResult(id, assessmentId, score, maxScore, attemptedAt, studentProfile, skill);
        }
    }
}