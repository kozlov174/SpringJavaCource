package com.example.labwork6.controller;

import com.example.labwork6.entity.Discipline;
import com.example.labwork6.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public ResponseEntity<List<Discipline>> allDisciplines() {
        List<Discipline> list = disciplineService.getAllDisciplines();
        return ResponseEntity.ok(list);
    }
    @PostMapping("/addDisciplines")
    public ResponseEntity<Discipline> addDiscipline(@RequestBody Discipline discipline) {
        Discipline savedDiscipline = disciplineService.saveDiscipline(discipline);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDiscipline);
    }

    @GetMapping("/disciplines/{id}")
    public ResponseEntity<Discipline> getDiscipline(@PathVariable("id") int id) {
        Discipline discipline = disciplineService.getDiscipline(id);
        if (discipline == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(discipline);
    }

    @PostMapping("/disciplines")
    public ResponseEntity<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        try {
            Discipline saved = disciplineService.saveDiscipline(discipline);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/disciplines/{id}")
    public ResponseEntity<Discipline> updateDiscipline(@PathVariable("id") int id,
                                                       @RequestBody Discipline discipline) {
        discipline.setId(id);
        try {
            Discipline updated = disciplineService.saveDiscipline(discipline);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/disciplines/{id}")
    public ResponseEntity<String> deleteDiscipline(@PathVariable("id") int id) {
        try {
            disciplineService.deleteDiscipline(id);
            return ResponseEntity.ok("Discipline deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discipline not found");
        }
    }
}