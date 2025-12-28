package com.example.demo.controller;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assessments")
@Tag(name = "Assessments")
public class AssessmentController {

    private final AssessmentService service;

    public AssessmentController(AssessmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AssessmentResult> recordResult(@RequestBody AssessmentResult result) {
        return ResponseEntity.ok(service.recordResult(result));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AssessmentResult>> getResults(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getResultsByStudent(studentId));
    }

    @GetMapping("/student/{studentId}/skill/{skillId}")
    public ResponseEntity<List<AssessmentResult>> getSpecificResult(@PathVariable Long studentId, @PathVariable Long skillId) {
        return ResponseEntity.ok(service.getResultsByStudentAndSkill(studentId, skillId));
    }
}