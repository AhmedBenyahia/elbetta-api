package com.tekup.gld.project.elbetta.service;

import java.util.List;

import com.tekup.gld.project.elbetta.model.Product;

/**
 * {@link ProductService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
public interface ProductService {

	/**
	 * Gets all products.
	 *
	 * @return the all products
	 */
	List<Product> getAllProducts();

	/**
	 * Gets product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 */
	Product getProductById(Long id);

	/**
	 * Create or update product product.
	 *
	 * @param product the product
	 * @return the product
	 */
	Product createOrUpdateProduct(Product product);

	/**
	 * Gets product by title.
	 *
	 * @param title the title
	 * @return the product by title
	 */
	Product getProductByTitle(String title);

	/**
	 * Delete product.
	 *
	 * @param id the id
	 */
	void deleteProduct(Long id);
}
