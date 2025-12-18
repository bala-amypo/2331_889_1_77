package com.example.demo.entity;

import java.time.LocalDate;

public class Studententity {

    private int id;
    private String name;
    private LocalDate date;
    private float cgpa;

    
    public StudentEntity() {
    }

    public StudentEntity(int id, String name, LocalDate date, float cgpa) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
}
