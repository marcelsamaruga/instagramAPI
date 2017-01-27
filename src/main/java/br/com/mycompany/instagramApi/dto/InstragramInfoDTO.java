/**
 * 
 */
package br.com.mycompany.instagramApi.dto;

/**
 * @author Marcel
 *
 */
public class InstragramInfoDTO {
	
	private InstagramMetaInfoDTO meta;
	private InstagramDataInfoDTO data;
	private String pagination;
	/**
	 * @return the meta
	 */
	public InstagramMetaInfoDTO getMeta() {
		return meta;
	}
	/**
	 * @param meta the meta to set
	 */
	public void setMeta(InstagramMetaInfoDTO meta) {
		this.meta = meta;
	}
	/**
	 * @return the data
	 */
	public InstagramDataInfoDTO getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(InstagramDataInfoDTO data) {
		this.data = data;
	}
	/**
	 * @return the pagination
	 */
	public String getPagination() {
		return pagination;
	}
	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(String pagination) {
		this.pagination = pagination;
	}
		
}
