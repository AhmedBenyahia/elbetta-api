package com.tekup.gld.project.elbetta.service.impl;

import java.util.List;

import com.tekup.gld.project.elbetta.model.User;

/**
 * The interface User service.
 */
public interface UserService {

	/**
	 * Gets all users.
	 *
	 * @return the all users
	 */
	List<User> getAllUsers();

	/**
	 * Gets user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	User getUserById(long id);

	/**
	 * Create user user.
	 *
	 * @param user the user
	 * @return the user
	 */
	User createUser(User user);

	/**
	 * Delete user user.
	 *
	 * @param id the id
	 * @return the user
	 */
	User deleteUser(long id);

	/**
	 * Modify user user.
	 *
	 * @param newUser the new user
	 * @return the user
	 */
	User modifyUser(User newUser);


	
	

}
