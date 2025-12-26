// package com.example.demo.serviceimpl;

// import com.example.demo.entity.AssessmentResult;
// import com.example.demo.entity.Skill;
// import com.example.demo.entity.SkillGapRecord;
// import com.example.demo.entity.StudentProfile;
// import com.example.demo.repository.AssessmentResultRepository;
// import com.example.demo.repository.SkillGapRecordRepository;
// import com.example.demo.repository.SkillRepository;
// import com.example.demo.service.SkillGapService;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// @Service
// public class SkillGapServiceImpl implements SkillGapService {
    
//     private final SkillGapRecordRepository skillGapRecordRepository;
//     private final SkillRepository skillRepository;
//     private final AssessmentResultRepository assessmentResultRepository;
    
//     public SkillGapServiceImpl(SkillGapRecordRepository skillGapRecordRepository, 
//                               SkillRepository skillRepository, 
//                               AssessmentResultRepository assessmentResultRepository) {
//         this.skillGapRecordRepository = skillGapRecordRepository;
//         this.skillRepository = skillRepository;
//         this.assessmentResultRepository = assessmentResultRepository;
//     }
    
//     @Override
//     public List<SkillGapRecord> computeGaps(Long studentProfileId) {
//         List<Skill> activeSkills = skillRepository.findByActiveTrue();
//         List<AssessmentResult> assessments = assessmentResultRepository.findByStudentProfileId(studentProfileId);
        
//         Map<Long, Double> latestScores = assessments.stream()
//                 .collect(Collectors.groupingBy(
//                         a -> a.getSkill().getId(),
//                         Collectors.collectingAndThen(
//                                 Collectors.maxBy((a1, a2) -> a1.getAssessedAt().compareTo(a2.getAssessedAt())),
//                                 opt -> opt.map(AssessmentResult::getScore).orElse(0.0)
//                         )
//                 ));
        
//         List<SkillGapRecord> gaps = new ArrayList<>();
//         for (Skill skill : activeSkills) {
//             Double currentScore = latestScores.getOrDefault(skill.getId(), 0.0);
//             Double targetScore = skill.getMinCompetencyScore();
            
//             SkillGapRecord gap = new SkillGapRecord();
//             gap.setStudentProfile(new StudentProfile());
//             gap.getStudentProfile().setId(studentProfileId);
//             gap.setSkill(skill);
//             gap.setCurrentScore(currentScore);
//             gap.setTargetScore(targetScore);
//             gap.setGapScore(targetScore - currentScore);
            
//             gaps.add(skillGapRecordRepository.save(gap));
//         }
        
//         return gaps;
//     }
    
//     @Override
//     public List<SkillGapRecord> getGapsByStudent(Long studentId) {
//         return skillGapRecordRepository.findByStudentProfileId(studentId);
//     }
// }