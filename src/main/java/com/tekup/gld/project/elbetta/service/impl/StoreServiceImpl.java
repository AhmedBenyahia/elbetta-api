package com.tekup.gld.project.elbetta.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import com.tekup.gld.project.elbetta.model.EBUserDetails;
import com.tekup.gld.project.elbetta.model.Store;
import com.tekup.gld.project.elbetta.model.User;
import com.tekup.gld.project.elbetta.repository.StoreRepository;
import com.tekup.gld.project.elbetta.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * {@link StoreService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

	/**
	 * The Store service.
	 */
	private final StoreRepository storeRepository;

	@Override
	public List<Store> getAllStores() {
		return storeRepository.findAll();
	}

	@Override
	public Store getStoreById(Long id) {
		return storeRepository.findById(id)
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Store createOrUpdateStore(Store store) {
		if (store.getId() == null) {
			EBUserDetails principal = (EBUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			store.setCreationDate(LocalDateTime.now());
			store.setAvgRating(0.0);
			store.setOwner(new User(principal.getId()));
		}
		return storeRepository.save(store);
	}

	@Override
	public Store getStoreByTitle(String title) {
		return storeRepository.findByTitle(title).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public void deleteStore(Long id) {
		storeRepository.deleteById(id);
	}

	@Override
	public List<Store> getUserStores(Long userId) {
		return storeRepository.findByOwner_Id(userId)
				.orElseThrow(NoSuchElementException::new);
	}

}
