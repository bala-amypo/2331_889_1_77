package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "assessment_results")
public class AssessmentResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assessmentId;

    @ManyToOne
    @JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private Double maxScore = 100.0;

    @Column(nullable = false)
    private Instant attemptedAt = Instant.now();

    public AssessmentResult() {}

    private AssessmentResult(Builder builder) {
        this.id = builder.id;
        this.assessmentId = builder.assessmentId;
        this.studentProfile = builder.studentProfile;
        this.skill = builder.skill;
        this.score = builder.score;
        this.maxScore = builder.maxScore != null ? builder.maxScore : 100.0;
        this.attemptedAt = builder.attemptedAt != null ? builder.attemptedAt : Instant.now();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String assessmentId;
        private StudentProfile studentProfile;
        private Skill skill;
        private Double score;
        private Double maxScore = 100.0;
        private Instant attemptedAt = Instant.now();

        public Builder id(Long id) { this.id = id; return this; }
        public Builder assessmentId(String assessmentId) { this.assessmentId = assessmentId; return this; }
        public Builder studentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; return this; }
        public Builder skill(Skill skill) { this.skill = skill; return this; }
        public Builder score(Double score) { this.score = score; return this; }
        public Builder maxScore(Double maxScore) { this.maxScore = maxScore; return this; }
        public Builder attemptedAt(Instant attemptedAt) { this.attemptedAt = attemptedAt; return this; }
        public AssessmentResult build() { return new AssessmentResult(this); }
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAssessmentId() { return assessmentId; }
    public void setAssessmentId(String assessmentId) { this.assessmentId = assessmentId; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    public Double getMaxScore() { return maxScore; }
    public void setMaxScore(Double maxScore) { this.maxScore = maxScore; }
    public Instant getAttemptedAt() { return attemptedAt; }
    public void setAttemptedAt(Instant attemptedAt) { this.attemptedAt = attemptedAt; }
}