package com.tekup.gld.project.elbetta.service;

import java.util.List;

import com.tekup.gld.project.elbetta.model.Store;

/**
 * {@link StoreService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
public interface StoreService {
	/**
	 * Gets all stores.
	 *
	 * @return the all stores
	 */
	List<Store> getAllStores();

	/**
	 * Gets store by id.
	 *
	 * @param id the id
	 * @return the store by id
	 */
	Store getStoreById(Long id);

	/**
	 * Create or update store store.
	 *
	 * @param store the store
	 * @return the store
	 */
	Store createOrUpdateStore(Store store);

	/**
	 * Gets store by title.
	 *
	 * @param title the title
	 * @return the store by title
	 */
	Store getStoreByTitle(String title);

	/**
	 * Delete store.
	 *
	 * @param id the id
	 */
	void deleteStore(Long id);

	List<Store> getUserStores(Long userId);
}
