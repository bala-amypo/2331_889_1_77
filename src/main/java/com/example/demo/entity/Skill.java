package.com.example.demo.entity;

public class Skill{
    private Long id;
    @Column(unique=true)
    private String skillName;
    private String category;
    private String description;
    private Double minCompetencyScore;
    private Boolean active;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSkillName() {
        return skillName;
    }
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getMinCompetencyScore() {
        return minCompetencyScore;
    }
    public void setMinCompetencyScore(Double minCompetencyScore) {
        this.minCompetencyScore = minCompetencyScore;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Skill(Long id, String skillName, String category, String description, Double minCompetencyScore,
            Boolean active) {
        this.id = id;
        this.skillName = skillName;
        this.category = category;
        this.description = description;
        this.minCompetencyScore = minCompetencyScore;
        this.active = active;
    }
    public Skill() {
    }




}