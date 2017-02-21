package br.com.mycompany.instagramApi.resource;

import java.rmi.RemoteException;
import java.text.ParseException;

import javax.inject.Inject;

import org.hibernate.service.spi.ServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;

import br.com.mycompany.instagramApi.repository.InstagramUserRepository;
import br.com.mycompany.instagramApi.rest.InstagramUserResource;
import br.com.mycompany.instagramApi.service.InstagramUserService;

@RunWith(MockitoJUnitRunner.class)  
public class InstagramLocationResourceTests {

	@Spy
    private InstagramUserService service;
	
	@Mock
	InstagramUserRepository repository;
	
	//@InjectMocks
	//private InstagramUserRepository repository;
	
	//@InjectMocks
	//private InstagramUserResource resource;
	
	@Inject
    private ApplicationContext ctx;
	
	@Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

	@Before
	public void setUp(){
		//service = ctx.getBean(InstagramUserService.class);
	}
	
	@Test
	public void contextLoads() {
	}
	
//	@Test
//    public void testSayHelloWorld() throws Exception{
//
//         this.mockMvc.perform(get("/")
//                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType("application/json"));
//    }
//

	// *** *** *** *** *** *** *** *** *** *** 
	
	@Test
	public void get_instagram_user_by_username() throws RemoteException, ServiceException {
		setup();
		
		//String response = resource.getUserByUsername("marcelsamaruga");
		
		//response.ok().build().readEntity(Employee.class);
		//assertEquals( response.getStatus(), Status.OK.getStatusCode() );
		//System.out.println(response);
	}
	
	
	@Test
	public void shipping_find_by_date_resource() throws RemoteException, ServiceException, ParseException {
		setup();
		
		//Response response = resource.getAll();
		//
		//assertEquals( Status.fromStatusCode(response.getStatus()) , Status.OK );
	}
	
	private void setup() {
		//service.setRepository(repository);
		//resource.setService(service);
	}

}
