package com.example.jobsystem.repository;

import com.example.jobsystem.entities.student;
import com.example.jobsystem.queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
@Component
@Qualifier("studentsRepository")
public class studentRepos implements studentsRepository{
    private final JdbcTemplate jdbcTemplate;


    // RowMapper is interface that map ResultSet (represents a single row from sql result java natively) to a
    // class that is in <>

    private final RowMapper<student> rowMapper;

    public studentRepos(JdbcTemplate jdbcTemplate, RowMapper<student> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }
    public void createTable()
    {
        String q = "create table  if  not Exists employees(id bigint not NULL GENERATED ALWAYS AS IDENTITY" +
                ", name varchar(255),address varchar(255), age int)";
        this.jdbcTemplate.update(q);
    }


    @Override
    public student addStudent(student s) {

        PreparedStatementCreator preparedStatementCreator = (Connection connection) -> {

            // the main point is to prepare SQL

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.students(firstname,lastname,email,pass)" +
                            "\t VALUES (?,?,?,?)");

            preparedStatement.setString(1, s.getFname());
            preparedStatement.setString(2,s.getLname());
            preparedStatement.setString(3,s.getEmail());
            preparedStatement.setString(4,s.getPassword());

            return preparedStatement;

        };
//        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
//
//        Number keyGenerated = generatedKeyHolder.getKey();
//        Long key = keyGenerated.longValue();

        jdbcTemplate.update(preparedStatementCreator);
        return s;
    }

    @Override
    public student getStudent(Long id) {
        student s = jdbcTemplate.queryForObject("select * from students where id = " + id, rowMapper);
//        jdbcTemplate.queryForObject("select * from restaurants where id = ?", rowMapper, id);

        return s;
    }

    @Override
    public ArrayList<student> getAllStudent() {
        return null;
    }
}
