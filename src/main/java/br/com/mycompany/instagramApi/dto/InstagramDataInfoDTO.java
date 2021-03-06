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
	private InstagramCountsInfoDTO comments;
	private InstagramCountsInfoDTO likes;
	private InstagramCountInfoDTO counts;
	private String created_time;
	private String link;
	private InstagramCaptionInfoDTO caption;
	private String filter;
	private InstagramUserInfoDTO user;
	private InstagramImageInfoDTO images;
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
	public InstagramCountsInfoDTO getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(InstagramCountsInfoDTO comments) {
		this.comments = comments;
	}
	/**
	 * @return the likes
	 */
	public InstagramCountsInfoDTO getLikes() {
		return likes;
	}
	/**
	 * @param likes the likes to set
	 */
	public void setLikes(InstagramCountsInfoDTO likes) {
		this.likes = likes;
	}
	/**
	 * @return the counts
	 */
	public InstagramCountInfoDTO getCounts() {
		return counts;
	}
	/**
	 * @param counts the counts to set
	 */
	public void setCounts(InstagramCountInfoDTO counts) {
		this.counts = counts;
	}
	/**
	 * @return the created_time
	 */
	public String getCreated_time() {
		return created_time;
	}
	/**
	 * @param created_time the created_time to set
	 */
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the caption
	 */
	public InstagramCaptionInfoDTO getCaption() {
		return caption;
	}
	/**
	 * @param caption the caption to set
	 */
	public void setCaption(InstagramCaptionInfoDTO caption) {
		this.caption = caption;
	}
	/**
	 * @return the filter
	 */
	public String getFilter() {
		return filter;
	}
	/**
	 * @param filter the filter to set
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}
	/**
	 * @return the user
	 */
	public InstagramUserInfoDTO getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(InstagramUserInfoDTO user) {
		this.user = user;
	}
	/**
	 * @return the images
	 */
	public InstagramImageInfoDTO getImages() {
		return images;
	}
	/**
	 * @param images the images to set
	 */
	public void setImages(InstagramImageInfoDTO images) {
		this.images = images;
	}
		
}
