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
import com.iceico.BootConfiguration.model.Category;
import com.iceico.BootConfiguration.service.CategoryService;

/**
 * @author Rajat
 *
 */
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	/**
	 * 
	 */
	public CategoryController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/admin/category")
	public String categoryDashboard(ModelMap modelMap, Locale locale) throws ResourceNotFoundException, ParseException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("category", new Category());
		modelMap.addAttribute("user", this.getPrincipal());
		return "category";
	}

	@RequestMapping("/admin/category/save")
	public String saveCategory(  @ModelAttribute("category") @Valid Category category,
		BindingResult bindingResult, ModelMap modelMap, Locale locale) {

		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
			modelMap.addAttribute("user", this.getPrincipal());
			return "category";
		} else {
			this.categoryService.saveCategory(category);
			modelMap.addAttribute("user", this.getPrincipal());
			return "redirect:/admin/category";
		}
	}
	
	@GetMapping("/admin/category/edit/{id}")
	public String editDepartment(@PathVariable("id") Long categoryId, ModelMap modelMap, Locale locale)
			throws ResourceNotFoundException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("category", this.categoryService.getCategoryById(categoryId));
		modelMap.addAttribute("edit", true);
		modelMap.addAttribute("user", this.getPrincipal());
		return "category";
	}
	
	@GetMapping("/admin/category/delete/{id}")
	public String deleteDepartment(@PathVariable("id") Long categoryId, ModelMap modelMap, Locale locale)
			throws ResourceNotFoundException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("category", new Category());
		this.categoryService.deleteCategory(categoryId);
		modelMap.addAttribute("user", this.getPrincipal());
		return "category";
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
