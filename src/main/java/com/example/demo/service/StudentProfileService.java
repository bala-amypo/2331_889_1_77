package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;

public interface StudentProfileService {
    StudentProfile createProfile(StudentProfile profile);
    StudentProfile getProfileById(Long id);
    StudentProfile gpackage com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Autowired
    private StudentProfileRepository repository;

    @Override
    public StudentProfile createProfile(StudentProfile profile) {
        if (profile.getActive() == null) {
            profile.setActive(true); // default active
        }
        return repository.save(profile);
    }

    @Override
    public StudentProfile getProfileById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public StudentProfile getProfileByEnrollmentId(String enrollmentId) {
        return repository.findByEnrollmentId(enrollmentId);
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return repository.findAll();
    }
}
etProfileByEnrollmentId(String enrollmentId);
    List<StudentProfile> getAllProfiles();
}

@Service
public class StudentProfileServiceImpl implements StudentProfileService {
    @Autowired
    private StudentProfileRepository repository;

    @Override
    public StudentProfile createProfile(StudentProfile profile) {
        return repository.save(profile);
    }

    @Override
    public StudentProfile getProfileById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @Override
    public StudentProfile getProfileByEnrollmentId(String enrollmentId) {
        return repository.findByEnrollmentId(enrollmentId);
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return repository.findAll();
    }
}