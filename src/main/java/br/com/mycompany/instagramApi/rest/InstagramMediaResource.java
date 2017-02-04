/**
 * @author marcel.costa
 * @name: CustomerRest.java * 
 * @description: Webservice layer used to access the controllers by REST 
 * */
package br.com.mycompany.instagramApi.rest;

import static br.com.mycompany.instagramApi.util.ConstantsUtil.REST_DOMAIN;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.mycompany.instagramApi.dto.InstragramMediaInfoDTO;
import br.com.mycompany.instagramApi.service.InstagramMediaService;

@RestController
@RequestMapping( REST_DOMAIN + "/media/")
public class InstagramMediaResource extends InstagramBaseResource {
	
	final static Logger logger = Logger.getLogger(InstagramMediaResource.class);
	
	/*************************/
	//@Autowired
	//TwitterLogService twitterLogService;
	
	@Autowired
	InstagramMediaService instagramMediaService;
	
	@Autowired
	private Gson gson;
	
	/*************************/
	
	/**
	 * @author marcel.costa
	 * @param queryValue: value to search on the instagram
	 * @param username: instagram account
	 * @return json
	 * description: function to get media information of the user
	 * @throws ParseException 
	 * */	
	@RequestMapping(value = "getMedia/{id}", method=RequestMethod.GET )
	public @ResponseBody String getMedia(@PathVariable String id) {
		String URL 	  = getMediaByUserId(id);
		String output = super.getUrlAsJsonContentType( URL );
		
		InstragramMediaInfoDTO instaInfo = gson.fromJson(output, InstragramMediaInfoDTO.class );		
		return gson.toJson( instaInfo.getData() );
	}
	
		
}
