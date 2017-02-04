/**
 * 
 */
package br.com.mycompany.instagramApi.enums;

/**
 * @author Marcel
 *
 */
public enum ContentTypeEnum {
	
	JSON_CONTENT_TYPE("application/json"),
	XML_CONTENT_TYPE("application/xml"),
	HTML_CONTENT_TYPE("text/html"),
	PLAIN_CONTENT_TYPE("text/plain");
	
	private String name;
	
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
	
	ContentTypeEnum(String name) {
		this.name = name;
	}

}
