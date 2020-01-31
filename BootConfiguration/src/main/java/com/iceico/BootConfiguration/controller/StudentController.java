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
import com.iceico.BootConfiguration.model.Student;
import com.iceico.BootConfiguration.service.ExamService;
import com.iceico.BootConfiguration.service.CategoryService;
import com.iceico.BootConfiguration.service.StudentService;

/**
 * @author Rajat
 *
 */
@Controller
public class StudentController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ExamService examService;

	/**
	 * 
	 */
	public StudentController() {

	}

	@RequestMapping("/admin/students")
	public String adminDashboard(ModelMap modelMap, Locale locale) throws ResourceNotFoundException, ParseException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("studentList", this.studentService.getStudentList());
		modelMap.addAttribute("examList", this.examService.getExamList());
		modelMap.addAttribute("student", new Student());
		modelMap.addAttribute("user", this.getPrincipal());

		return "studentURL";
	}

	@RequestMapping("/admin/student/save")
	public String saveStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult,
			ModelMap modelMap, Locale locale) {
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("studentList", this.studentService.getStudentList());
			modelMap.addAttribute("user", this.getPrincipal());
			return "studentURL";
		} else {
			this.studentService.saveStudent(student);
			modelMap.addAttribute("user", this.getPrincipal());
			return "redirect:/admin/students";
		}
	}

	@GetMapping("/admin/student/edit/{id}")
	public String editStudent(@PathVariable("id") Long studentId, ModelMap modelMap, Locale locale)
			throws ResourceNotFoundException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("studentList", this.studentService.getStudentList());
		modelMap.addAttribute("student", this.studentService.getStudentById(studentId));
		modelMap.addAttribute("edit", true);
		modelMap.addAttribute("user", this.getPrincipal());
		return "studentURL";
	}

	@GetMapping("/admin/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long studentId, ModelMap modelMap, Locale locale)
			throws ResourceNotFoundException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("studentList", this.studentService.getStudentList());
		modelMap.addAttribute("student", new Student());
		this.studentService.deleteStudent(studentId);
		modelMap.addAttribute("user", this.getPrincipal());
		return "redirect:/admin/students";
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
