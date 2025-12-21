package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import com.example.demo.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Autowired
    private StudentProfileRepository repository;

    @Override
    public StudentProfile createProfile(StudentProfile profile) {
        return repository.save(profile);
    }

    @Override
    public StudentProfile getProfileById(Long id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentProfile not found with id: " + id));
    }

    @Override
    public StudentProfile getProfileByEnrollmentId(String enrollmentId) {
        return repository.findByEnrollmentId(enrollmentId)
                .orElse(null);
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return repository.findAll();
    }
}
