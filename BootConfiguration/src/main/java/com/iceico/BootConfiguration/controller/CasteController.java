/**
 * 
 */
package com.iceico.BootConfiguration.controller;

import java.text.ParseException;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Caste;
import com.iceico.BootConfiguration.service.CasteService;
import com.iceico.BootConfiguration.service.CategoryService;

/**
 * @author Rajat
 *
 */
@Controller
public class CasteController {

	@Autowired
	private CasteService casteService;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 
	 */
	public CasteController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping("/admin/caste")
	public String adminDashboard(ModelMap modelMap, Locale locale) throws ResourceNotFoundException, ParseException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("casteList", this.casteService.getCasteList());
		modelMap.addAttribute("caste", new Caste());
		modelMap.addAttribute("user", this.getPrincipal());

		return "caste";
	}

	@RequestMapping("/admin/caste/save")
	public String saveCaste(  @ModelAttribute("caste") @Valid Caste caste,
		BindingResult bindingResult, ModelMap modelMap, Locale locale) {

		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("casteList", this.categoryService.getCategoryList());
			modelMap.addAttribute("user", this.getPrincipal());
			return "caste";
		} else {
			this.casteService.saveCaste(caste);
			modelMap.addAttribute("user", this.getPrincipal());
			return "redirect:/admin/caste";
		}
	}
	
	@GetMapping("/admin/caste/edit/{id}")
	public String editCaste(@PathVariable("id") Long casteId, ModelMap modelMap, Locale locale)
			throws ResourceNotFoundException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("casteList", this.casteService.getCasteList());
		modelMap.addAttribute("caste", this.casteService.getCasteById(casteId));
		modelMap.addAttribute("edit", true);
		modelMap.addAttribute("user", this.getPrincipal());
		return "caste";
	}
	
	@GetMapping("/admin/caste/delete/{id}")
	public String deleteCaste(@PathVariable("id") Long casteId, ModelMap modelMap, Locale locale)
			throws ResourceNotFoundException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("casteList", this.casteService.getCasteList());
		modelMap.addAttribute("caste", new Caste());
		this.casteService.deleteCaste(casteId);
		modelMap.addAttribute("user", this.getPrincipal());
		return "caste";
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
