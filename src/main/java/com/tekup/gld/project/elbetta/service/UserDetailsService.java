package com.tekup.gld.project.elbetta.service;

import java.util.Optional;

import com.tekup.gld.project.elbetta.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * {@link UserDetailsService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
public interface UserDetailsService {

	Optional<User> loadUserByUsernameAndActive(String userName, boolean active)
			throws UsernameNotFoundException;
}
