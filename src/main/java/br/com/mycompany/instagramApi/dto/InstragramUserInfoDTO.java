/**
 * 
 */
package br.com.mycompany.instagramApi.dto;

/**
 * @author Marcel
 *
 */
public class InstragramUserInfoDTO {
	
	private InstagramMetaInfoDTO meta;
	private InstagramDataInfoDTO data;
	private String pagination;
	private String profile_picture;
	private Long id;
	private String username;
	private String full_name;
	/**
	 * @return the meta
	 */
	public InstagramMetaInfoDTO getMeta() {
		return meta;
	}
	/**
	 * @param meta the meta to set
	 */
	public void setMeta(InstagramMetaInfoDTO meta) {
		this.meta = meta;
	}
	/**
	 * @return the data
	 */
	public InstagramDataInfoDTO getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(InstagramDataInfoDTO data) {
		this.data = data;
	}
	/**
	 * @return the pagination
	 */
	public String getPagination() {
		return pagination;
	}
	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(String pagination) {
		this.pagination = pagination;
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
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	
}
