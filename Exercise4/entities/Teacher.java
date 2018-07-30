package com.bootcamp.entities;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * 
 * This entity is a POJO which stores a teacher's data through a DAO class.
 *
 */

@Entity("teacher")
public class Teacher {

	@Id
	private ObjectId id;

	@Property("first_name")
	private String firstName;

	@Property("last_name")
	private String lastName;

	@Property("birthday")
	private Date birthDay;

	public Teacher(String firstName, String lastName, Date birthDay) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;

	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

}
