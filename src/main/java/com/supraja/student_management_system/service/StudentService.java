package com.supraja.student_management_system.service;

import java.util.List;

import com.supraja.student_management_system.dto.StudentDto;

public interface StudentService {

    StudentDto registerStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long studentId, StudentDto studentDto);

    void deleteStudent(Long studentId);
}