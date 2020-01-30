/**
 * 
 */
package com.iceico.BootConfiguration.security;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author PRAFUL MESHRAM
 * 
 *         Created Date : 20/09/2018 Updated Date :
 * 
 *         This Class is for listening session event
 *
 */
public class SessionListener implements HttpSessionListener {

	public static final Logger LOGGER = LoggerFactory.getLogger(SessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		LOGGER.debug("Debugging sessionCreated");
		LOGGER.error("Error in sessionCreated", new Exception());
		System.out.println("==== Session is created ====");
		event.getSession().setMaxInactiveInterval(30 * 60);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		LOGGER.debug("Debugging sessionDestroyed");
		LOGGER.error("Error in sessionDestroyed", new Exception());
		System.out.println("==== Session is destroyed ====");

	}

}
