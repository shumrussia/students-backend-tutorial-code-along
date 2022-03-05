package ru.azatnuriakhmetov.springboot.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.azatnuriakhmetov.springboot.dataaccess.StudentDataAccessService;
import ru.azatnuriakhmetov.springboot.exceptions.ApiRequestException;
import ru.azatnuriakhmetov.springboot.models.Student;
import ru.azatnuriakhmetov.springboot.models.Student.Gender;
import ru.azatnuriakhmetov.springboot.models.StudentCourse;
import ru.azatnuriakhmetov.springboot.validators.EmailValidator;

@Service
public class StudentService {
	
	private final StudentDataAccessService studentDataAccessService;
	private final EmailValidator emailValidator;
	
	@Autowired
	private StudentService(StudentDataAccessService studentDataAccessService) {
		super();
		this.studentDataAccessService = studentDataAccessService;
		this.emailValidator = new EmailValidator();
	}

	public List<Student> getAllStudents() throws SQLException {
		return studentDataAccessService.selectAllStudents();
	}

	public void addNewStudent(Student student) {
		this.addNewStudent(null, student);
	}
	
	private void addNewStudent(UUID studentId, Student student) {
		UUID newStudentId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());
		
		if (!emailValidator.test(student.getEmail())) {
			throw new ApiRequestException(student.getEmail() + " is not valid");
		}
		
		if (studentDataAccessService.isEmailTaken(student.getEmail())) {
			throw new ApiRequestException(student.getEmail() + " is already taken");
		} else {
			studentDataAccessService.insertStudent(newStudentId, student);
		}
		
	}

	public List<StudentCourse> getAllCoursesForStudent(UUID studentId) {
		// TODO Auto-generated method stub
		return studentDataAccessService.selectAllStudentsCourses(studentId);
	}
}
