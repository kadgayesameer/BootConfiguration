/**
 * 
 */
package com.iceico.BootConfiguration.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author PRAFUL MESHRAM
 *
 */
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public static final Logger LOGGER = LoggerFactory.getLogger(MySimpleUrlAuthenticationSuccessHandler.class);

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			LOGGER.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			LOGGER.error("Error Occured In URL Success Handler" + new Exception("URL Success Handler Error"));
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
		boolean isUser = false;
		boolean isAdmin = false;
		boolean isStudent = false;
		boolean isTeacher = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_USER")) {

				isUser = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {

				isAdmin = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_TEACHER")) {

				isTeacher = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_STUDENT")) {

				isStudent = true;
				break;
			}
		}

		if (isUser) {
			return "/user/dashboard";
		} else if (isAdmin) {
			return "/admin/dashboard";
		} else if (isTeacher) {
			return "/teacher/dashboard";
		} else if (isStudent) {
			return "/student/dashboard";
		} else {
			throw new IllegalStateException();
		}
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
