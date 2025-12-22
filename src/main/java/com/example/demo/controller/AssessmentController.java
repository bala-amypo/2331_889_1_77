package com.example.demo.controller;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentResultService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
@Tag(name = "Assessments", description = "Assessment result operations")
public class AssessmentController {
    private final AssessmentResultService assessmentResultService;

    public AssessmentController(AssessmentResultService assessmentResultService) {
        this.assessmentResultService = assessmentResultService;
    }

    @PostMapping("/")
    public ResponseEntity<?> recordAssessment(@RequestBody AssessmentResult result) {
        AssessmentResult recorded = assessmentResultService.recordAssessment(result);
        return ResponseEntity.ok(recorded);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getResultsByStudent(@PathVariable Long studentId) {
        List<AssessmentResult> results = assessmentResultService.getResultsByStudent(studentId);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/student/{studentId}/skill/{skillId}")
    public ResponseEntity<?> getResultsByStudentAndSkill(@PathVariable Long studentId, @PathVariable Long skillId) {
        List<AssessmentResult> results = assessmentResultService.getResultsByStudentAndSkill(studentId, skillId);
        return ResponseEntity.ok(results);
    }
}