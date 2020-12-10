package com.tekup.gld.project.elbetta.service.impl;

import java.util.List;

import com.tekup.gld.project.elbetta.model.User;

public interface UserService {
	List<User> getAllUsers();
	User getUserById(long id);
	User createUser(User user);
	User deleteUser(long id);
	User modifyUser(User newUser);


	
	

}
