package com.example.demo.service.impl;

import com.example.demo.entity.AssessmentResult;
import com.example.demo.repository.AssessmentResultRepository;
import com.example.demo.service.AssessmentResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssessmentResultServiceImpl implements AssessmentResultService {

    @Autowired
    private AssessmentResultRepository repository;

    @Override
    public AssessmentResult recordResult(AssessmentResult result) {
        // You can add validation logic here
        return repository.save(result);
    }

    @Override
    public List<AssessmentResult> getResultsByStudent(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    @Override
    public List<AssessmentResult> getResultsByStudentAndSkill(Long studentId, Long skillId) {
        return repository.findByStudentIdAndSkillId(studentId, skillId);
    }
}
