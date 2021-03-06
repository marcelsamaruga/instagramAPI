/**
 * @author marcel.costa
 * @name: Application.java
 * @description: Class to configure all the CDI using Spring and the initial configuration
 * 
 * SpringBootAplication: starts the Spring Framework
 * ComponentScan: indicates the dependency management of the Spring Framework
 * EnableAutoConfiguration: Enable auto-configuration of the Spring Application Context
 * EnableWebMvc: imports the Spring MVC configuration
 * */
package br.com.mycompany.instagramApi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SpringBootApplication
@ComponentScan( basePackages = {"br.com.mycompany.instagramApi"} )
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
	    return tomcat;
	}
	
	@Bean
	public Gson gsonBuilder() { 
		return new GsonBuilder()
	             .disableHtmlEscaping()
	             .setPrettyPrinting()
	             .serializeNulls()
	             .create();
	}
}