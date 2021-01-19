package com.tekup.gld.project.elbetta.service;

import java.security.Principal;
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
	User getUserById(Long id);

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
	 */
	void deleteUser(Long id);

	/**
	 * Modify user user.
	 *
	 * @param newUser the new user
	 * @return the user
	 */
	User modifyUser(User newUser);


	/**
	 * Gets user by username.
	 *
	 * @return the user by username
	 */
	User getUserByUsername(String username);
}
