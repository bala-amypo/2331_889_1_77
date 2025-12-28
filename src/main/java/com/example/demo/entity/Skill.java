package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    private String category;

    private String description;

    private Double minCompetencyScore;

    @Column(nullable = false)
    private boolean active = true;

    public Skill() {}

    private Skill(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.name = builder.name;
        this.category = builder.category;
        this.description = builder.description;
        this.minCompetencyScore = builder.minCompetencyScore;
        this.active = builder.active;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String code;
        private String name;
        private String category;
        private String description;
        private Double minCompetencyScore;
        private boolean active = true;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder code(String code) { this.code = code; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder minCompetencyScore(Double minCompetencyScore) { this.minCompetencyScore = minCompetencyScore; return this; }
        public Builder active(boolean active) { this.active = active; return this; }
        public Skill build() { return new Skill(this); }
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getMinCompetencyScore() { return minCompetencyScore; }
    public void setMinCompetencyScore(Double minCompetencyScore) { this.minCompetencyScore = minCompetencyScore; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}