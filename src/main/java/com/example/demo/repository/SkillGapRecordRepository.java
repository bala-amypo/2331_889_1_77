package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkillGapRecordRepository extends JpaRepository<SkillGapRecord, Long> {
    List<SkillGapRecord> findByStudentProfileId(Long studentProfileId);
}