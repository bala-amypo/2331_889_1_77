// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.Instant;

// @Entity
// @Table(name = "skill_gap_records")
// public class SkillGapRecord {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @ManyToOne
//     @JoinColumn(name = "student_profile_id", nullable = false)
//     private StudentProfile studentProfile;
    
//     @ManyToOne
//     @JoinColumn(name = "skill_id", nullable = false)
//     private Skill skill;
    
//     @Column(nullable = false)
//     private Double currentScore;
    
//     @Column(nullable = false)
//     private Double targetScore;
    
//     @Column(nullable = false)
//     private Double gapScore;
    
//     @Column(nullable = false)
//     private Instant calculatedAt;
    
//     @PrePersist
//     protected void onCreate() {
//         calculatedAt = Instant.now();
//     }
    
//     public SkillGapRecord() {}
    
//     public SkillGapRecord(StudentProfile studentProfile, Skill skill, Double currentScore, Double targetScore) {
//         this.studentProfile = studentProfile;
//         this.skill = skill;
//         this.currentScore = currentScore;
//         this.targetScore = targetScore;
//         this.gapScore = targetScore - currentScore;
//     }
    
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
    
//     public StudentProfile getStudentProfile() { return studentProfile; }
//     public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    
//     public Skill getSkill() { return skill; }
//     public void setSkill(Skill skill) { this.skill = skill; }
    
//     public Double getCurrentScore() { return currentScore; }
//     public void setCurrentScore(Double currentScore) { this.currentScore = currentScore; }
    
//     public Double getTargetScore() { return targetScore; }
//     public void setTargetScore(Double targetScore) { this.targetScore = targetScore; }
    
//     public Double getGapScore() { return gapScore; }
//     public void setGapScore(Double gapScore) { this.gapScore = gapScore; }
    
//     public Instant getCalculatedAt() { return calculatedAt; }
//     public void setCalculatedAt(Instant calculatedAt) { this.calculatedAt = calculatedAt; }
// }