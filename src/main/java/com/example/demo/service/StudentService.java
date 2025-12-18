package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Studententity;

@Service
public class StudentService {

    private Map<Integer, Studententity> mp = new HashMap<>();

    public Studententity savadata(Studententity st) {
        mp.put(st.getId(), st);
        return st;
    }

    public List<Studententity> retdata() {
        return new ArrayList<>(mp.values());
    }
}
