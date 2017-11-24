package com.soinsoftware.persistence.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

/**
 * Interface for creating DAO objects.
 * 
 * @author Carlos Rodriguez
 * @since 1.0.0
 *
 * @param <T>
 *            Class that represents the table model.
 * @param <P>
 *            Class that represents the primary key.
 */
public interface DataAccessibleObject<T, P> {

	/**
	 * Called when record must be stored in database.
	 * 
	 * @param record
	 *            Object to be stored.
	 */
	void persist(T record);

	/**
	 * Called when record must be stored in database using a specific
	 * transaction.
	 * 
	 * @param transaction
	 *            {@link EntityTransaction} used to store record
	 * @param record
	 *            Object to be stored.
	 */
	void persist(EntityTransaction transaction, T record);

	/**
	 * When using transaction to store data, use this method to roll back
	 * transaction if anything goes wrong before finish it
	 * 
	 * @param transaction
	 *            {@link EntityTransaction} used.
	 */
	void rollbackTransaction(EntityTransaction transaction);

	/**
	 * Called when record must be deleted from database
	 * 
	 * @param record
	 *            Object to be deleted
	 */
	void delete(final T record);

	/**
	 * Called when it is required to load all data from database.
	 * 
	 * @return {@link List} with data loaded from database.
	 */
	List<T> selectAll();

	/**
	 * Called when it is required to load specific data using its primary key.
	 * 
	 * @param pk
	 *            Object that represents data primary key.
	 * 
	 * @return Model table data object if primary key used could load data, null
	 *         otherwise.
	 */
	T selectById(P pk);

	/**
	 * Close an application-managed entity manager.
	 */
	void close();
}
