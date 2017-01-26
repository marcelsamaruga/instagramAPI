/**
 * @author marcel.costa
 * @name: CustomerRest.java * 
 * @description: Webservice layer used to access the controllers by REST 
 * */
package br.com.mycompany.instagramApi.rest;

import static br.com.mycompany.instagramApi.util.ConstantsUtil.REST_DOMAIN;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mycompany.instagramApi.exception.BusinessException;
import br.com.mycompany.instagramApi.service.InstagramLogService;

@RestController
@RequestMapping( REST_DOMAIN + "/users/")
public class InstagramUserResource extends BaseResource {
	
	final static Logger logger = Logger.getLogger(InstagramUserResource.class);
	private static final String INSTAGRAM_API_USER_SELF = "https://api.instagram.com/v1/users/self/?access_token=";
	
	/*************************/
	//@Autowired
	//TwitterLogService twitterLogService;
	
	@Autowired
	InstagramLogService instagramUserService;
	
	/*************************/
	
	/**
	 * @author marcel.costa
	 * @param queryValue: value to search on the instagram
	 * @param username: instagram account
	 * @return json
	 * description: function is responsible to query on the twitter and save the information 
	 * @throws BusinessException 
	 * */	
	@RequestMapping(value = "self", method=RequestMethod.GET)
	public @ResponseBody Response getSelfInformation() throws BusinessException 
	{
		String output = super.getUrlContent(INSTAGRAM_API_USER_SELF + super.getAccessToken(), APPLICATION_JSON);
		return super.responseSuccessASJson(output);
	}
	
	@RequestMapping(value = "/get", method=RequestMethod.GET) 
	public @ResponseBody Response get() {
		return super.responseSuccessASJson(null);
	}
	
		
}
