package com.supraja.student_management_system.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.student_management_system.dto.StudentDto;
import com.supraja.student_management_system.entity.Student;
import com.supraja.student_management_system.exception.ResourceNotFoundException;
import com.supraja.student_management_system.repository.StudentRepository;
import com.supraja.student_management_system.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto registerStudent(StudentDto studentDto) {

        Student student = Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .email(studentDto.getEmail())
                .phoneNumber(studentDto.getPhoneNumber())
                .gender(studentDto.getGender())
                .dateOfBirth(studentDto.getDateOfBirth())
                .course(studentDto.getCourse())
                .department(studentDto.getDepartment())
                .year(studentDto.getYear())
                .address(studentDto.getAddress())
                .build();

        Student savedStudent = studentRepository.save(student);

        return StudentDto.builder()
                .studentId(savedStudent.getStudentId())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .email(savedStudent.getEmail())
                .phoneNumber(savedStudent.getPhoneNumber())
                .gender(savedStudent.getGender())
                .dateOfBirth(savedStudent.getDateOfBirth())
                .course(savedStudent.getCourse())
                .department(savedStudent.getDepartment())
                .year(savedStudent.getYear())
                .address(savedStudent.getAddress())
                .build();
    }

    @Override
    public StudentDto getStudentById(Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));

        return StudentDto.builder()
                .studentId(student.getStudentId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .phoneNumber(student.getPhoneNumber())
                .gender(student.getGender())
                .dateOfBirth(student.getDateOfBirth())
                .course(student.getCourse())
                .department(student.getDepartment())
                .year(student.getYear())
                .address(student.getAddress())
                .build();
    }

    @Override
    public List<StudentDto> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(student -> StudentDto.builder()
                        .studentId(student.getStudentId())
                        .firstName(student.getFirstName())
                        .lastName(student.getLastName())
                        .email(student.getEmail())
                        .phoneNumber(student.getPhoneNumber())
                        .gender(student.getGender())
                        .dateOfBirth(student.getDateOfBirth())
                        .course(student.getCourse())
                        .department(student.getDepartment())
                        .year(student.getYear())
                        .address(student.getAddress())
                        .build())
                .toList();
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {

        Student student = studentRepository.findById(studentId)
        		.orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + studentId));        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setGender(studentDto.getGender());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setCourse(studentDto.getCourse());
        student.setDepartment(studentDto.getDepartment());
        student.setYear(studentDto.getYear());
        student.setAddress(studentDto.getAddress());

        Student updatedStudent = studentRepository.save(student);

        return StudentDto.builder()
                .studentId(updatedStudent.getStudentId())
                .firstName(updatedStudent.getFirstName())
                .lastName(updatedStudent.getLastName())
                .email(updatedStudent.getEmail())
                .phoneNumber(updatedStudent.getPhoneNumber())
                .gender(updatedStudent.getGender())
                .dateOfBirth(updatedStudent.getDateOfBirth())
                .course(updatedStudent.getCourse())
                .department(updatedStudent.getDepartment())
                .year(updatedStudent.getYear())
                .address(updatedStudent.getAddress())
                .build();
    }
    @Override
    public void deleteStudent(Long studentId) {

        Student student = studentRepository.findById(studentId)
        		.orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + studentId));
        studentRepository.delete(student);
    }
}