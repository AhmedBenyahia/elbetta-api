package com.tekup.gld.project.elbetta.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.gld.project.elbetta.models.UserEntity;
import com.tekup.gld.project.elbetta.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService{
 
	private UserRepository repos;
	@Autowired
	public UserServiceImpl(UserRepository repos) {
	super();
	this.repos = repos;
}

	@Override
	public List<UserEntity> getAllUsers() {
		return repos.findAll();
	}

	@Override
	public UserEntity getUserById(Long id) {
		Optional<UserEntity>opt=repos.findById(id);
		UserEntity entity;
		if(opt.isPresent())
			entity=opt.get();
		else 
			throw new NoSuchElementException("user with this id is not found");
		
		return null;
	}

	@Override
	public UserEntity createUser(UserEntity user) {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public UserEntity modifyUser(Long id, UserEntity newUser) {
		UserEntity user=this.getUserById(id);
		if(newUser.getName()!=null)
			user.setName(newUser.getName());
		if(newUser.getAdress()!=null)
			user.setAdress(newUser.getAdress());
		
		return repos.save(user);
	}

	@Override
	public UserEntity deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAverageAge() {
		// TODO Auto-generated method stub
		return 0;
	}




	
}




