package com.example.demo.service;

import com.example.demo.entity.StudentProfile;
import java.util.List;

public interface StudentProfileService {
    StudentProfile createOrUpdateProfile(StudentProfile profile);
    StudentProfile getProfileById(Long id);
    StudentProfile getByUserId(Long userId);
    StudentProfile getProfileByEnrollmentId(String enrollmentId);
    List<StudentProfile> getAllProfiles();
}