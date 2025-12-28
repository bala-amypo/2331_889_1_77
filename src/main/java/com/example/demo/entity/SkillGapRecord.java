package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "skill_gap_records")
public class SkillGapRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_profile_id", nullable = false)
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(nullable = false)
    private Double currentScore;

    @Column(nullable = false)
    private Double targetScore;

    @Column(nullable = false)
    private Double gapScore;

    @Column(nullable = false)
    private Instant calculatedAt = Instant.now();

    public SkillGapRecord() {}

    private SkillGapRecord(Builder builder) {
        this.id = builder.id;
        this.studentProfile = builder.studentProfile;
        this.skill = builder.skill;
        this.currentScore = builder.currentScore;
        this.targetScore = builder.targetScore;
        this.gapScore = builder.gapScore;
        this.calculatedAt = builder.calculatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private StudentProfile studentProfile;
        private Skill skill;
        private Double currentScore;
        private Double targetScore;
        private Double gapScore;
        private Instant calculatedAt = Instant.now();

        public Builder id(Long id) { this.id = id; return this; }
        public Builder studentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; return this; }
        public Builder skill(Skill skill) { this.skill = skill; return this; }
        public Builder currentScore(Double currentScore) { this.currentScore = currentScore; return this; }
        public Builder targetScore(Double targetScore) { this.targetScore = targetScore; return this; }
        public Builder gapScore(Double gapScore) { this.gapScore = gapScore; return this; }
        public Builder calculatedAt(Instant calculatedAt) { this.calculatedAt = calculatedAt; return this; }
        public SkillGapRecord build() { return new SkillGapRecord(this); }
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public Double getCurrentScore() { return currentScore; }
    public void setCurrentScore(Double currentScore) { this.currentScore = currentScore; }
    public Double getTargetScore() { return targetScore; }
    public void setTargetScore(Double targetScore) { this.targetScore = targetScore; }
    public Double getGapScore() { return gapScore; }
    public void setGapScore(Double gapScore) { this.gapScore = gapScore; }
    public Instant getCalculatedAt() { return calculatedAt; }
    public void setCalculatedAt(Instant calculatedAt) { this.calculatedAt = calculatedAt; }
}