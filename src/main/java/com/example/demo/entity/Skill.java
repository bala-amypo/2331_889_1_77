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
    
    private boolean active = true;
    
    public Skill() {}
    
    public Skill(Long id, String code, String name, boolean active) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.active = active;
    }
    
    public static SkillBuilder builder() {
        return new SkillBuilder();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    
    public static class SkillBuilder {
        private Long id;
        private String code;
        private String name;
        private boolean active = true;
        
        public SkillBuilder id(Long id) { this.id = id; return this; }
        public SkillBuilder code(String code) { this.code = code; return this; }
        public SkillBuilder name(String name) { this.name = name; return this; }
        public SkillBuilder active(boolean active) { this.active = active; return this; }
        
        public Skill build() {
            return new Skill(id, code, name, active);
        }
    }
}