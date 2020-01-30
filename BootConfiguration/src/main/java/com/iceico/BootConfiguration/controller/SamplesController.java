/**
 * 
 */
package com.iceico.BootConfiguration.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sameer
 *
 */
@Controller
public class SamplesController {

	public SamplesController() {
		
	}

	@GetMapping("/admin/sample/forms")
	public String samples(ModelMap modelMap, Locale locale) {

		return "sampleForms";
	}

}
