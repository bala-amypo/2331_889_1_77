package com.example.demo.service;

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
    public StudentProfile saveStudentProfile(StudentProfile profile) {

        // Default active = true
        if (profile.getActive() == null) {
            profile.setActive(true);
        }

        return repository.save(profile);
    }

    @Override
    public StudentProfile getStudentProfileById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public StudentProfile getByEnrollmentId(String enrollmentId) {
        return repository.findByEnrollmentId(enrollmentId);
    }

    @Override
    public List<StudentProfile> getAllStudentProfiles() {
        return repository.findAll();
    }

    @Override
    public StudentProfile updateStudentProfile(Long id, StudentProfile profile) {
        StudentProfile existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setEnrollmentId(profile.getEnrollmentId());
            existing.setCohort(profile.getCohort());
            existing.setYearLevel(profile.getYearLevel());
            existing.setActive(profile.getActive());

            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteStudentProfile(Long id) {
        repository.deleteById(id);
    }
}
