package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.StudentProfile;

public interface StudentProfileService {
    StudentProfile createProfile(StudentProfile profile);
    StudentProfile createOrUpdateProfile(StudentProfile profile);
    StudentProfile getProfileById(Long id);
    StudentProfile getByUserId(Long userId);
    StudentProfile getProfileByEnrollmentId(String enrollmentId);
    List<StudentProfile> getAllProfiles();
}