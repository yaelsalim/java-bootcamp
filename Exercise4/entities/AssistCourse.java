package com.bootcamp.entities;

import org.mongodb.morphia.annotations.Embedded;

/**
 * This class stores the data of a particular course that a student attends to.
 * 
 * @author Yael salim
 */

@Embedded
public class AssistCourse {

	private String course_name;
	private Double partial_note_1;
	private Double partial_note_2;
	private Double partial_note_3;
	private Double final_note;

	public AssistCourse() {

	}

	public AssistCourse(String course_name, Double partial_note_1, Double partial_note_2, Double partial_note_3, Double final_note) {
		this.course_name = course_name;
		this.setPartial_note_1(partial_note_1);
		this.setPartial_note_2(partial_note_2);
		this.setPartial_note_3(partial_note_3);
		this.final_note = final_note;

	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Double getFinal_note() {
		return final_note;
	}

	public void setFinal_note(Double final_note) {
		this.final_note = final_note;
	}

	public Double getPartial_note_1() {
		return partial_note_1;
	}

	public void setPartial_note_1(Double partial_note_1) {
		this.partial_note_1 = partial_note_1;
	}

	public Double getPartial_note_2() {
		return partial_note_2;
	}

	public void setPartial_note_2(Double partial_note_2) {
		this.partial_note_2 = partial_note_2;
	}

	public Double getPartial_note_3() {
		return partial_note_3;
	}

	public void setPartial_note_3(Double partial_note_3) {
		this.partial_note_3 = partial_note_3;
	}

}
