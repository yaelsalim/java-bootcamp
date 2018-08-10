package com.globant.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -7788619177798333712L;

	@Id
	private String id;

	@Indexed(unique = true)
	private String userName;

	private String password;

	private String name;

	public User() {
	}

	public User(String username, String name, String password) {

		this.userName = username;
		this.password = password;
		this.name = name;
	}

	/**
	 * Getter method for username parameter.
	 * 
	 * @return
	 */
	public String getUsername() {
		return userName;
	}

	/**
	 * Setter method for username parameter.
	 * 
	 * @return
	 */
	public void setUsername(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter method for password parameter.
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for password parameter.
	 * 
	 * @return
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method for name parameter.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name parameter.
	 * 
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
