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
import com.iceico.BootConfiguration.model.Exam;
import com.iceico.BootConfiguration.service.ExamService;
import com.iceico.BootConfiguration.service.StudentService;
import com.iceico.BootConfiguration.service.CategoryService;

/**
 * @author Rajat
 *
 */
@Controller
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 
	 */
	public ExamController() {

	}
	
	
	@RequestMapping("/admin/exam/{id}")
	public String adminDashboard(@PathVariable("id") Long studentId, ModelMap modelMap, Locale locale) throws ResourceNotFoundException, ParseException {
		System.out.println("====>"+this.studentService.getStudentById(studentId).getExam());
		modelMap.addAttribute("marksList", this.examService.getExamList());
		modelMap.addAttribute("studentId", studentId);
		modelMap.addAttribute("exam", (this.studentService.getStudentById(studentId).getExam()==null)?new Exam():this.studentService.getStudentById(studentId).getExam());
		modelMap.addAttribute("user", this.getPrincipal());

		return "exam";
	}

	@RequestMapping("/admin/exam/save")
	public String saveExam(  @ModelAttribute("exam") @Valid Exam exam,
		BindingResult bindingResult, ModelMap modelMap, Locale locale) {

		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("examList", this.examService.getExamList());
			modelMap.addAttribute("user", this.getPrincipal());
			return "student";
		} else {
			this.examService.saveExam(exam);
			modelMap.addAttribute("user", this.getPrincipal());
			return "redirect:/admin/students";
		}
	}
	
	@GetMapping("/admin/exam/edit/{id}")
	public String editExam(@PathVariable("id") Long examId, ModelMap modelMap, Locale locale)
			throws ResourceNotFoundException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("examList", this.examService.getExamList());
		modelMap.addAttribute("exam", this.examService.getExamById(examId));
		modelMap.addAttribute("edit", true);
		modelMap.addAttribute("user", this.getPrincipal());
		return "exam";
	}
	
	@GetMapping("/admin/exam/delete/{id}")
	public String deleteExam(@PathVariable("id") Long examId, ModelMap modelMap, Locale locale)
			throws ResourceNotFoundException {
		modelMap.addAttribute("categoryList", this.categoryService.getCategoryList());
		modelMap.addAttribute("examList", this.examService.getExamList());
		modelMap.addAttribute("exam", new Exam());
		this.examService.deleteExam(examId);
		modelMap.addAttribute("user", this.getPrincipal());
		return "exam";
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
