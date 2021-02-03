package com.tekup.gld.project.elbetta.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.tekup.gld.project.elbetta.model.Product;
import com.tekup.gld.project.elbetta.model.Store;
import com.tekup.gld.project.elbetta.service.ProductService;
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
 * {@link ProductController } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

	/**
	 * The Product service.
	 */
	private final ProductService productService;

	@GetMapping("/get")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Product> getAll() {
		return productService.getAllProducts();
	}

	@GetMapping("/store-product/{storeId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Product> getStoreProducts(@PathVariable Long storeId) {
		return productService.getStoreProducts(storeId);
	}

	@PostMapping("/store-product/")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Product> getStoreProducts(@RequestBody Store store) {
		return productService.getStoreProducts(store);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/get/{id}")
	public Product getById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}


	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		return productService.createOrUpdateProduct(product);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PutMapping("/update")
	public Product modifyProduct(@RequestBody Product product) {
		return productService.createOrUpdateProduct(product);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
