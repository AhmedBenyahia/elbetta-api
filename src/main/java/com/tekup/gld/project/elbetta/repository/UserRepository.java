package com.tekup.gld.project.elbetta.repository;

import java.util.Optional;

import com.tekup.gld.project.elbetta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String Email);
}
