package com.tekup.gld.project.elbetta.controller;

import java.security.Principal;

import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link AuthController } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {


	/**
	 * The User service.
	 */
	private final UserService userService;

	@GetMapping("/login")
	public User auth(Principal principal) {
		return userService.getUserByUsername(principal.getName()); //TODO: check if the principle name is the same as the username
	}
	
}


