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
@Table(name="instagram_statistic_type", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ABBREVIATION")
	}
)
public class InstagramStatisticType extends BaseEntity {

	private static final long serialVersionUID = -2168279816672150746L;

	@Column(name="name")
	private String name;
	
	@Column(name="abbreviation")
	private String abbreviation;
	
	@Column(name="description")
	private String description;
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
	 * @return the abbreviaton
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
	/**
	 * @param abbreviaton the abbreviaton to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
