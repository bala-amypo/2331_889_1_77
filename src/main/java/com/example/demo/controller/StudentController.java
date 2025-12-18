package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService src;

    @PostMapping("/post")
    public StudentEntity postdata(@RequestBody StudentEntity st) {
        return src.savadata(st);
    }

    @GetMapping("/get")
    public List<StudentEntity> getdata() {
        return src.retdata();
    }
}
