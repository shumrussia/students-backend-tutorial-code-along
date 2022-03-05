package ru.azatnuriakhmetov.springboot.models;

import java.time.LocalDate;
import java.util.UUID;

public class StudentCourse {
	
	private final UUID studentId;
	private final UUID courseId;
	private final String name;
	private final String description;
	private final String teacherName;
	private final LocalDate startDate;
	private final LocalDate endDate;
	private final Integer grade;
	private final String department;
	
	
	public StudentCourse(UUID studentId, UUID courseId, String name, String description, String department, String teacherName,  LocalDate startDate, LocalDate endDate, Integer grade) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.department = department;
		this.teacherName = teacherName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.grade = grade;
	}


	public String getDepartment() {
		return department;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public UUID getStudentId() {
		return studentId;
	}


	public UUID getCourseId() {
		return courseId;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public Integer getGrade() {
		return grade;
	}
	

}
