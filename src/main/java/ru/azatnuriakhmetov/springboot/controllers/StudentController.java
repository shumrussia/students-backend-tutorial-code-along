package ru.azatnuriakhmetov.springboot.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.azatnuriakhmetov.springboot.exceptions.ApiException;
import ru.azatnuriakhmetov.springboot.exceptions.ApiRequestException;
import ru.azatnuriakhmetov.springboot.models.Student;
import ru.azatnuriakhmetov.springboot.models.Student.Gender;
import ru.azatnuriakhmetov.springboot.models.StudentCourse;
import ru.azatnuriakhmetov.springboot.services.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {
	
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> getAllStudents() throws SQLException {
		return studentService.getAllStudents();
	}
	
	@GetMapping(path = "{studentId}/courses")
	public List<StudentCourse> getAllCoursesForStudent(@PathVariable("studentId") UUID studentId) {
		System.out.println(studentId);
		return studentService.getAllCoursesForStudent(studentId);
	}
	@PostMapping()
	public void addNewStudent(@RequestBody @Valid Student student) {
		studentService.addNewStudent(student);
	}
}
