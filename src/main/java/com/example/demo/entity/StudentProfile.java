package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(unique = true, nullable = false)
    private String enrollmentId;

    private String grade;

    @Column(nullable = false)
    private Instant lastUpdatedAt = Instant.now();

    public StudentProfile() {}

    private StudentProfile(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.enrollmentId = builder.enrollmentId;
        this.grade = builder.grade;
        this.lastUpdatedAt = builder.lastUpdatedAt;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdatedAt = Instant.now();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private User user;
        private String enrollmentId;
        private String grade;
        private Instant lastUpdatedAt = Instant.now();

        public Builder id(Long id) { this.id = id; return this; }
        public Builder user(User user) { this.user = user; return this; }
        public Builder enrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; return this; }
        public Builder grade(String grade) { this.grade = grade; return this; }
        public Builder lastUpdatedAt(Instant lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; return this; }
        public StudentProfile build() { return new StudentProfile(this); }
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public Instant getLastUpdatedAt() { return lastUpdatedAt; }
    public void setLastUpdatedAt(Instant lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; }
}