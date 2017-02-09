/**
 * 
 */
package br.com.mycompany.instagramApi.exception;

/**
 * @author Marcel
 *
 */
public class ErrorConnectionException extends RuntimeException {

	/**
	 * @param string
	 */
	public ErrorConnectionException(String string) {
		super(string);
	}

	private static final long serialVersionUID = -4824718753750119948L;

}
