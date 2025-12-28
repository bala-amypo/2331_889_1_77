package com.example.demo.repository;

import com.example.demo.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.Instant;
import java.util.List;

@Repository
public interface AssessmentResultRepository extends JpaRepository<AssessmentResult, Long> {
    List<AssessmentResult> findByStudentProfileId(Long studentProfileId);
    List<AssessmentResult> findByStudentProfileIdAndSkillId(Long studentProfileId, Long skillId);
    
    @Query("SELECT AVG(ar.score) FROM AssessmentResult ar JOIN ar.studentProfile sp WHERE sp.grade = :cohort AND ar.skill.id = :skillId")
    Double avgScoreByCohortAndSkill(@Param("cohort") String cohort, @Param("skillId") Long skillId);
    
    @Query("SELECT ar FROM AssessmentResult ar WHERE ar.studentProfile.id = :studentId ORDER BY ar.attemptedAt DESC")
    List<AssessmentResult> findRecentByStudent(@Param("studentId") Long studentId);
    
    @Query("SELECT ar FROM AssessmentResult ar WHERE ar.studentProfile.id = :studentId AND ar.attemptedAt BETWEEN :start AND :end")
    List<AssessmentResult> findResultsForStudentBetween(@Param("studentId") Long studentId, @Param("start") Instant start, @Param("end") Instant end);
}