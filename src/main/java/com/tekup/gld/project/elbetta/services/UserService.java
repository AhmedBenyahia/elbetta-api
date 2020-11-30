package com.tekup.gld.project.elbetta.services;

import java.util.ArrayList;
import java.util.List;

import com.tekup.gld.project.elbetta.models.UserEntity;


public interface UserService {
	List<UserEntity> getAllUsers();
	UserEntity getUserById(Long Id);
	UserEntity createUser(UserEntity user);
	UserEntity modifyUser(Long id,UserEntity newUser);
	UserEntity deleteUser(Long id);
	double getAverageAge();
	

}
