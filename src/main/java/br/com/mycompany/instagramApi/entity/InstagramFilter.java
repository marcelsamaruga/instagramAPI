/**
 * 
 */
package br.com.mycompany.instagramApi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Marcel
 *
 */
@Entity
@Table(name = "instagram_filter", uniqueConstraints = {
		@UniqueConstraint(columnNames = "NAME")
})
public class InstagramFilter extends BaseEntity {

	private static final long serialVersionUID = -5152230578943605280L;
	
	@Column
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="listFilter") 
	private List<InstagramMedia> listInstagramMedia;

	public InstagramFilter() {}
	
	/**
	 * @param filter
	 */
	public InstagramFilter(String name) {
		this.name = name;
	}

	/**
	 * @return the listInstagramMedia
	 */
	public List<InstagramMedia> getListInstagramMedia() {
		return listInstagramMedia;
	}

	/**
	 * @param listInstagramMedia the listInstagramMedia to set
	 */
	public void setListInstagramMedia(List<InstagramMedia> listInstagramMedia) {
		this.listInstagramMedia = listInstagramMedia;
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
}
