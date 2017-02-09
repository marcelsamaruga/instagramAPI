/**
 * @author marcel.costa
 * @name: CustomerRepository.java * 
 * @description: Methods to access the database using JPA Spring Data 
 * */
package br.com.mycompany.instagramApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mycompany.instagramApi.entity.InstagramLocation;

/**
 * @author Marcel
 *
 */
public interface InstagramLocationRepository extends JpaRepository<InstagramLocation, Long> {
	
	public InstagramLocation findByIdLocation(Long idLocation);
	
}
