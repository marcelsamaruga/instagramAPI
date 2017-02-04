/**
 * 
 */
package br.com.mycompany.instagramApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mycompany.instagramApi.entity.InstagramMedia;
import br.com.mycompany.instagramApi.repository.InstagramMediaRepository;

/**
 * @author Marcel
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstagramMediaService extends BaseService<InstagramMedia> {

	@Autowired
	InstagramMediaRepository repository;

	@Override
	public InstagramMediaRepository getRepository() {
		return repository;
	}
	
}
