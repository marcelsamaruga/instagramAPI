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

import br.com.mycompany.instagramApi.dto.InstagramDataInfoDTO;
import br.com.mycompany.instagramApi.dto.InstragramUserInfoDTO;
import br.com.mycompany.instagramApi.entity.InstagramUser;
import br.com.mycompany.instagramApi.repository.InstagramUserRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstagramUserService extends BaseService<InstagramUser> {

	@Autowired
	InstagramUserRepository repository;

	@Override
	public InstagramUserRepository getRepository() {
		return repository;
	}

	/**
	 * @param instaUserInfo 
	 * @return
	 */
	public InstagramUser convertDTOToEntity(InstragramUserInfoDTO instaUserInfo) {
		
		InstagramDataInfoDTO data = instaUserInfo.getData();
		
		return new InstagramUser(
				data.getUsername() ,
				data.getFull_name() ,
				data.getBio() ,
				Long.valueOf(data.getId()) ,
				data.getProfile_picture()
			);
	}

	/**
	 * @param username
	 * @return
	 */
	public boolean userExists(String username) {
		InstagramUser user = repository.findByUsername( username );
		return user != null ? true : false;
	}

}
