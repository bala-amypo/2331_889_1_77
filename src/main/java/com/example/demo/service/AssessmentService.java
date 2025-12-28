package com.example.demo.service;

import com.example.demo.entity.AssessmentResult;
import java.util.List;

public interface AssessmentService {
    AssessmentResult recordResult(AssessmentResult result);
    AssessmentResult recordAssessment(AssessmentResult result);
    List<AssessmentResult> getResultsByStudent(Long studentId);
    List<AssessmentResult> getResultsByStudentAndSkill(Long studentId, Long skillId);
}