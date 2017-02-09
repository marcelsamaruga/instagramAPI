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

import br.com.mycompany.instagramApi.dto.InstagramDataInfoDTO;
import br.com.mycompany.instagramApi.dto.InstagramMediaInfoDTO;
import br.com.mycompany.instagramApi.entity.InstagramMedia;
import br.com.mycompany.instagramApi.entity.InstagramMediaStatistic;
import br.com.mycompany.instagramApi.enums.InstagramStatisticTypeEnum;
import br.com.mycompany.instagramApi.exception.ErrorConnectionException;
import br.com.mycompany.instagramApi.service.InstagramFilterService;
import br.com.mycompany.instagramApi.service.InstagramMediaService;
import br.com.mycompany.instagramApi.service.InstagramMediaStatisticService;
import br.com.mycompany.instagramApi.service.InstagramStatisticTypeService;
import br.com.mycompany.instagramApi.service.InstagramUserService;

@RestController
@RequestMapping( REST_DOMAIN + "/media/")
public class InstagramMediaResource extends InstagramBaseResource {
	
	final static Logger logger = Logger.getLogger(InstagramMediaResource.class);
	
	/*************************/
	@Autowired
	InstagramMediaService instagramMediaService;
	
	@Autowired
	InstagramMediaStatisticService instagramMediaStatisticService;
	
	@Autowired
	InstagramUserService instagramUserService;
	
	@Autowired
	InstagramStatisticTypeService instagramStatisticTypeService; 
	
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
		String URL = getMediaByUserId(id);		
		InstagramMediaInfoDTO instaMediaInfo;
		
		try {
			String output = super.getUrlAsJsonContentType( URL );
			instaMediaInfo = gson.fromJson(output, InstagramMediaInfoDTO.class );
		
			if ( instaMediaInfo == null || instaMediaInfo.getData() == null || instaMediaInfo.getData().isEmpty() ) {
				logger.error( super.getNotFoundRequest() );
				return super.getNotFoundRequest();
			}
			
			// for each media user
			for ( InstagramDataInfoDTO userMediaDTO : instaMediaInfo.getData() ) {
				InstagramMedia instagramMediaEntity = instagramMediaService.findByIdPost( userMediaDTO.getId() );
				
				if ( instagramMediaEntity == null ) {					
					// convert DTO into Database Entity
					instagramMediaEntity = instagramMediaService.convertDTOToEntity( userMediaDTO );
					
					// save in the database
					instagramMediaService.save( instagramMediaEntity );
					
					// save media statistics
					// likes:
					saveMediaStatistic(
							InstagramStatisticTypeEnum.STATISTIC_LIKES, 
							userMediaDTO.getLikes().getCount(), 
							instagramMediaEntity
					);
					
					// comments:
					saveMediaStatistic(
							InstagramStatisticTypeEnum.STATISTIC_COMMENTS, 
							userMediaDTO.getComments().getCount(), 
							instagramMediaEntity
					);
					
					// *** *** ***					
				}
				
				// *** *** ***
				
				// populates json return
				userMediaDTO.setUser( instagramUserService.convertEntityToDTO(instagramMediaEntity.getUser()) );
			}
			
		// connection error exception
		} catch (ErrorConnectionException connectionError) {
			logger.error( connectionError.getMessage() );
			return connectionError.getMessage();
		// runtime
		} catch (RuntimeException runtimeException) {
			logger.error( super.getDefaultErrorMessage() + ". " + runtimeException.getMessage() );
			return super.getDefaultErrorMessage() + ". " + runtimeException.getMessage() ;
		}
		
		return gson.toJson( instaMediaInfo.getData() );
	}
	
	
	private void saveMediaStatistic(InstagramStatisticTypeEnum statisticTypeEnum, Long value, InstagramMedia media) {
		if (value == null || value.longValue() == 0) {
			return;
		}
		
		InstagramMediaStatistic statisticMedia = new InstagramMediaStatistic();
		statisticMedia.setValue( value );
		statisticMedia.setMedia( media );
		statisticMedia.setStatisticType( 
			instagramStatisticTypeService.findById( statisticTypeEnum.getId() ) 
		);
		
		instagramMediaStatisticService.save( statisticMedia );
	}
	
		
}
