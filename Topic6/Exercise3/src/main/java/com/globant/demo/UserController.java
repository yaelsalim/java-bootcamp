package com.globant.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.globant.models.User;
import com.globant.services.UserService;
import com.globant.services.UserServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class UserController {

	private UserService userService = new UserServiceImpl();

	@RequestMapping(value = "api/users")
	public @ResponseBody ArrayList<User> getUsers() {
		return userService.getUsers();
	}

	@RequestMapping(value = "api/findByName")
	@ApiOperation(value = "Find users by name", nickname = "Users by name.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"), })
	public @ResponseBody ResponseEntity<?> findByName(@RequestParam(value = "name", required = true) String name) {
		List<User> usersFound = userService.findByName(name);
		if (usersFound == null) {
			return new ResponseEntity<String>("User not found. ", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<User>>(usersFound, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "api/findByUserName")
	@ApiOperation(value = "Find user by username", nickname = "User by name.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"), })
	public @ResponseBody ResponseEntity<?> findByUserName(
			@RequestParam(value = "nickname", required = true) String nickname) {

		if (!userService.checkForUser(nickname)) {
			return new ResponseEntity<String>("User not found. ", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<User>(userService.findByUserName(nickname), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "api/add")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Add a new user.", nickname = "Add user.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	public @ResponseBody ResponseEntity<?> addUser(@RequestParam(value = "nickname") String nickname,
			@RequestParam(value = "password") String password, @RequestParam(value = "name") String name) {
		if (userService.checkForUser(nickname)) {
			return new ResponseEntity<String>("User already exists. ", HttpStatus.BAD_REQUEST);
		} else {
			User newUser = new User(nickname, password, name);
			userService.create(newUser);
			return new ResponseEntity<User>(newUser, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "api/delete")
	@ApiOperation(value = "Deletes a user.", nickname = "Delete user.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	public @ResponseBody ResponseEntity<?> deleteUser(
			@RequestParam(value = "nickname", required = true) String nickname) {
		if (!userService.checkForUser(nickname)) {
			return new ResponseEntity<String>("User not found. ", HttpStatus.BAD_REQUEST);
		} else {
			userService.delete(nickname);
			return new ResponseEntity<String>("User: " + nickname + " deleted. ", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "api/update")
	@ApiOperation(value = "Updates a user.", nickname = "Update user.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	public @ResponseBody ResponseEntity<String> updateUser(
			@RequestParam(value = "nickname", required = true) String nickname,
			@RequestParam(value = "name") String name) {
		if (!userService.checkForUser(nickname)) {
			return new ResponseEntity<String>("User not found. ", HttpStatus.BAD_REQUEST);
		} else {
			userService.update(nickname, name);
			return new ResponseEntity<String>("User: " + nickname + " updated. ", HttpStatus.OK);
		}
	}

}
