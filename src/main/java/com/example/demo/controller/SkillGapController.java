package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.service.SkillGapService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gaps")
@Tag(name = "Gaps", description = "Skill gap analysis operations")
public class SkillGapController {
    private final SkillGapService skillGapService;

    public SkillGapController(SkillGapService skillGapService) {
        this.skillGapService = skillGapService;
    }

    @PostMapping("/compute/{studentId}")
    public ResponseEntity<?> computeGaps(@PathVariable Long studentId) {
        List<SkillGapRecord> gaps = skillGapService.computeGaps(studentId);
        return ResponseEntity.ok(gaps);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getGapsByStudent(@PathVariable Long studentId) {
        List<SkillGapRecord> gaps = skillGapService.getGapsByStudent(studentId);
        return ResponseEntity.ok(gaps);
    }
}