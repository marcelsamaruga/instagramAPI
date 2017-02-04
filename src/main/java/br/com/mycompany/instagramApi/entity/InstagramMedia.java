/**
 * 
 */
package br.com.mycompany.instagramApi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Marcel
 *
 */
@Entity
@Table(name="instagram_media")
public class InstagramMedia extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3985428490705878497L;

	@Column(name = "created_time")
	private Long createTime;
	
	@Column(name = "id_post")
	private Long idPost;
	
	@Column(name = "link")
	private String link;
	
	
	//private InstagramLocation location;
	
	
	//private InstagramUser user;
	
	@Column(name = "column")
	private String caption;
	
	
	//private InstagramFilter filter;
	
	
	//private List<InstagramTag> tags;
	
	@Column(name = "width")
	private Integer width;
	
	@Column(name = "height")
	private Integer height;
	
	@Column(name = "url")
	private String url;

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
	public Long getIdPost() {
		return idPost;
	}

	/**
	 * @param idPost the idPost to set
	 */
	public void setIdPost(Long idPost) {
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
