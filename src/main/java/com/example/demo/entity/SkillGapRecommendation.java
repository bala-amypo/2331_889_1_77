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

    @Column(nullable = false)
    private String recommendedAction;

    @Column(nullable = false)
    private String priority;

    @Column(nullable = false)
    private Double gapScore;

    @Column(nullable = false)
    private String generatedBy;

    @Column(nullable = false)
    private Instant generatedAt = Instant.now();

    public SkillGapRecommendation() {}

    private SkillGapRecommendation(Builder builder) {
        this.id = builder.id;
        this.studentProfile = builder.studentProfile;
        this.skill = builder.skill;
        this.recommendedAction = builder.recommendedAction;
        this.priority = builder.priority;
        this.gapScore = builder.gapScore;
        this.generatedBy = builder.generatedBy;
        this.generatedAt = builder.generatedAt != null ? builder.generatedAt : Instant.now();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private StudentProfile studentProfile;
        private Skill skill;
        private String recommendedAction;
        private String priority;
        private Double gapScore;
        private String generatedBy;
        private Instant generatedAt = Instant.now();

        public Builder id(Long id) { this.id = id; return this; }
        public Builder studentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; return this; }
        public Builder skill(Skill skill) { this.skill = skill; return this; }
        public Builder recommendedAction(String recommendedAction) { this.recommendedAction = recommendedAction; return this; }
        public Builder priority(String priority) { this.priority = priority; return this; }
        public Builder gapScore(Double gapScore) { this.gapScore = gapScore; return this; }
        public Builder generatedBy(String generatedBy) { this.generatedBy = generatedBy; return this; }
        public Builder generatedAt(Instant generatedAt) { this.generatedAt = generatedAt; return this; }
        public SkillGapRecommendation build() { return new SkillGapRecommendation(this); }
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public String getRecommendedAction() { return recommendedAction; }
    public void setRecommendedAction(String recommendedAction) { this.recommendedAction = recommendedAction; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public Double getGapScore() { return gapScore; }
    public void setGapScore(Double gapScore) { this.gapScore = gapScore; }
    public String getGeneratedBy() { return generatedBy; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }
    public Instant getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(Instant generatedAt) { this.generatedAt = generatedAt; }
}