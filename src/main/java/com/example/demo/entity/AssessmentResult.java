package.com.example.demo.entity;

public class AssessmentResult{
    private Long id;
    private Double scoreObtained;
    private Double maxScore;
    private Timestamp assessedAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getScoreObtained() {
        return scoreObtained;
    }
    public void setScoreObtained(Double scoreObtained) {
        this.scoreObtained = scoreObtained;
    }
    public Double getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }
    public Timestamp getAssessedAt() {
        return assessedAt;
    }
    public void setAssessedAt(Timestamp assessedAt) {
        this.assessedAt = assessedAt;
    }
    public AssessmentResult(Long id, Double scoreObtained, Double maxScore, Timestamp assessedAt) {
        this.id = id;
        this.scoreObtained = scoreObtained;
        this.maxScore = maxScore;
        this.assessedAt = assessedAt;
    }
    public AssessmentResult() {
    }
}