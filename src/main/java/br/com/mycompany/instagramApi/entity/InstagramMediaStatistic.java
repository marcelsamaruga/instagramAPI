/**
 * 
 */
package br.com.mycompany.instagramApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Marcel
 *
 */
@Entity
@Table(name="instagram_media_statistic")
public class InstagramMediaStatistic extends BaseEntity {

	private static final long serialVersionUID = -2599615560284702602L;

	@ManyToOne
	@JoinColumn(name="id_statistic_type", referencedColumnName="id", nullable=false)
	private InstagramStatisticType statisticType;
	
	@Column(name="value")
	private Long value;
	
	@ManyToOne
	@JoinColumn(name="id_media", referencedColumnName="id", nullable=false)
	private InstagramMedia media;

	/**
	 * @return the idStatisticType
	 */
	public InstagramStatisticType getStatisticType() {
		return statisticType;
	}

	/**
	 * @param idStatisticType the idStatisticType to set
	 */
	public void setStatisticType(InstagramStatisticType statisticType) {
		this.statisticType = statisticType;
	}

	/**
	 * @return the value
	 */
	public Long getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Long value) {
		this.value = value;
	}

	/**
	 * @return the media
	 */
	public InstagramMedia getMedia() {
		return media;
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia(InstagramMedia media) {
		this.media = media;
	}
	
}
