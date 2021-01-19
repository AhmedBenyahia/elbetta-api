package com.tekup.gld.project.elbetta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gld.project.elbetta.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByTitle(String title);
}
