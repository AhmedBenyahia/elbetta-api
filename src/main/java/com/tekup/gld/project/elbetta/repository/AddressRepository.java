package com.tekup.gld.project.elbetta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gld.project.elbetta.model.Address;
import com.tekup.gld.project.elbetta.model.User;

public interface AddressRepository extends JpaRepository<Address,Long>{
	Optional<Address> findById(Long Id);
}
