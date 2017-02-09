/**
 * @author marcel.costa
 * @name: CustomerRest.java * 
 * @description: Webservice layer used to access the controllers by REST 
 * */
package br.com.mycompany.instagramApi.rest;

import static br.com.mycompany.instagramApi.util.ConstantsUtil.REST_DOMAIN;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.mycompany.instagramApi.dto.InstagramUserInfoDTO;
import br.com.mycompany.instagramApi.entity.InstagramUser;
import br.com.mycompany.instagramApi.exception.BusinessException;
import br.com.mycompany.instagramApi.exception.ErrorConnectionException;
import br.com.mycompany.instagramApi.service.InstagramUserService;

@RestController
@RequestMapping( REST_DOMAIN + "/users/")
public class InstagramUserResource extends InstagramBaseResource {
	
	final static Logger logger = Logger.getLogger(InstagramUserResource.class);
	
	/*************************/
	@Autowired
	private InstagramUserService instagramUserService;
	
	@Autowired
	private Gson gson;
	
	/*************************/
	
	/**
	 * @author marcel.costa
	 * @return json
	 * description: function is responsible to retrieve information about the user of the token
	 * */	
	@RequestMapping(value = "saveSelfUser", method=RequestMethod.GET)
	public @ResponseBody String getSelfInformation() throws BusinessException {
		String URL 	  = getSelfInformation();
		String output = saveUserInDb(URL);			
		return output;
	}
	
	/**
	 * @author marcel.costa
	 * @param id: instagram user id account
	 * @return json
	 * description: function is responsible to retrieve information about the user id (parameter)
	 * */
	@RequestMapping(value = "saveUser/{id}", method=RequestMethod.GET )
	public @ResponseBody String saveUser(@PathVariable String id) {
		String URL 	  = getUserById(id);
		String output = saveUserInDb(URL);			
		return output;
	}
	
	/**
	 * @author marcel.costa
	 * @param output: json string containing user data info
	 * @return InstragramUserInfoDTO
	 * description: function is responsible to save user instagram on the database
	 * */
	private String saveUserInDb(String URL) {		
		InstagramUserInfoDTO instaUserInfo;
		
		try {
			String output = super.getUrlAsJsonContentType( URL );
			instaUserInfo = gson.fromJson(output, InstagramUserInfoDTO.class );
		
			if ( instaUserInfo == null || instaUserInfo.getData() == null ) {
				logger.error( super.getNotFoundRequest() );
				return super.getNotFoundRequest();
			}
		//
		} catch (ErrorConnectionException connectionError) {
			logger.error( connectionError.getMessage() );
			return connectionError.getMessage();
		// runtime
		} catch (RuntimeException runtimeException) {
			logger.error( super.getDefaultErrorMessage() + ". " + runtimeException.getMessage() );
			return super.getDefaultErrorMessage() + ". " + runtimeException.getMessage();
		}
		
		if ( instagramUserService.findByUsername(instaUserInfo.getData().getUsername()) == null ) {
			InstagramUser user = instagramUserService.convertDTOToEntity( instaUserInfo );
			instagramUserService.save( user );
		}
		
		return gson.toJson( instaUserInfo.getData() );
	}
	
	
	/**
	 * @author marcel.costa
	 * @param username: instagram username account
	 * @return json
	 * description: function is responsible to retrieve information about the user id (parameter)
	 * */
	@RequestMapping(value = "getUser/{username}", method=RequestMethod.GET )
	public @ResponseBody String getUserByUsername(@PathVariable String username) {
		//
		if ( StringUtils.isEmpty(username) ) {
			logger.error( super.getInvalidParamsRequest() );
			return super.getInvalidParamsRequest();
		}
		
		InstagramUser user = instagramUserService.findByUsername(username);
		
		if (user == null) {
			logger.error( super.getNotFoundRequest() );
			return super.getNotFoundRequest();
		}
		
		InstagramUserInfoDTO userDTO = instagramUserService.convertEntityToDTO( user );

		// return JSON
		return gson.toJson( userDTO );
	}
	
		
}
