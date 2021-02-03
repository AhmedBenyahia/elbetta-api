package com.tekup.gld.project.elbetta.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gld.project.elbetta.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByTitle(String title);

	Optional<List<Product>> findByStore_Id(Long storeId);

	Optional<ArrayList<Product>> findByStore_Title(String title);
}
