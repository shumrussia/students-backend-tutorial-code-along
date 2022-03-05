package ru.azatnuriakhmetov.springboot.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;

import ru.azatnuriakhmetov.springboot.models.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student(UUID.fromString(rs.getString("student_id")), 
				rs.getString("first_name"), 
				rs.getString("last_name"),
				rs.getString("email"),
				Student.Gender.valueOf(rs.getString("gender").toUpperCase()));
		return student;
	}

}
