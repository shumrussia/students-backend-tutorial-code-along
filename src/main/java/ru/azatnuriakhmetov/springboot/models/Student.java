package ru.azatnuriakhmetov.springboot.models;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

	private final UUID studentId;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final Gender gender;

	public Student(	@JsonProperty("studentId") UUID studentId,
			
					@NotBlank
					@JsonProperty("firstName") String firstName,
					
					@NotBlank
					@JsonProperty("lastName") String lastName,
					
					@NotBlank
					@JsonProperty("email") String email,
					
					@NotNull
					@JsonProperty("gender") Gender gender) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}

	public enum Gender {
		MALE, FEMALE
	}

	public UUID getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Gender getGender() {
		return gender;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Student id is %s, first name is %s, last name is %s, email is %s, gender is %s", studentId, firstName, lastName, email, gender );
	}

}
