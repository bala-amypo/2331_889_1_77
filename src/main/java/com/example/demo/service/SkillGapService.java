package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.repository.SkillGapRecordRepository;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    @Autowired
    private SkillGapRecordRepository repository;

    @Override
    public SkillGapRecord saveSkillGap(SkillGapRecord record) {

        calculateGapScore(record);
        record.setCalculatedAt(new Timestamp(System.currentTimeMillis()));

        return repository.save(record);
    }

    @Override
    public SkillGapRecord getSkillGapById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SkillGapRecord> getAllSkillGaps() {
        return repository.findAll();
    }

    @Override
    public SkillGapRecord updateSkillGap(Long id, SkillGapRecord record) {

        SkillGapRecord existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setCurrentScore(record.getCurrentScore());
        existing.setTargetScore(record.getTargetScore());

        calculateGapScore(existing);
        existing.setCalculatedAt(new Timestamp(System.currentTimeMillis()));

        return repository.save(existing);
    }

    @Override
    public void deleteSkillGap(Long id) {
        repository.deleteById(id);
    }

    // Helper method for business logic
    private void calculateGapScore(SkillGapRecord record) {
        if (record.getCurrentScore() != null && record.getTargetScore() != null) {
            record.setGapScore(record.getTargetScore() - record.getCurrentScore());
        }
    }
}
