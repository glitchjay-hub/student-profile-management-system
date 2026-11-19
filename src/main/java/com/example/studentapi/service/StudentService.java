package com.example.studentapi.service;

import com.example.studentapi.dto.ScoreSkillsUpdateRequest;
import com.example.studentapi.entity.Student;
import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(Student student) {
        if (repository.existsById(student.getStudentId())) {
            throw new DataIntegrityViolationException("Duplicate student ID.");
        }
        if (repository.existsByEmailAddressIgnoreCase(student.getEmailAddress())) {
            throw new DataIntegrityViolationException("Duplicate email address.");
        }
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Transactional
    public Student updateScoresAndSkills(Integer id, ScoreSkillsUpdateRequest request) {
        Student student = getStudentById(id);
        student.setProgrammingScore(request.getProgrammingScore());
        student.setMathematicsScore(request.getMathematicsScore());

        if (request.getTechnicalSkills() != null) {
            student.setTechnicalSkills(request.getTechnicalSkills());
        }

        return repository.save(student);
    }

    public void deleteStudent(Integer id) {
        Student student = getStudentById(id);
        repository.delete(student);
    }

    public List<Student> getMeritList() {
        return repository.findAll().stream()
                .sorted(Comparator.comparingDouble(Student::getAverageScore).reversed())
                .toList();
    }
}
