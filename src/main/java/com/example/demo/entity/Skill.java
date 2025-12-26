package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String skillName;
    
    @Column(nullable = false)
    private String category;
    
    private String description;
    
    @Column(nullable = false)
    private Double minCompetencyScore = 0.0;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    public Skill() {}
    
    public Skill(String skillName, String category, String description, Double minCompetencyScore) {
        this.skillName = skillName;
        this.category = category;
        this.description = description;
        this.minCompetencyScore = minCompetencyScore != null ? minCompetencyScore : 0.0;
        this.active = true;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
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