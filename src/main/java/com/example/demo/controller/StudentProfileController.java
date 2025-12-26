// package com.example.demo.controller;

// import com.example.demo.entity.StudentProfile;
// import com.example.demo.service.StudentProfileService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/students")
// @Tag(name = "Students", description = "Student profile operations")
// public class StudentProfileController {
    
//     private final StudentProfileService studentProfileService;
    
//     public StudentProfileController(StudentProfileService studentProfileService) {
//         this.studentProfileService = studentProfileService;
//     }
    
//     @PostMapping
//     public ResponseEntity<StudentProfile> createProfile(@RequestBody StudentProfile profile) {
//         StudentProfile created = studentProfileService.createOrUpdateProfile(profile);
//         return ResponseEntity.ok(created);
//     }
    
//     @GetMapping("/{id}")
//     public ResponseEntity<StudentProfile> getProfile(@PathVariable Long id) {
//         StudentProfile profile = studentProfileService.getProfileById(id);
//         return ResponseEntity.ok(profile);
//     }
    
//     @GetMapping("/enrollment/{enrollmentId}")
//     public ResponseEntity<StudentProfile> getProfileByEnrollment(@PathVariable String enrollmentId) {
//         StudentProfile profile = studentProfileService.getProfileByEnrollmentId(enrollmentId);
//         return ResponseEntity.ok(profile);
//     }
    
//     @GetMapping
//     public ResponseEntity<List<StudentProfile>> getAllProfiles() {
//         List<StudentProfile> profiles = studentProfileService.getAllProfiles();
//         return ResponseEntity.ok(profiles);
//     }
// }