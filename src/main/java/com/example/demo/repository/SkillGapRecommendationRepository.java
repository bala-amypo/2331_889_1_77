package com.example.demo.repository;

import com.example.demo.entity.SkillGapRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkillGapRecommendationRepository extends JpaRepository<SkillGapRecommendation, Long> {
    List<SkillGapRecommendation> findByStudentProfileIdOrderByGeneratedAtDesc(Long studentProfileId);
    
    @Query("SELECT sgr FROM SkillGapRecommendation sgr WHERE sgr.studentProfile.id = :studentId ORDER BY sgr.generatedAt DESC")
    List<SkillGapRecommendation> findByStudentOrdered(@Param("studentId") Long studentId);
}