package com.example.demo.service;

import com.example.demo.entity.StudentProfile;

public interface StudentProfileService {
    StudentProfile createOrUpdateProfile(StudentProfile profile);
    StudentProfile getByUserId(Long userId);
}