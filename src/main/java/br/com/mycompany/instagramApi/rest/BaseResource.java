package br.com.mycompany.instagramApi.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author marcel.costa
 * Resource super class
 * */
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.mycompany.instagramApi.enums.ContentTypeEnum;

public abstract class BaseResource {
	
	

	@Autowired
	private Gson gson;
	
	@Value(value = "${message.not.found}")
	protected String messageNotFound;
	
	@Value(value = "${default.error.message}")
	protected String defaultErrorMessage;
	
	protected static final Integer EMPTY_REQUEST = 500;
	protected static final Integer ERROR_REQUEST = 404;

	/**
	 * @author marcel.costa
	 * This function returns a OK response status and creates an JSON element according to the entity attributes
	 * */
	protected Response responseSuccess( final Object entity ) {
		return responseStatus( Status.OK, entity ).build();
	}
	
	/**
	 * @author marcel.costa
	 * This function returns a OK response status and creates an JSON element according to the entity attributes
	 * */
	protected Response responseSuccess() {
		return Response.ok().build();
	}
	
	
	/**
	 * @author marcel.costa
	 * This function returns a error response and creates an error message in a JSONObject
	 * */
	protected Response responseError( final String message ) {
		
		Map<String, String> errorJSONObject = new HashMap<String, String>();

		// create a JSONObject element using the code/message of the error
		errorJSONObject.put("code",    String.valueOf(Status.INTERNAL_SERVER_ERROR.getStatusCode()) );
		errorJSONObject.put("message", message );

		return responseStatus( Status.INTERNAL_SERVER_ERROR, errorJSONObject ).build();
	}

	
	/**
	 * @author marcel.costa
	 * This function returns a response statement according to the status object sent by parameter
	 * */
	protected ResponseBuilder responseStatus( final Status status, final Object entity ) {
		return responseStatus( status ).entity( entity ).tag("API");
	}
	
	
	/**
	 * @author marcel.costa
	 * This function returns a response statement according to the status object sent by parameter
	 * */
	protected ResponseBuilder responseStatus( final Status status ) {
		return Response.status( status ).tag( status.getReasonPhrase() );
	}
	
	
	/**
	 * @author marcel.costa
	 * This function returns a JSON object sent by parameter
	 * */
	protected Response responseSuccessASJson(final Object entity) {
		try {			
			// create GSon converter
			return responseSuccess( gson.toJson(entity) );
	    	
		} catch (Exception e) {
			return responseError( e.getMessage() );
		}		
	}
	
	/**
	 * @author marcel.costa
	 * This function invokes a URL and returns its body 
	 * return String
	 * */
	protected String getUrlContent(String URL, String contentType) {
		Client client = Client.create();
		
		WebResource webResource = client.resource( URL );
		
		ClientResponse response = webResource.accept( contentType ).get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		return response.getEntity(String.class);
	}
	
	
	/**
	 * @author marcel.costa
	 * This function invokes a URL as a json content type and returns its body  
	 * return String
	 * */
	protected String getUrlAsJsonContentType(String URL) {
		Client client = Client.create();
		
		WebResource webResource = client.resource( URL );
		
		ClientResponse response = webResource.accept( ContentTypeEnum.JSON_CONTENT_TYPE.getName() ).get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		return response.getEntity(String.class);
	}
	
	/**
	 * @author marcel.costa
	 * This function invokes a URL as a json content type and returns its body  
	 * return String
	 * */
	protected String getUrl(String URL, ContentTypeEnum contentTypeEnum) {
		Client client = Client.create();
		
		WebResource webResource = client.resource( URL );
		
		ClientResponse response = webResource.accept( contentTypeEnum.getName() ).get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		return response.getEntity(String.class);
	}
	
	
	/**
	 * @author marcel.costa
	 * This function returns a JSON object sent by parameter
	 * */
	protected Response responseASJson(Status status,  final Object entity) {
		try {			
			// create GSon converter
			Gson gson = new GsonBuilder().create();
	    	return responseStatus( status, gson.toJson(entity) ).build();
	    	
		} catch (Exception e) {
			return responseError( e.getMessage() );
		}		
	}
	
	/**
	 * @author marcel.costa
	 * This function returns a json string when not found request API occurs
	 * @return
	 */
	protected String getNotFoundRequest() {
		String output = "{"
				+ "			\"code\":"    + EMPTY_REQUEST
				+ "			\"message\":" + messageNotFound
				+ "		 }";
		
		return output;
	}

	/**
	 * @author marcel.costa
	 * This function returns a json string when a RuntimeException occur
	 * @return
	 */
	public String getDefaultErrorMessage() {
		String output = "{"
				+ "			\"code\":"    + ERROR_REQUEST
				+ "			\"message\":" + defaultErrorMessage
				+ "		 }";
		
		return output;
	}
	
}