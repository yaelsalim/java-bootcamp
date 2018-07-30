package com.bootcamp.entities;

import java.util.ArrayList;
import java.util.Date;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * This entity is a POJO which stores a student's data through a DAO class.
 * 
 * @author Yael salim
 */

@Entity("student")
public class Student {
	@Id
	private int id;

	@Property("first_name")
	private String firstName;

	@Property("last_name")
	private String lastName;

	@Property("birthday")
	private Date birthDay;

	@Embedded("courses")
	private ArrayList<AssistCourse> courses;

	public Student() {

	}

	public Student(String firstName, String lastName, int id_student) {
		this.id = id_student;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = new ArrayList<AssistCourse>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<AssistCourse> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<AssistCourse> courses) {
		this.courses = courses;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

}