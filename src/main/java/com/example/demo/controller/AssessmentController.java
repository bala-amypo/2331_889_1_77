package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.service.AssessmentResultService;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentResultService assessmentService;

    
    @PostMapping
    public AssessmentResult createAssessment(
            @RequestBody AssessmentResult assessment) {
        return assessmentService.saveAssessment(assessment);
    }

    
    @GetMapping("/{id}")
    public AssessmentResult getAssessmentById(@PathVariable Long id) {
        return assessmentService.getAssessmentById(id);
    }

    
    @GetMapping
    public List<AssessmentResult> getAllAssessments() {
        return assessmentService.getAllAssessments();
    }

   
    @PutMapping("/{id}")
    public AssessmentResult updateAssessment(
            @PathVariable Long id,
            @RequestBody AssessmentResult assessment) {
        return assessmentService.updateAssessment(id, assessment);
    }

   
    @DeleteMapping("/{id}")
    public String deleteAssessment(@PathVariable Long id) {
        assessmentService.deleteAssessment(id);
        return "Assessment result deleted successfully";
    }
}
