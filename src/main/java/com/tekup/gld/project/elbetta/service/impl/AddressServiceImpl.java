package com.tekup.gld.project.elbetta.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.tekup.gld.project.elbetta.model.Address;
import com.tekup.gld.project.elbetta.repository.AddressRepository;
import com.tekup.gld.project.elbetta.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {


	private AddressRepository reposAddress;

	@Autowired
	public AddressServiceImpl(AddressRepository reposAddress) {
		super();
		this.reposAddress = reposAddress;
	}


	public AddressRepository getReposAddress() {
		return reposAddress;
	}

	public void setReposAddress(AddressRepository reposAddress) {
		this.reposAddress = reposAddress;
	}

	@Override
	public List<Address> getAllAddress() {
		return reposAddress.findAll();

	}

	@Override
	public Address getAddressById(long id) {
		Optional<Address> opt = reposAddress.findById(id);
		Address adres;
		if (opt.isPresent()) {
			adres = opt.get();
		}
		else {
			throw new NoSuchElementException("address with this id is not found");
		}
		return adres;
	}

	@Override
	public Address createAddress(Address address) {
		return reposAddress.save(address);
	}

	@Override
	public Address deleteAddress(long id) {
		Address entity = this.getAddressById(id);
		reposAddress.deleteById(id);
		return entity;
	}

	@Override
	public Address modifyAddress(Address newAddress) {
		return reposAddress.save(newAddress);

	}

	public Address addAddress(Address newAddress) {
		newAddress.setId(newAddress.getId());

		return newAddress;
	}
}
