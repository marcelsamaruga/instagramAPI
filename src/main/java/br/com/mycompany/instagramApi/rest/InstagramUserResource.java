/**
 * @author marcel.costa
 * @name: CustomerRest.java * 
 * @description: Webservice layer used to access the controllers by REST 
 * */
package br.com.mycompany.instagramApi.rest;

import static br.com.mycompany.instagramApi.util.ConstantsUtil.REST_DOMAIN;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.mycompany.instagramApi.dto.InstragramInfoDTO;
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
	
	@Autowired
	private Gson gson;
	
	/*************************/
	
	/**
	 * @author marcel.costa
	 * @param queryValue: value to search on the instagram
	 * @param username: instagram account
	 * @return json
	 * description: function is responsible to query on the twitter and save the information
	 * @throws ParseException 
	 * */	
	@RequestMapping(value = "self", method=RequestMethod.GET)
	public @ResponseBody String getSelfInformation() throws BusinessException	{
		String output = super.getUrlAsJsonContentType( INSTAGRAM_API_USER_SELF + super.getAccessToken() );
		InstragramInfoDTO instaInfo = gson.fromJson(output, InstragramInfoDTO.class);
		return gson.toJson( instaInfo.getData() );
		//return super.responseSuccessASJson(output);
	}
	
	@RequestMapping(value = "/get", method=RequestMethod.GET) 
	public @ResponseBody Response get() {
		return super.responseSuccessASJson(null);
	}
	
		
}
