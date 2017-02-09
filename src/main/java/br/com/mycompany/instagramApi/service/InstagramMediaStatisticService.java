/**
 * 
 */
package br.com.mycompany.instagramApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mycompany.instagramApi.entity.InstagramMediaStatistic;
import br.com.mycompany.instagramApi.repository.InstagramMediaStatisticRepository;

/**
 * @author Marcel
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstagramMediaStatisticService extends BaseService<InstagramMediaStatistic> {

	@Autowired
	InstagramMediaStatisticRepository repository;
	
	@Override
	public InstagramMediaStatisticRepository getRepository() {
		return repository;
	}
	
}
