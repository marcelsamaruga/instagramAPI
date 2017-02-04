package br.com.mycompany.instagramApi.rest;

import org.springframework.beans.factory.annotation.Value;

public abstract class InstagramBaseResource extends BaseResource {
	
	@Value(value = "${access_token}")
	private String accessToken;

	/**
	 * @author Marcel
	 * This function returns the access token from the Instagram API
	 * @return String
	 */
	protected String getAccessToken() {
		return this.accessToken;
	}
	
	/**
	 * @author Marcel
	 * This function returns the base URL from instagram API
	 * @return String
	 */
	private String getBaseInstagramURL() {
		return "https://api.instagram.com/v1/";
	}
	
	/**
	 * @author Marcel
	 * This function returns the URL to get access from the token user
	 * @return String
	 */
	protected String getSelfUser() {
		return getBaseInstagramURL() + "users/self/?access_token=" + getAccessToken();
	}
	
	/**
	 * @author Marcel
	 * This function returns the URL to get information of the user by ID
	 * @param id: id from Instagram 
	 * @return String
	 */
	protected String getUserById(String id) {
		return getBaseInstagramURL() + "users/" + id + "/?access_token=" + getAccessToken();
	}
	
	/**
	 * @author Marcel
	 * This function returns the URL to get information of the media user by ID
	 * @param id: id from Instagram 
	 * @return String
	 */
	protected String getMediaByUserId(String id) {
		return getBaseInstagramURL() + "users/" + id + "/media/recent/?access_token=" + getAccessToken();
	}
	
}