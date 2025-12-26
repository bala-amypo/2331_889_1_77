// package com.example.demo.controller;

// import com.example.demo.entity.Skill;
// import com.example.demo.service.SkillService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/skills")
// public class SkillController {

//     private final SkillService serve;

//     public SkillController(SkillService serve) {
//         this.serve = serve;
//     }

//     @PostMapping
//     public ResponseEntity<Skill> create(@RequestBody Skill skill) {
//         return ResponseEntity.ok(serve.createSkill(skill));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Skill> update(@PathVariable Long id, @RequestBody Skill skill) {
//         return ResponseEntity.ok(serve.updateSkill(id, skill));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Skill> get(@PathVariable Long id) {
//         return ResponseEntity.ok(serve.getById(id));
//     }

//     @GetMapping
//     public ResponseEntity<List<Skill>> getAll() {
//         return ResponseEntity.ok(serve.getAllSkills());
//     }

//     @PutMapping("/{id}/deactivate")
//     public ResponseEntity<Void> deactivate(@PathVariable Long id) {
//         serve.deactivateSkill(id);
//         return ResponseEntity.ok().build();
//     }
// }
