package com.tekup.gld.project.elbetta.service.impl;

import java.util.List;

import com.tekup.gld.project.elbetta.model.Address;
import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.repository.AddressRepository;

public class AddressServiceImpl implements AddressService{
	private AddressRepository reposAddress;
	
	public Address modifyAddress( Address newAddress)
	{
		return reposAddress.save(newAddress);

	}
}
