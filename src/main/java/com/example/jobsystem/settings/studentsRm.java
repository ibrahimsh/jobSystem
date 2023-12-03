package com.example.jobsystem.settings;

import com.example.jobsystem.entities.student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Qualifier("studentsRm")
public class studentsRm implements RowMapper<student> {

    @Override
    public student mapRow(ResultSet rs, int rowNum) throws SQLException {
        student s  = new student();
        String name = rs.getString("fname");
        String lname = rs.getString("lname");
        String email = rs.getString("email");
        String password = rs.getString("password");
        Long id = rs.getLong("studentid");
        s.setFname(name);
        s.setId(id);
        s.setEmail(email);
        s.setPassword(password);
        s.setLname(lname);
        return s;
    }
}
