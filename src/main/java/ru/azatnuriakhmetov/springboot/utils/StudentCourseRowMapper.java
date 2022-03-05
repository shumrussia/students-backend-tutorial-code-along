package ru.azatnuriakhmetov.springboot.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;

import ru.azatnuriakhmetov.springboot.models.Student;
import ru.azatnuriakhmetov.springboot.models.StudentCourse;

public class StudentCourseRowMapper implements RowMapper<StudentCourse>{

	@Override
	public StudentCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		StudentCourse studentCourse = new StudentCourse(
				UUID.fromString(rs.getString("student_id")),
				UUID.fromString(rs.getString("course_id")),
				rs.getString("name"),
				rs.getString("description"),
				rs.getString("department"), 
				rs.getString("teacher_name"), 
				rs.getDate("start_date").toLocalDate(),
				rs.getDate("end_date").toLocalDate(),
				Optional.ofNullable(rs.getString("grade")).map(Integer::parseInt).orElse(null));
		return studentCourse;
	}

}
