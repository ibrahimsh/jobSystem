package com.example.jobsystem.Controller;

import com.example.jobsystem.entities.student;
import com.example.jobsystem.repository.studentsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.jobsystem.services.studentService;

import java.util.ArrayList;

@Controller
@RestController
public class studentControllers implements studentsRepository {
   public final studentService service;

    public studentControllers(studentService service) {
        this.service = service;
    }
    @PostMapping("student/addStudents")
    @Override
    public @ResponseBody student addStudent(@RequestBody student s) {
        return service.addStudent(s);
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
