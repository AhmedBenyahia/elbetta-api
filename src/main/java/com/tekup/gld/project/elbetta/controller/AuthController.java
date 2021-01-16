package com.tekup.gld.project.elbetta.controller;

import java.security.Principal;

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
public class AuthController {

	@GetMapping("/login")
	public Principal auth(Principal principal) {
		return principal;
	}
	
}


