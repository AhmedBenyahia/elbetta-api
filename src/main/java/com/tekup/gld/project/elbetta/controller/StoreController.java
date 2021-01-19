package com.tekup.gld.project.elbetta.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.tekup.gld.project.elbetta.model.Store;
import com.tekup.gld.project.elbetta.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link StoreController } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@RestController
@RequestMapping("/store")
@AllArgsConstructor
public class StoreController {

	/**
	 * The Store service.
	 */
	private final StoreService storeService;

	@GetMapping("/get")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Store> getAll() {
		return storeService.getAllStores();
	}

	@GetMapping("/get-my-stores/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Store> getAll(@PathVariable Long userId) {
		return storeService.getUserStores(userId);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/get/{id}")
	public Store getById(@PathVariable("id") Long id) {
		return storeService.getStoreById(id);
	}


	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PostMapping("/create")
	public Store createStore(@RequestBody Store store) {
		return storeService.createOrUpdateStore(store);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PutMapping("/update")
	public Store modifyStore(@RequestBody Store store) {
		return storeService.createOrUpdateStore(store);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public void deleteStore(@PathVariable("id") Long id) {
		storeService.deleteStore(id);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
