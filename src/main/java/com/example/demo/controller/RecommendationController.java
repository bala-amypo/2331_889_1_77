// package com.example.demo.controller;

// import com.example.demo.entity.SkillGapRecommendation;
// import com.example.demo.service.RecommendationService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/recommendations")
// public class RecommendationController {

//     private final RecommendationService serve;

//     public RecommendationController(RecommendationService serve) {
//         this.serve = serve;
//     }

//     @PostMapping("/generate/{studentId}")
//     public ResponseEntity<List<SkillGapRecommendation>> generate(@PathVariable Long studentId) {
//         return ResponseEntity.ok(
//                 serve.computeRecommendationsForStudent(studentId)
//         );
//     }

//     @GetMapping("/student/{studentId}")
//     public ResponseEntity<List<SkillGapRecommendation>> get(@PathVariable Long studentId) {
//         return ResponseEntity.ok(
//                 serve.getRecommendationsForStudent(studentId)
//         );
//     }
// }
