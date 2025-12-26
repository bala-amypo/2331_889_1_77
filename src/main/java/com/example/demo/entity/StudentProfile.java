package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(nullable = false, unique = true)
    private String enrollmentId;
    
    @Column(nullable = false)
    private String cohort;
    
    @Column(nullable = false)
    private Integer yearLevel;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    @Column(nullable = false)
    private Instant lastUpdatedAt;
    
    @PrePersist
    protected void onCreate() {
        lastUpdatedAt = Instant.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        lastUpdatedAt = Instant.now();
    }
    
    public void preUpdate() {
        lastUpdatedAt = Instant.now();
    }
    
    public StudentProfile() {}
    
    public StudentProfile(User user, String enrollmentId, String cohort, Integer yearLevel) {
        this.user = user;
        this.enrollmentId = enrollmentId;
        this.cohort = cohort;
        this.yearLevel = yearLevel;
        this.active = true;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }
    
    public String getCohort() { return cohort; }
    public void setCohort(String cohort) { this.cohort = cohort; }
    
    public Integer getYearLevel() { return yearLevel; }
    public void setYearLevel(Integer yearLevel) { this.yearLevel = yearLevel; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    
    public Instant getLastUpdatedAt() { return lastUpdatedAt; }
    public void setLastUpdatedAt(Instant lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; }
}