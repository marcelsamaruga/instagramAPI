/**
 * @author marcel.costa
 * @name: CustomerRepository.java * 
 * @description: Methods to access the database using JPA Spring Data 
 * */
package br.com.mycompany.instagramApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mycompany.instagramApi.entity.InstagramMediaStatistic;

/**
 * @author Marcel
 *
 */
public interface InstagramMediaStatisticRepository extends JpaRepository<InstagramMediaStatistic, Long> {


}
