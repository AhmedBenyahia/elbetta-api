package com.tekup.gld.project.elbetta.repository;

import java.util.Optional;

import com.tekup.gld.project.elbetta.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
	Optional<Address> findById(Long Id);
}
