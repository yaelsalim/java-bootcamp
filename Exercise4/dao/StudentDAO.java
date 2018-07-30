package com.bootcamp.dao;

import java.util.ArrayList;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import com.bootcamp.entities.AssistCourse;
import com.bootcamp.entities.Student;
import com.mongodb.MongoClient;

/**
 * This is an interface to access to a student's data.
 * 
 * @author Yael salim
 */

public class StudentDAO extends BasicDAO<Student, String> {

	public StudentDAO(Morphia morphia, MongoClient mongo, String dbName) {
		super(mongo, morphia, dbName);
	}

	public void findStudents(Datastore datastore, String course_name) {
		Query<AssistCourse> queryNotes = datastore.createQuery(AssistCourse.class).filter("course_name", course_name)
				.filter("final_note >= ", 4);

		ArrayList<Student> retrievedStudents = (ArrayList<Student>) datastore.find(Student.class).field("courses").elemMatch(queryNotes)
				.asList();

		for (Student retrievedStudent : retrievedStudents) {
			System.out.println(retrievedStudent.getFirstName());
			System.out.println(retrievedStudent.getLastName());
			System.out.println(retrievedStudent.getCourses().get(0).getFinal_note());
		}

	}

}