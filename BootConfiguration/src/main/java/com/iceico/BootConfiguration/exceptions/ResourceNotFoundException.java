/**
 * 
 */
package com.iceico.BootConfiguration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Dipawali K. Gabhane
 * @version 0.1
 * 
 *          Created Date : 12/12/2019
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8007359508443567340L;

	/**
	 * @param string
	 * 
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
