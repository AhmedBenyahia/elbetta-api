package com.tekup.gld.project.elbetta.service.impl;

import java.util.Optional;

import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.repository.UserRepository;
import com.tekup.gld.project.elbetta.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * {@link UserDetailsService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/**
	 * The UserDetails service.
	 */
	@Autowired
	private UserRepository userRepository;


	@Override
	public Optional<User> loadUserByUsernameAndActive(String userName, boolean active) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(userName);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException(userName);
		}
		return user;
	}
}
