package com.example.jobsystem.services;

import com.example.jobsystem.entities.student;
import com.example.jobsystem.repository.studentRepos;
import com.example.jobsystem.repository.studentsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class studentService implements studentsRepository {

    private final studentRepos repos;

    public studentService(studentRepos repos) {
        this.repos = repos;
    }

    @Override
    public student addStudent(student s) {
        return repos.addStudent(s);
    }

    @Override
    public student getStudent(Long id) {
        return null;
    }

    @Override
    public ArrayList<student> getAllStudent() {
        return null;
    }

    @Override
    public void createTable() {

    }
}
