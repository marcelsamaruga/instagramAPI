/**
 * @author marcel.costa
 * @name: CustomerController.java
 * @description: Controller layer to access the services 
 * */
package br.com.mycompany.instagramApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mycompany.instagramApi.entity.InstagramLog;
import br.com.mycompany.instagramApi.service.InstagramLogService;

@Controller
@RequestMapping("/twitterLog")
public class InstagramLogController extends BaseController<InstagramLog, InstagramLogService> {
	
	@Autowired
	InstagramLogService service;
	
	InstagramLog entity;

	@Override
	public InstagramLogService getService() {
		return service;
	}
	
	@Override
	public void setService(InstagramLogService twitterLogService) {
		this.service = twitterLogService;
	}

	@Override
	public InstagramLog getEntity() {
		return entity;
	}
	
	@Override
	public void setEntity(InstagramLog entity) {
		this.entity = entity;
	}
}