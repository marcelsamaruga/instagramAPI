/**
 * @author marcel.costa
 * @name: CustomerRest.java * 
 * @description: Webservice layer used to access the controllers by REST 
 * */
package br.com.mycompany.instagramApi.rest;

import static br.com.mycompany.instagramApi.util.ConstantsUtil.REST_DOMAIN;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.mycompany.instagramApi.dto.InstragramUserInfoDTO;
import br.com.mycompany.instagramApi.entity.InstagramUser;
import br.com.mycompany.instagramApi.exception.BusinessException;
import br.com.mycompany.instagramApi.exception.ResourceNotFoundException;
import br.com.mycompany.instagramApi.service.InstagramUserService;

@RestController
@RequestMapping( REST_DOMAIN + "/users/")
public class InstagramUserResource extends InstagramBaseResource {
	
	final static Logger logger = Logger.getLogger(InstagramUserResource.class);
	
	/*************************/
	@Autowired
	InstagramUserService instagramUserService;
	
	@Autowired
	private Gson gson;
	
	/*************************/
	
	/**
	 * @author marcel.costa
	 * @return json
	 * description: function is responsible to retrieve information about the user of the token
	 * */	
	@RequestMapping(value = "self", method=RequestMethod.GET)
	public @ResponseBody String getSelfInformation() throws BusinessException {
		String output = super.getUrlAsJsonContentType( getSelfUser() );
		
		InstragramUserInfoDTO instaUserInfo;
		
		try {
			
			instaUserInfo = saveUser(output);
			
		} catch (ResourceNotFoundException resourceNotFoundException) {
			logger.error( resourceNotFoundException.getMessage() );
			return super.getNotFoundRequest();
		} catch (RuntimeException runtimeException) {
			logger.error( runtimeException.getMessage() );
			return super.getDefaultErrorMessage();
		}
		
		return gson.toJson( instaUserInfo.getData() );
	}
	
	/**
	 * @author marcel.costa
	 * @param id: instagram user id account
	 * @return json
	 * description: function is responsible to retrieve information about the user id (parameter)
	 * */
	@RequestMapping(value = "getUser/{id}", method=RequestMethod.GET )
	public @ResponseBody String getUser(@PathVariable String id) {
		String URL 	  = getUserById(id);
		String output = super.getUrlAsJsonContentType( URL );
		
		InstragramUserInfoDTO instaUserInfo;
		
		try {
			
			instaUserInfo = saveUser(output);
			
		} catch (ResourceNotFoundException resourceNotFoundException) {
			logger.error( resourceNotFoundException.getMessage() );
			return super.getNotFoundRequest();
		} catch (RuntimeException runtimeException) {
			logger.error( runtimeException.getMessage() );
			return super.getDefaultErrorMessage();
		}
		
		return gson.toJson( instaUserInfo.getData() );
	}
	
	/**
	 * @author marcel.costa
	 * @param output: json string containing user data info
	 * @return InstragramUserInfoDTO
	 * description: function is responsible to save user instagram on the database
	 * */
	private InstragramUserInfoDTO saveUser(String output) {
		
		InstragramUserInfoDTO instaUserInfo = gson.fromJson(output, InstragramUserInfoDTO.class );
		
		if ( instaUserInfo == null || instaUserInfo.getData() == null ) {
			throw new ResourceNotFoundException();
		}
		
		if ( !instagramUserService.userExists(instaUserInfo.getData().getUsername()) ) {
			InstagramUser user = instagramUserService.convertDTOToEntity( instaUserInfo );
			instagramUserService.save( user );
		}
		
		return instaUserInfo;
	}
	
		
}
