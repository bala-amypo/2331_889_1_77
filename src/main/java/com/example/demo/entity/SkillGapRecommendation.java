package.com.example.demo.entity;

public class SkillGapRecommendation{
    private Long id;
    private String recommendedAction;
    private String HIGH;
    private String MEDIUM;
    private String LOW;
    private LocalDate generatedBy;
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
    public LocalDate getGeneratedBy() {
        return generatedBy;
    }
    public void setGeneratedBy(LocalDate generatedBy) {
        this.generatedBy = generatedBy;
    }
    public SkillGapRecommendation(Long id, String recommendedAction, String hIGH, String mEDIUM, String lOW,
            LocalDate generatedBy) {
        this.id = id;
        this.recommendedAction = recommendedAction;
        HIGH = hIGH;
        MEDIUM = mEDIUM;
        LOW = lOW;
        this.generatedBy = generatedBy;
    }
    public SkillGapRecommendation() {
    }



    
}