package com.example.jobsystem.settings;

import com.example.jobsystem.entities.student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class appSettings {
   @Bean
    public RowMapper<student> studentsRowMapper() {
        System.out.println("inside tow mapper");
        return new BeanPropertyRowMapper<>(student.class);
    }
}
