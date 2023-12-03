package com.example.jobsystem.appEvents;

import com.example.jobsystem.entities.student;
import com.example.jobsystem.repository.studentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Qualifier("studentsRowMapper")
public class studentRepEvent {
   
    private final studentsRepository studentRepository;


    public studentRepEvent(@Qualifier("studentsRepository") studentsRepository studentRepo) {
        System.out.println("called repos");
        this.studentRepository =studentRepo;
    }

    // @EventListener(ApplicationReadyEvent.class) it marks that this method
    // must be executed ones when application is ready
    @EventListener(ApplicationReadyEvent.class)
    public void studentRepositoryBackGround() {
       // student s = studentRepository.getStudent(5L);
       // System.out.println(s);
        studentRepository.createTable();

        student s1 = new student("ibrahim","shweiki", "ibrahim@gmail.com","12345");
//        List<Restaurant> restaurantsToBeAdded = Arrays.asList(
//                new Restaurant(),
//                new Restaurant(),
//                new Restaurant());
//        restaurantsToBeAdded.forEach(rest -> iRestaurantRepository.add(rest));
        student addStd = studentRepository.addStudent(s1);
        System.out.println("adding student :" + addStd);

    }
}
