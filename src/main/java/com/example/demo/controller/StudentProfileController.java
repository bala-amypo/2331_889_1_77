// package com.example.demo.controller;

// import com.example.demo.entity.StudentProfile;
// import com.example.demo.service.StudentProfileService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/students")
// public class StudentProfileController {

//     private final StudentProfileService serve;

//     public StudentProfileController(StudentProfileService serve) {
//         this.serve = serve;
//     }

//     @PostMapping
//     public ResponseEntity<StudentProfile> create(@RequestBody StudentProfile profile) {
//         return ResponseEntity.ok(serve.createOrUpdateProfile(profile));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<StudentProfile> getById(@PathVariable Long id) {
//         return ResponseEntity.ok(serve.getProfileById(id));
//     }

//     @GetMapping("/enrollment/{enrollmentId}")
//     public ResponseEntity<StudentProfile> getByEnrollment(@PathVariable String enrollmentId) {
//         return ResponseEntity.ok(serve.getProfileByEnrollmentId(enrollmentId));
//     }

//     @GetMapping
//     public ResponseEntity<List<StudentProfile>> getAll() {
//         return ResponseEntity.ok(serve.getAllProfiles());
//     }
// }
