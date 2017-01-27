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

public abstract class BaseResource {
	
	protected final String APPLICATION_JSON = "application/json";
	
	@Value(value = "${access_token}")
	private String accessToken;
	
	@Autowired
	private Gson gson;

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
		
		ClientResponse response = webResource.accept( APPLICATION_JSON ).get(ClientResponse.class);

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
	 * @author Marcel
	 * This function returns the access token from the Instagram API
	 * @return String
	 */
	protected String getAccessToken() {
		return this.accessToken;
	}
	
}