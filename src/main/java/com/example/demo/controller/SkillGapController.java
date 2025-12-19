package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SkillGapRecord;
import com.example.demo.service.SkillGapService;

@RestController
@RequestMapping("/api/skill-gaps")
public class SkillGapController {

    @Autowired
    private SkillGapService skillGapService;

    // ✅ Create Skill Gap Record
    @PostMapping
    public SkillGapRecord createSkillGap(@RequestBody SkillGapRecord record) {
        return skillGapService.saveSkillGap(record);
    }

    // ✅ Get Skill Gap Record by ID
    @GetMapping("/{id}")
    public SkillGapRecord getSkillGapById(@PathVariable Long id) {
        return skillGapService.getSkillGapById(id);
    }

    // ✅ Get All Skill Gap Records
    @GetMapping
    public List<SkillGapRecord> getAllSkillGaps() {
        return skillGapService.getAllSkillGaps();
    }

    // ✅ Update Skill Gap Record
    @PutMapping("/{id}")
    public SkillGapRecord updateSkillGap(
            @PathVariable Long id,
            @RequestBody SkillGapRecord record) {
        return skillGapService.updateSkillGap(id, record);
    }

    
    @DeleteMapping("/{id}")
    public String deleteSkillGap(@PathVariable Long id) {
        skillGapService.deleteSkillGap(id);
        return "Skill gap record deleted successfully";
    }
}
