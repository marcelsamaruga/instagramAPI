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

import br.com.mycompany.instagramApi.entity.InstagramStatisticType;
import br.com.mycompany.instagramApi.repository.InstagramStatisticTypeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstagramStatisticTypeService extends BaseService<InstagramStatisticType> {

	@Autowired
	InstagramStatisticTypeRepository repository;

	@Override
	public InstagramStatisticTypeRepository getRepository() {
		return repository;
	}

}
