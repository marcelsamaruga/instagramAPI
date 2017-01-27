/**
 * 
 */
package br.com.mycompany.instagramApi.dto;

import java.util.List;

/**
 * @author Marcel
 *
 */
public class InstagramDataInfoDTO {

	private String bio;
	private String website;
	private String full_name;
	private String id;
	private String username;
	private String profile_picture;
	private String attribution;
	private List<String> tags;
	private String type;
	private InstagramLocationInfoDTO location;
	private InstragramCommentsInfoDTO comments;
	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}
	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}
	/**
	 * @param full_name the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the profile_picture
	 */
	public String getProfile_picture() {
		return profile_picture;
	}
	/**
	 * @param profile_picture the profile_picture to set
	 */
	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}
	/**
	 * @return the attribution
	 */
	public String getAttribution() {
		return attribution;
	}
	/**
	 * @param attribution the attribution to set
	 */
	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the location
	 */
	public InstagramLocationInfoDTO getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(InstagramLocationInfoDTO location) {
		this.location = location;
	}
	/**
	 * @return the comments
	 */
	public InstragramCommentsInfoDTO getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(InstragramCommentsInfoDTO comments) {
		this.comments = comments;
	}
		
	
}
