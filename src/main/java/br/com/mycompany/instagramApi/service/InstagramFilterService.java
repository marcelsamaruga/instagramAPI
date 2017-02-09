/**
 * @author marcel.costa
 * @name: CustomerService.java * 
 * @description: Webservice layer used to access the controllers by REST 
 * 
 * Service: marks the class as a Spring service prototype
 * Transactional: forces all the class methods as transactional
 * */
package br.com.mycompany.instagramApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mycompany.instagramApi.entity.InstagramFilter;
import br.com.mycompany.instagramApi.repository.InstagramFilterRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstagramFilterService extends BaseService<InstagramFilter> {

	@Autowired
	InstagramFilterRepository repository;

	@Override
	public InstagramFilterRepository getRepository() {
		return repository;
	}

	/**
	 * @param filter
	 * @return
	 */
	public InstagramFilter findByName(String name) {
		return repository.findByName(name);
	}

}
