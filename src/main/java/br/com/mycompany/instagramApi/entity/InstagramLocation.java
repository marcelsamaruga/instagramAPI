/**
 * 
 */
package br.com.mycompany.instagramApi.entity;

/**
 * @author Marcel
 *
 */
public class InstagramLocation {

	private Long idLocation;
	private String name;
	private String longitude;
	private String latitude;
	/**
	 * @return the idLocation
	 */
	public Long getIdLocation() {
		return idLocation;
	}
	/**
	 * @param idLocation the idLocation to set
	 */
	public void setIdLocation(Long idLocation) {
		this.idLocation = idLocation;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
}
