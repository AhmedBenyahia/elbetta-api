package com.tekup.gld.project.elbetta.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;


import com.tekup.gld.project.elbetta.models.UserEntity;
import com.tekup.gld.project.elbetta.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private UserService service;

	@Autowired
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	@GetMapping
	public List<UserEntity>getAll()
	{
		return service.getAllUsers();
	}
	@GetMapping("/{id}")
	public UserEntity getById(@PathVariable("id")Long id)
	{
		return service.getUserById(id);
	}
	
	public UserEntity createUser(@RequestBody UserEntity user)
	{
		return service.createUser(user);
		
	}
	
	@PutMapping("/{id}")
	public UserEntity modifyPreson(@PathVariable("id")long id,@RequestBody UserEntity newUser) {
		return service.modifyUser(id, newUser);
	}
	
	@DeleteMapping("/{id}")
	public UserEntity deletePerson(@PathVariable("id")long id) {
		return service.deleteUser(id);
	}
	
	@GetMapping("/average/age")
	public double getUserAverageAge() {
		return service.getAverageAge();
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	

}
