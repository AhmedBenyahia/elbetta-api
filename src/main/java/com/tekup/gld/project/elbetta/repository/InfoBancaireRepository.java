package com.tekup.gld.project.elbetta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gld.project.elbetta.model.Address;
import com.tekup.gld.project.elbetta.model.InfoBancaire;

public interface InfoBancaireRepository extends JpaRepository<InfoBancaire, Long>{
	Optional<InfoBancaire> findById(Long Id);
}
