package br.com.mycompany.twitterApi;

import org.junit.Test;

import br.com.mycompany.instagramApi.service.InstagramLogService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@IntegrationTest("server.port:0")  
public class SpringRestApplicationTests {

//	@MockBean
    private InstagramLogService service;
	
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
//    @Test
//    public void contextLoads() {
//    }
	
	
//	@BeforeClass
//	public static void startBootApp(){
//	appContext = SpringApplication.run(Application.class, "");
//	}
//
//	@AfterClass
//	public static void shutdownBootApp(){
//	appContext.close();
//	}

}
