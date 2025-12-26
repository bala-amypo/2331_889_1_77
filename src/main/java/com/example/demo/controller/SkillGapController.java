// package com.example.demo.controller;

// import com.example.demo.entity.SkillGapRecord;
// import com.example.demo.service.SkillGapService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/skill-gaps")
// public class SkillGapController {

//     @Autowired
//     private SkillGapService service;

//     @GetMapping("/{studentId}")
//     public List<SkillGapRecord> getSkillGaps(@PathVariable Long studentId) {
//         return service.getGapsByStudent(studentId);
//     }
// }
