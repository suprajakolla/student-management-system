package com.supraja.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.supraja.student_management_system.dto.StudentDto;
import com.supraja.student_management_system.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> registerStudent(@Valid @RequestBody StudentDto studentDto) {

        StudentDto savedStudent = studentService.registerStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long studentId) {

        StudentDto student = studentService.getStudentById(studentId);

        return ResponseEntity.ok(student);
    }
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {

        List<StudentDto> students = studentService.getAllStudents();

        return ResponseEntity.ok(students);
    }
    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long studentId,
                                                    @Valid @RequestBody StudentDto studentDto) {

        StudentDto updatedStudent = studentService.updateStudent(studentId, studentDto);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {

        studentService.deleteStudent(studentId);

        return ResponseEntity.ok("Student deleted successfully.");
    }
}