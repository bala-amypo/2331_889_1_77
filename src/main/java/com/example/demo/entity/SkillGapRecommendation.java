package.com.example.demo.entity;

import jakarta.persistence.*;

public class SkillGapRecommendation{
    @Id
    private Long id;
    private String recommendedAction;
    private String HIGH;
    private String MEDIUM;
    private String LOW;
    private LocalDate generatedAt;
    private Double gapScore;
    private String generatedBy;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRecommendedAction() {
        return recommendedAction;
    }
    public void setRecommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
    }
    public String getHIGH() {
        return HIGH;
    }
    public void setHIGH(String hIGH) {
        HIGH = hIGH;
    }
    public String getMEDIUM() {
        return MEDIUM;
    }
    public void setMEDIUM(String mEDIUM) {
        MEDIUM = mEDIUM;
    }
    public String getLOW() {
        return LOW;
    }
    public void setLOW(String lOW) {
        LOW = lOW;
    }
    public LocalDate getGeneratedAt() {
        return generatedAt;
    }
    public void setGeneratedAt(LocalDate generatedAt) {
        this.generatedAt = generatedAt;
    }
    public Double getGapScore() {
        return gapScore;
    }
    public void setGapScore(Double gapScore) {
        this.gapScore = gapScore;
    }
    public String getGeneratedBy() {
        return generatedBy;
    }
    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }
    public SkillGapRecommendation(Long id, String recommendedAction, String hIGH, String mEDIUM, String lOW,
            LocalDate generatedAt, Double gapScore, String generatedBy) {
        this.id = id;
        this.recommendedAction = recommendedAction;
        HIGH = hIGH;
        MEDIUM = mEDIUM;
        LOW = lOW;
        this.generatedAt = generatedAt;
        this.gapScore = gapScore;
        this.generatedBy = generatedBy;
    }
    public SkillGapRecommendation() {
    }
    

}