package com.example.demo.controller;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.service.SkillGapService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gaps")
@Tag(name = "Skill Gap")
public class SkillGapController {

    private final SkillGapService skillGapService;

    public SkillGapController(SkillGapService skillGapService) {
        this.skillGapService = skillGapService;
    }

    @PostMapping("/compute/{studentId}")
    public ResponseEntity<List<SkillGapRecord>> computeGaps(@PathVariable Long studentId) {
        return ResponseEntity.ok(skillGapService.computeGaps(studentId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<SkillGapRecord>> getGaps(@PathVariable Long studentId) {
        return ResponseEntity.ok(skillGapService.getGapsByStudent(studentId));
    }
}