package com.tekup.gld.project.elbetta.controller;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.service.impl.UserService;

/**
 * {@link TestController } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api")
public class TestController {
	
	private final UserService service;

	@Autowired
	public TestController(UserService service) {
		super();
		this.service = service;
	}
	@GetMapping("/user/all")
	public List<User>getAll(){
			return service.getAllUsers();
	}
	@GetMapping("/{id}")
	public User getById(@PathVariable ("id")Long id)
	{
		return service.getUserById(id);
	}
	@PostMapping
	public User createUser(@RequestBody User user) 
	{
		return service.createUser(user);
	}
	
	@PutMapping("/{id}")
	public User modifyUser(@RequestBody User newUser) 
	{
		return service.modifyUser( newUser);
	}
	
	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable("id")long id)
	{
		return service.deleteUser(id);
	}
	
	/*@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) 
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	

}
}
*/
//	/**
//	 * The Test service.
//	 */
	/*@Autowired
	private TestService TestService;

	@GetMapping("/admin")
	public String admin() {
		return "Hello admin !!";
	}

	@GetMapping("/user")
	public String user() {
		return "Hello user !!";
	}

	@GetMapping("/home")
	public String home()
	{
		return "Hello all !!";
	}  */}
