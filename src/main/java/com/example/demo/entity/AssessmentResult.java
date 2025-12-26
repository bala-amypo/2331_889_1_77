package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "assessment_results")
public class AssessmentResult {
    
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
    private String assessmentId;
    
    @Column(nullable = false)
    private Double score;
    
    @Column(nullable = false)
    private Double maxScore = 100.0;
    
    @Column(nullable = false)
    private Instant assessedAt;
    
    @PrePersist
    protected void onCreate() {
        assessedAt = Instant.now();
    }
    
    public AssessmentResult() {}
    
    public AssessmentResult(StudentProfile studentProfile, Skill skill, String assessmentId, Double score, Double maxScore) {
        this.studentProfile = studentProfile;
        this.skill = skill;
        this.assessmentId = assessmentId;
        this.score = score;
        this.maxScore = maxScore != null ? maxScore : 100.0;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public StudentProfile getStudentProfile() { return studentProfile; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    
    public String getAssessmentId() { return assessmentId; }
    public void setAssessmentId(String assessmentId) { this.assessmentId = assessmentId; }
    
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    
    public Double getMaxScore() { return maxScore; }
    public void setMaxScore(Double maxScore) { this.maxScore = maxScore; }
    
    public Instant getAssessedAt() { return assessedAt; }
    public void setAssessedAt(Instant assessedAt) { this.assessedAt = assessedAt; }
}