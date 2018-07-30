package com.bootcamp.entities;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

/**
 * 
 * This entity is a POJO which stores a course's data through a DAO class.
 *
 * @author Yael salim
 */

@Entity("course")
public class Course {
	@Id
	private String course_name;

	@Reference("assigned_teacher")
	private Teacher assigned_teacher;

	@Property("startTime")
	private Date startTime;

	@Property("endTime")
	private Date endTime;

	public Course(String name, Teacher teacherId, Date startime, Date endtime) {
		this.course_name = name;
		this.assigned_teacher = teacherId;
		this.startTime = startime;
		this.endTime = endtime;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Teacher getAssigned_teacher() {
		return assigned_teacher;
	}

	public void setAssigned_teacher(Teacher assigned_teacher) {
		this.assigned_teacher = assigned_teacher;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
