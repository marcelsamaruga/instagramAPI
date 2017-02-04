/**
 * 
 */
package br.com.mycompany.instagramApi.dto;

/**
 * @author Marcel
 *
 */
public class InstagramCaptionInfoDTO {

	private String created_time;
	private String text;
	private String id;
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
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
	
}
