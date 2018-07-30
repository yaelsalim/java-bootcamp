package com.bootcamp.demo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.bootcamp.dao.StudentDAO;
import com.bootcamp.entities.Student;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * 
 * This program fetches all students whose notes in a specific course were
 * greater than 4.
 * 
 * @author Yael salim
 *
 */

public class DemoMorphia {

	public static void main(String[] args) {

		String dbName = new String("high-school");
		MongoClient mongo = new MongoClient(new ServerAddress("127.0.0.1", 27017));
		Morphia morphia = new Morphia();
		Datastore datastore = morphia.createDatastore(mongo, dbName);

		morphia.mapPackage("com.bootcamp.entities");
		System.out.println(morphia.isMapped(Student.class));

		StudentDAO studentDAO = new StudentDAO(morphia, mongo, dbName);
		studentDAO.findStudents(datastore, "Physics");

	}

}
