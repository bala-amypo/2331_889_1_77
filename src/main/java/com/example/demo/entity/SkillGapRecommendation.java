package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "skill_gap_recommendations")
public class SkillGapRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_profile_id", nullable = false)
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    private String recommendedAction;

    @Enumerated(EnumType.STRING)
    private Priority priority; // HIGH / MEDIUM / LOW

    private LocalDateTime generatedAt;

    private Double gapScore;

    private String generatedBy;

    // Enum for priority
    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    // Constructors
    public SkillGapRecommendation() {}

    public SkillGapRecommendation(StudentProfile studentProfile, Skill skill, String recommendedAction,
                                  Priority priority, Double gapScore, String generatedBy) {
        this.studentProfile = studentProfile;
        this.skill = skill;
        this.recommendedAction = recommendedAction;
        this.priority = priority;
        this.gapScore = gapScore;
        this.generatedBy = generatedBy;
        this.generatedAt = LocalDateTime.now(); // auto-generated
    }

    // Getters and Setters
    public Long getId() { return id; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public String getRecommendedAction() { return recommendedAction; }
    public void setRecommendedAction(String recommendedAction) { this.recommendedAction = recommendedAction; }
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
    public Double getGapScore() { return gapScore; }
    public void setGapScore(Double gapScore) { this.gapScore = gapScore; }
    public String getGeneratedBy() { return generatedBy; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }
}
