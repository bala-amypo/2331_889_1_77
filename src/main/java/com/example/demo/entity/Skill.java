package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills", uniqueConstraints = @UniqueConstraint(columnNames = "skillName"))
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String skillName;

    private String category;

    private String description;

    private Double minCompetencyScore; // 0-100

    private Boolean active = true;

    // Constructors
    public Skill() {}
    public Skill(String skillName, String category, String description, Double minCompetencyScore) {
        this.skillName = skillName;
        this.category = category;
        this.description = description;
        this.minCompetencyScore = minCompetencyScore;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getMinCompetencyScore() { return minCompetencyScore; }
    public void setMinCompetencyScore(Double minCompetencyScore) { this.minCompetencyScore = minCompetencyScore; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
