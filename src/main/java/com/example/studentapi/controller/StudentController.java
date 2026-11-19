package com.example.studentapi.controller;

import com.example.studentapi.dto.ScoreSkillsUpdateRequest;
import com.example.studentapi.entity.Student;
import com.example.studentapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // 1. Add a student
    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student savedStudent = service.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    // 2. Retrieve all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    // 3. Search for a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    // 4. Update student scores and skills
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateScoresAndSkills(
            @PathVariable Integer id,
            @Valid @RequestBody ScoreSkillsUpdateRequest request) {
        return ResponseEntity.ok(service.updateScoresAndSkills(id, request));
    }

    // 5. Delete a student record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // 6. Display the merit list
    @GetMapping("/merit-list")
    public ResponseEntity<List<Student>> getMeritList() {
        return ResponseEntity.ok(service.getMeritList());
    }
}
