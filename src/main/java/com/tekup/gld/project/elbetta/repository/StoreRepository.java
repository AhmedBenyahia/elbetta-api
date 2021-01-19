package com.tekup.gld.project.elbetta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gld.project.elbetta.model.Store;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	Optional<Store> findByTitle(String title);

	Optional<List<Store>> findByOwner_Id(Long userId);
}
