package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String enrollmentId;
    
    private String grade;
    
    @Column(name = "user_id")
    private Long userId;
    
    private Instant lastUpdatedAt = Instant.now();
    
    public StudentProfile() {}
    
    public StudentProfile(Long id, String enrollmentId, String grade, Long userId, Instant lastUpdatedAt) {
        this.id = id;
        this.enrollmentId = enrollmentId;
        this.grade = grade;
        this.userId = userId;
        this.lastUpdatedAt = lastUpdatedAt != null ? lastUpdatedAt : Instant.now();
    }
    
    public static StudentProfileBuilder builder() {
        return new StudentProfileBuilder();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Instant getLastUpdatedAt() { return lastUpdatedAt; }
    public void setLastUpdatedAt(Instant lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; }
    
    @PreUpdate
    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }
    
    public static class StudentProfileBuilder {
        private Long id;
        private String enrollmentId;
        private String grade;
        private Long userId;
        private Instant lastUpdatedAt = Instant.now();
        
        public StudentProfileBuilder id(Long id) { this.id = id; return this; }
        public StudentProfileBuilder enrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; return this; }
        public StudentProfileBuilder grade(String grade) { this.grade = grade; return this; }
        public StudentProfileBuilder userId(Long userId) { this.userId = userId; return this; }
        public StudentProfileBuilder lastUpdatedAt(Instant lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; return this; }
        
        public StudentProfile build() {
            return new StudentProfile(id, enrollmentId, grade, userId, lastUpdatedAt);
        }
    }
}