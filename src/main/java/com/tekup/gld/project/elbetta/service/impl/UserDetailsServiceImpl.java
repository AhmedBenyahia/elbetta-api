package com.tekup.gld.project.elbetta.service.impl;

import java.util.Optional;

import com.tekup.gld.project.elbetta.model.EBUserDetails;
import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username));
		return new EBUserDetails(user.get());
	}
	public void save(User user) {
        userRepository.save(user);
}}
