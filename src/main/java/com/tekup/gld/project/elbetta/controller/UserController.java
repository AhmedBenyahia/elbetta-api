package com.tekup.gld.project.elbetta.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link UserController } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	/**
	 * The User service.
	 */
	@Autowired
	private UserService userService;

	@GetMapping("/get")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAll() {
		return userService.getAllUsers();
	}

	@GetMapping("/get/{id}")
	public User getById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}


	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PutMapping("/update/{id}")
	public User modifyUser(@RequestBody User newUser) {
		return userService.modifyUser(newUser);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public User deleteUser(@PathVariable("id") Long id) {
		return userService.deleteUser(id);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
