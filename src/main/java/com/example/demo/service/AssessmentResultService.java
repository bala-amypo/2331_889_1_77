package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;

@Service
public class AssessmentResultServiceImpl implements AssessmentResultService {

    @Autowired
    private AssessmentResultRepository repository;

    @Override
    public AssessmentResult saveAssessment(AssessmentResult assessment) {
        return repository.save(assessment);
    }

    @Override
    public AssessmentResult getAssessmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<AssessmentResult> getAllAssessments() {
        return repository.findAll();
    }

    @Override
    public AssessmentResult updateAssessment(Long id, AssessmentResult assessment) {

        AssessmentResult existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setScoreObtained(assessment.getScoreObtained());
        existing.setMaxScore(assessment.getMaxScore());
        existing.setAssessedAt(assessment.getAssessedAt());

        return repository.save(existing);
    }

    @Override
    public void deleteAssessment(Long id) {
        repository.deleteById(id);
    }
}
