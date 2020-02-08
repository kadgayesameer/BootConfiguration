/**
 * 
 */
package com.iceico.BootConfiguration.controller;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;

/**
 * @author Rajat
 *
 */

@Controller
public class CompilerController {
	/**
	 * 
	 */
	public CompilerController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/admin/compiler")
	public String categoryDashboard(ModelMap modelMap, Locale locale) throws ResourceNotFoundException, ParseException {

		modelMap.addAttribute("user", this.getPrincipal());
		return "editor";
	}
	
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
