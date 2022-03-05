package ru.azatnuriakhmetov.springboot.dataaccess;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.flywaydb.core.internal.jdbc.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import ru.azatnuriakhmetov.springboot.models.Student;
import ru.azatnuriakhmetov.springboot.models.Student.Gender;
import ru.azatnuriakhmetov.springboot.models.StudentCourse;
import ru.azatnuriakhmetov.springboot.utils.StudentCourseRowMapper;
import ru.azatnuriakhmetov.springboot.utils.StudentRowMapper;

@Repository
public class StudentDataAccessService {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> selectAllStudents() {
		String sql = "SELECT student_id, first_name, last_name, email, gender FROM student";
		List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
		return students;
	}

	public int insertStudent(UUID studentId, Student student) {
		// TODO Auto-generated method stub
		String sql = "INSERT into student (student_id, first_name, last_name, email, gender)" +
					"values (?, ?, ?, ?, ?::gender)";
		return jdbcTemplate.update(sql, studentId, student.getFirstName(), student.getLastName(), student.getEmail(), student.getGender().name().toUpperCase());
	}

	@SuppressWarnings("deprecation")
	public boolean isEmailTaken(String email) {
		// TODO Auto-generated method stub
		String sql = "SELECT EXISTS (SELECT 1 FROM student WHERE email = ?)";
		return jdbcTemplate.queryForObject(sql, new Object[] {email}, (resultSet, i) -> resultSet.getBoolean(1));
	}

	@SuppressWarnings("deprecation")
	public List<StudentCourse> selectAllStudentsCourses(UUID studentId) {
		// TODO Auto-generated method stub
		String sql = "SELECT student.student_id, course.course_id, "
				+ "course.name, course.description, course.department, "
				+ "course.teacher_name, student_course.start_date, "
				+ "student_course.end_date, student_course.grade FROM student "
				+ "JOIN student_course USING (student_id) "
				+ "JOIN course USING (course_id), "
				+ "WHERE student.student_id = ?";
		return jdbcTemplate.query(sql, new Object[]{studentId}, new StudentCourseRowMapper());
	}

}
