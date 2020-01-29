/**
 * 
 */
package com.iceico.BootConfiguration.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sameer
 *
 */
@Controller
public class TilesController {

	@RequestMapping("/admin/dashboard")
	public String adminDashboard(ModelMap modelMap, Locale locale) {
		return "adminDashboard";
	}

	@RequestMapping("/")
	public String dashboard(ModelMap modelMap, Locale locale) {
		return "adminDashboard";
	}

}
