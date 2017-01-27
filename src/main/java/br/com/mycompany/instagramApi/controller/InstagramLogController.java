/**
 * @author marcel.costa
 * @name: CustomerController.java
 * @description: Controller layer to access the services 
 * */
package br.com.mycompany.instagramApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mycompany.instagramApi.entity.InstagramUser;
import br.com.mycompany.instagramApi.service.InstagramLogService;

@Controller
@RequestMapping("/twitterLog")
public class InstagramLogController extends BaseController<InstagramUser, InstagramLogService> {
	
	@Autowired
	InstagramLogService service;
	
	InstagramUser entity;

	@Override
	public InstagramLogService getService() {
		return service;
	}
	
	@Override
	public void setService(InstagramLogService twitterLogService) {
		this.service = twitterLogService;
	}

	@Override
	public InstagramUser getEntity() {
		return entity;
	}
	
	@Override
	public void setEntity(InstagramUser entity) {
		this.entity = entity;
	}
}