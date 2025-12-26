package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "skill_gap_recommendations")
public class SkillGapRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;
    
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    
    private Double gapScore;
    private String generatedBy;
    private Instant generatedAt = Instant.now();
    
    public SkillGapRecommendation() {}
    
    public SkillGapRecommendation(Long id, StudentProfile studentProfile, Skill skill, Double gapScore, String generatedBy, Instant generatedAt) {
        this.id = id;
        this.studentProfile = studentProfile;
        this.skill = skill;
        this.gapScore = gapScore;
        this.generatedBy = generatedBy;
        this.generatedAt = generatedAt != null ? generatedAt : Instant.now();
    }
    
    public static SkillGapRecommendationBuilder builder() {
        return new SkillGapRecommendationBuilder();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public Double getGapScore() { return gapScore; }
    public void setGapScore(Double gapScore) { this.gapScore = gapScore; }
    public String getGeneratedBy() { return generatedBy; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }
    public Instant getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(Instant generatedAt) { this.generatedAt = generatedAt; }
    
    public static class SkillGapRecommendationBuilder {
        private Long id;
        private StudentProfile studentProfile;
        private Skill skill;
        private Double gapScore;
        private String generatedBy;
        private Instant generatedAt = Instant.now();
        
        public SkillGapRecommendationBuilder id(Long id) { this.id = id; return this; }
        public SkillGapRecommendationBuilder studentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; return this; }
        public SkillGapRecommendationBuilder skill(Skill skill) { this.skill = skill; return this; }
        public SkillGapRecommendationBuilder gapScore(Double gapScore) { this.gapScore = gapScore; return this; }
        public SkillGapRecommendationBuilder generatedBy(String generatedBy) { this.generatedBy = generatedBy; return this; }
        public SkillGapRecommendationBuilder generatedAt(Instant generatedAt) { this.generatedAt = generatedAt; return this; }
        
        public SkillGapRecommendation build() {
            return new SkillGapRecommendation(id, studentProfile, skill, gapScore, generatedBy, generatedAt);
        }
    }
}