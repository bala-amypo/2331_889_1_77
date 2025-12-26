// package com.example.demo.controller;

// import com.example.demo.entity.Skill;
// import com.example.demo.service.SkillService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/skills")
// @Tag(name = "Skills", description = "Skill management operations")
// public class SkillController {
    
//     private final SkillService skillService;
    
//     public SkillController(SkillService skillService) {
//         this.skillService = skillService;
//     }
    
//     @PostMapping
//     public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
//         Skill created = skillService.createSkill(skill);
//         return ResponseEntity.ok(created);
//     }
    
//     @PutMapping("/{id}")
//     public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
//         Skill updated = skillService.updateSkill(id, skill);
//         return ResponseEntity.ok(updated);
//     }
    
//     @GetMapping("/{id}")
//     public ResponseEntity<Skill> getSkill(@PathVariable Long id) {
//         Skill skill = skillService.getById(id);
//         return ResponseEntity.ok(skill);
//     }
    
//     @GetMapping
//     public ResponseEntity<List<Skill>> getAllSkills() {
//         List<Skill> skills = skillService.getAllSkills();
//         return ResponseEntity.ok(skills);
//     }
    
//     @PutMapping("/{id}/deactivate")
//     public ResponseEntity<Void> deactivateSkill(@PathVariable Long id) {
//         skillService.deactivateSkill(id);
//         return ResponseEntity.ok().build();
//     }
// }