/**
 * 
 */
package br.com.mycompany.instagramApi.dto;

/**
 * @author Marcel
 *
 */
public class InstagramCountInfoDTO {

	private Long media;
	private Long followed_by;
	private Long follows;
	/**
	 * @return the media
	 */
	public Long getMedia() {
		return media;
	}
	/**
	 * @param media the media to set
	 */
	public void setMedia(Long media) {
		this.media = media;
	}
	/**
	 * @return the followed_by
	 */
	public Long getFollowed_by() {
		return followed_by;
	}
	/**
	 * @param followed_by the followed_by to set
	 */
	public void setFollowed_by(Long followed_by) {
		this.followed_by = followed_by;
	}
	/**
	 * @return the follows
	 */
	public Long getFollows() {
		return follows;
	}
	/**
	 * @param follows the follows to set
	 */
	public void setFollows(Long follows) {
		this.follows = follows;
	}
	
}
