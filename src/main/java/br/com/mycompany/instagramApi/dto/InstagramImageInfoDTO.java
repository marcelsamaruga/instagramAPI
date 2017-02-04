/**
 * 
 */
package br.com.mycompany.instagramApi.dto;

/**
 * @author Marcel
 *
 */
public class InstagramImageInfoDTO {

	private InstagramImageInfoDTO standard_resolution;
	private InstagramImageInfoDTO thumbnail;	
	private InstagramImageInfoDTO low_resolution;
	private Integer width;
	private Integer height;
	private String url;
	/**
	 * @return the standard_resolution
	 */
	public InstagramImageInfoDTO getStandard_resolution() {
		return standard_resolution;
	}
	/**
	 * @param standard_resolution the standard_resolution to set
	 */
	public void setStandard_resolution(InstagramImageInfoDTO standard_resolution) {
		this.standard_resolution = standard_resolution;
	}
	/**
	 * @return the thumbnail
	 */
	public InstagramImageInfoDTO getThumbnail() {
		return thumbnail;
	}
	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(InstagramImageInfoDTO thumbnail) {
		this.thumbnail = thumbnail;
	}
	/**
	 * @return the low_resolution
	 */
	public InstagramImageInfoDTO getLow_resolution() {
		return low_resolution;
	}
	/**
	 * @param low_resolution the low_resolution to set
	 */
	public void setLow_resolution(InstagramImageInfoDTO low_resolution) {
		this.low_resolution = low_resolution;
	}
	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
}
