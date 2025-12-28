package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profiles")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public ResponseEntity<StudentProfile> createProfile(@RequestBody StudentProfile profile) {
        return ResponseEntity.ok(studentProfileService.createProfile(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getProfile(@PathVariable Long id) {
        return ResponseEntity.ok(studentProfileService.getProfileById(id));
    }

    @GetMapping("/enrollment/{id}")
    public ResponseEntity<StudentProfile> getProfileByEnrollmentId(@PathVariable String id) {
        return ResponseEntity.ok(studentProfileService.getProfileByEnrollmentId(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllProfiles() {
        return ResponseEntity.ok(studentProfileService.getAllProfiles());
    }
}