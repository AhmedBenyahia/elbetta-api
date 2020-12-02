package com.tekup.gld.project.elbetta.service.impl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;
import com.tekup.gld.project.elbetta.model.Address;
import com.tekup.gld.project.elbetta.model.InfoBancaire;
import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.repository.AddressRepository;
import com.tekup.gld.project.elbetta.repository.InfoBancaireRepository;
import com.tekup.gld.project.elbetta.repository.UserRepository;
import net.bytebuddy.description.NamedElement.WithOptionalName;

@Service
public class UserServiceImpl  implements UserService{
 
	private UserRepository reposUser;
	
	
	public UserRepository getReposUser() {
		return reposUser;
	}
	public void setReposUser(UserRepository reposUser) {
		this.reposUser = reposUser;
	
	
	}
	@Override
	public List<User> getAllUsers() {
		return reposUser.findAll();
	}

	@Override
	public User getUserById(long id) {
		Optional<User>opt=reposUser.findById(id);
		User user;
		if(opt.isPresent())
			user=opt.get();
		else 
			throw new NoSuchElementException("User with this id is not found");
		return user;
	}

	@Override
	public User createUser(User user) {
			return reposUser.save(user);
	}
	@Override
	public User modifyUser( User newUser) {
		return reposUser.save(newUser);
		
	}
	@Override
	public User deleteUser(long id) {
		User entity = this.getUserById(id);
		reposUser.deleteById(id);
		return entity;
			 
	 }
	@Autowired
	public UserServiceImpl(UserRepository reposUser) {
		super();
		this.reposUser = reposUser;
		
	}
	
	
	
}
