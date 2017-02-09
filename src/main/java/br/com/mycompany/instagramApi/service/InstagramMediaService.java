/**
 * 
 */
package br.com.mycompany.instagramApi.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mycompany.instagramApi.dto.InstagramDataInfoDTO;
import br.com.mycompany.instagramApi.entity.InstagramFilter;
import br.com.mycompany.instagramApi.entity.InstagramLocation;
import br.com.mycompany.instagramApi.entity.InstagramMedia;
import br.com.mycompany.instagramApi.entity.InstagramUser;
import br.com.mycompany.instagramApi.repository.InstagramMediaRepository;
import jersey.repackaged.com.google.common.collect.Lists;


/**
 * @author Marcel
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstagramMediaService extends BaseService<InstagramMedia> {

	@Autowired
	InstagramMediaRepository repository;
	
	@Autowired
	InstagramLocationService locationService;
	
	@Autowired
	InstagramUserService userService;
	
	@Autowired
	InstagramFilterService instagramFilterService;
	

	@Override
	public InstagramMediaRepository getRepository() {
		return repository;
	}

	/**
	 * @param userMediaDTO
	 * @return
	 */
	public InstagramMedia convertDTOToEntity(InstagramDataInfoDTO userMediaDTO) {
		InstagramMedia instagramMedia = new InstagramMedia();
		
		instagramMedia.setIdPost( userMediaDTO.getId() );
		instagramMedia.setLink( userMediaDTO.getLink() );
		instagramMedia.setWidth( userMediaDTO.getImages().getStandard_resolution().getWidth() );
		instagramMedia.setHeight( userMediaDTO.getImages().getStandard_resolution().getHeight() );
		instagramMedia.setUrl( userMediaDTO.getImages().getStandard_resolution().getUrl() );
		
		InstagramUser user = userService.findByUsername( userMediaDTO.getUser().getUsername() );
		instagramMedia.setUser( user );
		
		if ( userMediaDTO.getCaption() != null && StringUtils.isNotBlank(userMediaDTO.getCaption().getText()) ) {
			instagramMedia.setCaption( userMediaDTO.getCaption().getText() );
		}
		
		if (userMediaDTO.getCreated_time() != null) {
			instagramMedia.setCreateTime( Long.valueOf(userMediaDTO.getCreated_time()) );
		}
		
		// geolocation
		if ( userMediaDTO.getLocation() != null ) {
			
			InstagramLocation locationEntity = locationService.findByInstragramId( userMediaDTO.getLocation().getId() );
			
			if (locationEntity == null) {
				locationEntity = locationService.convertDTOToEntity( userMediaDTO.getLocation() );
				locationService.save( locationEntity );
			}
			
			instagramMedia.setLocation( locationEntity );
		}
		
		// get hashtags
		StringBuilder sb = new StringBuilder();
		
		for (String tag : userMediaDTO.getTags()) {
			sb.append(tag + ", ");
		}
		
		instagramMedia.setTags( StringUtils.left(sb.toString(), sb.toString().length()-2) );
		
		// saves filter
		if ( StringUtils.isNotBlank(userMediaDTO.getFilter()) ) {
			
			InstagramFilter filter = instagramFilterService.findByName( userMediaDTO.getFilter() );
			
			if (filter == null) {
				filter = new InstagramFilter( userMediaDTO.getFilter() );
				instagramFilterService.save(filter);
			}
			
			instagramMedia.setListFilter(Lists.newArrayList(filter));						
		}

		return instagramMedia;
	}

	/**
	 * @param string
	 * @return
	 */
	public InstagramMedia findByIdPost(String idPost) {
		return repository.findByIdPost(idPost);
	}
	
}
