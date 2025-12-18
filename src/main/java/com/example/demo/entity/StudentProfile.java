ppackage com.example.demo.entity;

public class StudentProfile{
    private Long id;
    @Column(unique=true)
    private String entrollmentId;
    private String cohort;
    private Integer yearLevel;
    private Boolean active;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEntrollmentId() {
        return entrollmentId;
    }
    public void setEntrollmentId(String entrollmentId) {
        this.entrollmentId = entrollmentId;
    }
    public String getCohort() {
        return cohort;
    }
    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
    public Integer getYearLevel() {
        return yearLevel;
    }
    public void setYearLevel(Integer yearLevel) {
        this.yearLevel = yearLevel;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public StudentProfile(Long id, String entrollmentId, String cohort, Integer yearLevel, Boolean active) {
        this.id = id;
        this.entrollmentId = entrollmentId;
        this.cohort = cohort;
        this.yearLevel = yearLevel;
        this.active = active;
    }
    public StudentProfile() {
    }
    

}