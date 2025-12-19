package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;

@RestController
@RequestMapping("/api/student-profiles")
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    
    @PostMapping
    public StudentProfile createStudentProfile(@RequestBody StudentProfile profile) {
        return studentProfileService.saveStudentProfile(profile);
    }

    
    @GetMapping("/{id}")
    public StudentProfile getStudentProfileById(@PathVariable Long id) {
        return studentProfileService.getStudentProfileById(id);
    }

    
    @GetMapping("/enrollment/{entrollmentId}")
    public StudentProfile getByEntrollmentId(@PathVariable String entrollmentId) {
        return studentProfileService.getByEntrollmentId(entrollmentId);
    }

    
    @GetMapping
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileService.getAllStudentProfiles();
    }

    
    @PutMapping("/{id}")
    public StudentProfile updateStudentProfile(
            @PathVariable Long id,
            @RequestBody StudentProfile profile) {
        return studentProfileService.updateStudentProfile(id, profile);
    }

    
    @DeleteMapping("/{id}")
    public String deleteStudentProfile(@PathVariable Long id) {
        studentProfileService.deleteStudentProfile(id);
        return "StudentProfile deleted successfully";
    }
}
