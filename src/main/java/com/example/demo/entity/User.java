package.com.example.demo.entity;

import jakarta.persistence.*;

public class User{
    @Id
    private Long id;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String password;
    private String ADMIN;
    private String INSTRUCTOR;
    private String STUDENT;
    private LocalDate createdAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getADMIN() {
        return ADMIN;
    }
    public void setADMIN(String aDMIN) {
        ADMIN = aDMIN;
    }
    public String getINSTRUCTOR() {
        return INSTRUCTOR;
    }
    public void setINSTRUCTOR(String iNSTRUCTOR) {
        INSTRUCTOR = iNSTRUCTOR;
    }
    public String getSTUDENT() {
        return STUDENT;
    }
    public void setSTUDENT(String sTUDENT) {
        STUDENT = sTUDENT;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public User(Long id, String fullName, String email, String password, String aDMIN, String iNSTRUCTOR,
            String sTUDENT, LocalDate createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        ADMIN = aDMIN;
        INSTRUCTOR = iNSTRUCTOR;
        STUDENT = sTUDENT;
        this.createdAt = createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public User() {
    }
    
}