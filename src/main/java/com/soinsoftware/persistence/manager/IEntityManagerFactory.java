package com.soinsoftware.persistence.manager;

import javax.persistence.EntityManager;

/**
 * Interface for creating entity manager factory that will help to create DAO
 * objects.
 * 
 * @author Carlos Rodriguez
 * @since 1.0.0
 *
 */
public interface IEntityManagerFactory {

	/**
	 * Called when entity manager factory will help to create DAO objects.
	 * 
	 * @return
	 */
	EntityManager createEntityManager();
}
