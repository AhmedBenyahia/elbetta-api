package com.tekup.gld.project.elbetta.service.impl;

import java.util.List;

import com.tekup.gld.project.elbetta.model.Address;

public interface AddressService {
	List<Address> getAllAddress();

	Address getAddressById(long id);

	Address createAddress(Address address);

	Address modifyAddress(Address newAddress);

	Address deleteAddress(long id);

	Address addAddress(Address newAddress);


}
