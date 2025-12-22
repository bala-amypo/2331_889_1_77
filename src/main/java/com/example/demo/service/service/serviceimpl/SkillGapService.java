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

        // Business logic: auto-calculate gapScore if not provided
        if (record.getCurrentScore() != null && record.getTargetScore() != null) {
            record.setGapScore(record.getTargetScore() - record.getCurrentScore());
        }

        // Set current timestamp
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

        if (existing != null) {
            existing.setCurrentScore(record.getCurrentScore());
            existing.setTargetScore(record.getTargetScore());

            // Recalculate gap score
            if (record.getCurrentScore() != null && record.getTargetScore() != null) {
                existing.setGapScore(record.getTargetScore() - record.getCurrentScore());
            }

            existing.setCalculatedAt(new Timestamp(System.currentTimeMillis()));

            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteSkillGap(Long id) {
        repository.deleteById(id);
    }
}
