package com.tekup.gld.project.elbetta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link TestController } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@RestController
@RequestMapping("/")
public class TestController {

//	/**
//	 * The Test service.
//	 */
//	@Autowired
//	private TestService TestService;

	@GetMapping("/admin")
	public String admin() {
		return "Hello admin !!";
	}

	@GetMapping("/user")
	public String user() {
		return "Hello user !!";
	}

	@GetMapping("/home")
	public String home() {
		return "Hello all !!";
	}
}
