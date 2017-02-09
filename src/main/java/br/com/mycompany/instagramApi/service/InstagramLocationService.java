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

import br.com.mycompany.instagramApi.dto.InstagramLocationInfoDTO;
import br.com.mycompany.instagramApi.entity.InstagramLocation;
import br.com.mycompany.instagramApi.repository.InstagramLocationRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstagramLocationService extends BaseService<InstagramLocation> {

	@Autowired
	InstagramLocationRepository repository;

	@Override
	public InstagramLocationRepository getRepository() {
		return repository;
	}

	/**
	 * @param instaUserInfo 
	 * @return
	 */
	public InstagramLocation convertDTOToEntity(InstagramLocationInfoDTO instaLocationInfo) {		
		return new InstagramLocation(
				instaLocationInfo.getId() ,
				instaLocationInfo.getName() ,
				instaLocationInfo.getLongitude(),
				instaLocationInfo.getLatitude() 
			);
	}
	
	/**
	 * @param instaUserInfo 
	 * @return
	 */
	public InstagramLocation findByInstragramId(Long instagramId) {
		return repository.findByIdLocation(instagramId);
	}

}
