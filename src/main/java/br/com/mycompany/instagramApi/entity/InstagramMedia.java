/**
 * 
 */
package br.com.mycompany.instagramApi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Marcel
 *
 */
@Entity
@Table(name="instagram_media", uniqueConstraints = {
		@UniqueConstraint(columnNames = "INSTAGRAM_ID_POST")
		}
)
public class InstagramMedia extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -3985428490705878497L;

	@Column(name = "created_time")
	private Long createTime;
	
	@Column(name = "instagram_id_post")
	private String idPost;
	
	@Column(name = "link")
	private String link;
	
	@ManyToOne
	@JoinColumn(name="id_location", referencedColumnName="id", nullable=false)
	private InstagramLocation location;
	
	@ManyToOne
	@JoinColumn(name="id_user", referencedColumnName="id", nullable=false)
	private InstagramUser user;
	
	@Column(name = "caption")
	private String caption;
	
	@Column(name = "tags")
	private String tags;
	
	@Column(name = "width")
	private Integer width;
	
	@Column(name = "height")
	private Integer height;
	
	@Column(name = "url_image")
	private String url;
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="instagram_media_filter", joinColumns=@JoinColumn(name="id_media"), inverseJoinColumns=@JoinColumn(name="id_filter"))  
	private List<InstagramFilter> listFilter;

	/**
	 * @return the createTime
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the idPost
	 */
	public String getIdPost() {
		return idPost;
	}

	/**
	 * @param idPost the idPost to set
	 */
	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the location
	 */
	public InstagramLocation getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(InstagramLocation location) {
		this.location = location;
	}

	/**
	 * @return the user
	 */
	public InstagramUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(InstagramUser user) {
		this.user = user;
	}

	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
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

	/**
	 * @return the listFilter
	 */
	public List<InstagramFilter> getListFilter() {
		return listFilter;
	}

	/**
	 * @param listFilter the listFilter to set
	 */
	public void setListFilter(List<InstagramFilter> listFilter) {
		this.listFilter = listFilter;
	}
	
}
