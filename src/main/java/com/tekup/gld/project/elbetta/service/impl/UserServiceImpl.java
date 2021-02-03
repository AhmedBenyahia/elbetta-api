package com.tekup.gld.project.elbetta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.repository.UserRepository;
import com.tekup.gld.project.elbetta.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository reposUser;

	@Override
	public List<User> getAllUsers() {
		return reposUser.findAll();
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> opt = reposUser.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new NoSuchElementException("User with this id is not found");
	}

	@Override
	public User createUser(User user) {
		user.setRoles("USER");
		return reposUser.save(user);
	}

	@Override
	public User modifyUser(User newUser) {
		return reposUser.save(newUser);

	}

	@Override
	public User getUserByUsername(String username) {
		return reposUser.findByUsername(username).orElse(null);
	}

	@Override
	public void deleteUser(Long id) {
		reposUser.deleteById(id);
	}


}
