package com.example.jobsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class JobSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobSystemApplication.class, args);
    }

}
