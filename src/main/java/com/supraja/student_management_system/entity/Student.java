package com.supraja.student_management_system.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "STUDENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "STUDENT_SEQ",
            allocationSize = 1
    )
    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "COURSE")
    private String course;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "ADDRESS")
    private String address;
}