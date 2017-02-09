/**
 * @author marcel.costa
 * @name: CustomerRepository.java * 
 * @description: Methods to access the database using JPA Spring Data 
 * */
package br.com.mycompany.instagramApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mycompany.instagramApi.entity.InstagramFilter;

/**
 * @author Marcel
 *
 */
public interface InstagramFilterRepository extends JpaRepository<InstagramFilter, Long> {

	/**
	 * @param name
	 * @return
	 */
	public InstagramFilter findByName(String name);


}
