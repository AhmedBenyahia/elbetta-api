package com.tekup.gld.project.elbetta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gld.project.elbetta.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
