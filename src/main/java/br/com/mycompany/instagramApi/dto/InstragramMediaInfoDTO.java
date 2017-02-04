/**
 * 
 */
package br.com.mycompany.instagramApi.dto;

import java.util.List;

/**
 * @author Marcel
 *
 */
public class InstragramMediaInfoDTO {
	
	private InstagramMetaInfoDTO meta;
	private List<InstagramDataInfoDTO> data;
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
	public List<InstagramDataInfoDTO> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<InstagramDataInfoDTO> data) {
		this.data = data;
	}
			
}
