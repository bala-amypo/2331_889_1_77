package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Studententity;
import com.example.demo.service.Studentservice;

@RestController
public class Studentcontroller {

    @Autowired
    private Studentservice src;

    @PostMapping("/post")
    public Studententity postdata(@RequestBody Studententity st) {
        return src.savadata(st);
    }

    @GetMapping("/get")
    public List<Studententity> getdata() {
        return src.retdata();
    }
}
