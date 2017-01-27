package br.com.mycompany.instagramApi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="instagram_user")
public class InstagramUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3985428490705878499L;

	@Column(name="username")
	private String username;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="bio")
	private String bio;
	
	@Column(name="instragram_id")
	private Long instragramId;
	
	@Column(name="profile_picture")
	private String profilePicture;

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
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

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
	 * @return the instragramId
	 */
	public Long getInstragramId() {
		return instragramId;
	}

	/**
	 * @param instragramId the instragramId to set
	 */
	public void setInstragramId(Long instragramId) {
		this.instragramId = instragramId;
	}

	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
}
