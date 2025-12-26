// package com.example.demo.controller;

// import com.example.demo.entity.AssessmentResult;
// import com.example.demo.service.AssessmentService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/assessments")
// @Tag(name = "Assessments", description = "Assessment result operations")
// public class AssessmentController {
    
//     private final AssessmentService assessmentService;
    
//     public AssessmentController(AssessmentService assessmentService) {
//         this.assessmentService = assessmentService;
//     }
    
//     @PostMapping
//     public ResponseEntity<AssessmentResult> recordAssessment(@RequestBody AssessmentResult result) {
//         AssessmentResult recorded = assessmentService.recordAssessment(result);
//         return ResponseEntity.ok(recorded);
//     }
    
//     @GetMapping("/student/{studentId}")
//     public ResponseEntity<List<AssessmentResult>> getResultsByStudent(@PathVariable Long studentId) {
//         List<AssessmentResult> results = assessmentService.getResultsByStudent(studentId);
//         return ResponseEntity.ok(results);
//     }
    
//     @GetMapping("/student/{studentId}/skill/{skillId}")
//     public ResponseEntity<List<AssessmentResult>> getResultsByStudentAndSkill(
//             @PathVariable Long studentId, @PathVariable Long skillId) {
//         List<AssessmentResult> results = assessmentService.getResultsByStudentAndSkill(studentId, skillId);
//         return ResponseEntity.ok(results);
//     }
// }