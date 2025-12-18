package.com.example.demo.entity;

public class SkillGapRecord{
    private Long id;
    private Double currentScore;
    private Double targetScore;
    private Double gapScore;
    private Timestamp calculatedAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getCurrentScore() {
        return currentScore;
    }
    public void setCurrentScore(Double currentScore) {
        this.currentScore = currentScore;
    }
    public Double getTargetScore() {
        return targetScore;
    }
    public void setTargetScore(Double targetScore) {
        this.targetScore = targetScore;
    }
    public Double getGapScore() {
        return gapScore;
    }
    public void setGapScore(Double gapScore) {
        this.gapScore = gapScore;
    }
    public Timestamp getCalculatedAt() {
        return calculatedAt;
    }
    public void setCalculatedAt(Timestamp calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
    public SkillGapRecord(Long id, Double currentScore, Double targetScore, Double gapScore, Timestamp calculatedAt) {
        this.id = id;
        this.currentScore = currentScore;
        this.targetScore = targetScore;
        this.gapScore = gapScore;
        this.calculatedAt = calculatedAt;
    }
    public SkillGapRecord() {
    }
    


}