package com.example.jobsystem.repository;

import com.example.jobsystem.entities.student;

import java.util.ArrayList;

public interface studentsRepository {

    student addStudent(student s);
    student getStudent(Long id);
    ArrayList<student> getAllStudent();
    void createTable();
}
