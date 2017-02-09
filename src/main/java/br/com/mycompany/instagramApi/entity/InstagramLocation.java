/**
 * 
 */
package br.com.mycompany.instagramApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Marcel
 *
 */
@Entity
@Table(name = "instagram_location", uniqueConstraints = {
		@UniqueConstraint(columnNames = "NAME")
		}
)
public class InstagramLocation extends BaseEntity {
	
	public InstagramLocation(){}
	
	public InstagramLocation(Long idLocation, String name, String longitude, String latitude) {
		super();
		this.idLocation = idLocation;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	private static final long serialVersionUID = 8031924064925459734L;
	
	@Column(name = "instagram_id")
	private Long idLocation;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "latitude")
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
