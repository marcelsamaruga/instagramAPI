/**
 * 
 */
package br.com.mycompany.instagramApi.enums;

/**
 * @author Marcel
 *
 */
public enum InstagramStatisticTypeEnum {
	
	STATISTIC_COMMENTS("Comments", "CM", "How many comments?", 1L),
	STATISTIC_LIKES("Likes", "LK", "How many likes?", 2L),
	STATISTIC_FOLLOWS("Follows", "FO", "How many users following?", 3L),
	STATISTIC_FOLLOWED_BY("Followed By", "FB", "Followed by how many users?", 4L), 
	STATISTIC_MEDIA("Media", "ME", "How many medias?	", 5L);
	
	private String name;
	private Long id;
	private String description;
	private String abbreviation;
	
	InstagramStatisticTypeEnum(String name, String abbreviation, String description, Long id) {
		this.abbreviation = abbreviation;
		this.description = description;
		this.id = id;
		this.name = name;
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

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

}
