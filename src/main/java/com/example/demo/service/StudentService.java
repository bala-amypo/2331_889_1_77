package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;

@Service
public class StudentService {

    private Map<Integer, StudentEntity> mp = new HashMap<>();

    public StudentEntity savadata(StudentEntity st) {
        mp.put(st.getId(), st);
        return st;
    }

    public List<StudentEntity> retdata() {
        return new ArrayList<>(mp.values());
    }
}
