/**
 * @author marcel.costa
 * @name: CustomerRepository.java * 
 * @description: Methods to access the database using JPA Spring Data 
 * */
package br.com.mycompany.instagramApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.mycompany.instagramApi.entity.InstagramMedia;

/**
 * @author Marcel
 *
 */
public interface InstagramMediaRepository extends JpaRepository<InstagramMedia, Long> {

	/**
	 * @param idPost
	 * @return
	 */
	public InstagramMedia findByIdPost(String idPost);

	/**
	 * @param username
	 * @return
	 */
	@Query("SELECT media FROM InstagramMedia media WHERE media.user.username = ?1")
	public List<InstagramMedia> findByUsername(String username);

}
