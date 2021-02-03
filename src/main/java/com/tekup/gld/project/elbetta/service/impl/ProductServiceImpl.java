package com.tekup.gld.project.elbetta.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.tekup.gld.project.elbetta.model.EBUserDetails;
import com.tekup.gld.project.elbetta.model.Product;
import com.tekup.gld.project.elbetta.model.Store;
import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.repository.ProductRepository;
import com.tekup.gld.project.elbetta.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * {@link ProductServiceImpl } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	/** The Product service. */
	private final ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Product createOrUpdateProduct(Product product) {
		if (product.getId() == null) {
			EBUserDetails principal = (EBUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			product.setCreationDate(LocalDateTime.now());
			product.setCreatedBy(principal.getUsername());
			product.setTotalStock(product.getCurrentStock());
		}
		return productRepository.save(product);
	}

	@Override
	public Product getProductByTitle(String title) {
		return productRepository.findByTitle(title).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> getStoreProducts(Long storeId) {
		return productRepository.findByStore_Id(storeId).orElse(new ArrayList<>());
	}

	@Override
	public List<Product> getStoreProducts(Store store) {
		if (store.getId() != null) {
			return productRepository.findByStore_Id(store.getId()).orElse(new ArrayList<>());
		}
		else if (!store.getTitle().isEmpty()) {
			return productRepository.findByStore_Title(store.getTitle()).orElse(new ArrayList<>());
		}
		return new ArrayList<>();
	}

}
