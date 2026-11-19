package com.example.studentapi.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Integer id) {
        super("Student not found with ID: " + id);
    }
}
