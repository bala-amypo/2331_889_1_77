package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

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

    private Double currentScore;

    private Double targetScore;

    private Double gapScore;

    private LocalDateTime calculatedAt;

    // Constructors
    public SkillGapRecord() {}

    public SkillGapRecord(StudentProfile studentProfile, Skill skill, Double currentScore, Double targetScore) {
        this.studentProfile = studentProfile;
        this.skill = skill;
        this.currentScore = currentScore;
        this.targetScore = targetScore;
        calculateGap();
        this.calculatedAt = LocalDateTime.now();
    }

    // Auto-calculate gapScore
    public void calculateGap() {
        if (currentScore != null && targetScore != null) {
            double gap = targetScore - currentScore;
            this.gapScore = gap > 0 ? gap : 0;
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public Double getCurrentScore() { return currentScore; }
    public void setCurrentScore(Double currentScore) { this.currentScore = currentScore; calculateGap(); }
    public Double getTargetScore() { return targetScore; }
    public void setTargetScore(Double targetScore) { this.targetScore = targetScore; calculateGap(); }
    public Double getGapScore() { return gapScore; }
    public LocalDateTime getCalculatedAt() { return calculatedAt; }
    public void setCalculatedAt(LocalDateTime calculatedAt) { this.calculatedAt = calculatedAt; }
}
