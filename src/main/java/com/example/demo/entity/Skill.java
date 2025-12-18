package.com.example.demo.entity;

public class Skill{
    private Long id;
    @Column(unique=true)
    private String skillName;
    private String category;
    private String description;

}