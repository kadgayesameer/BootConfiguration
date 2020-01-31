/**
 * 
 */
package com.iceico.BootConfiguration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Rajat
 *
 */
@Entity
@Table(name = "tab_student")
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1496183721505017751L;

	/**
	 * 
	 */
	public Student() {

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", insertable = true, nullable = true, updatable = true)
	@JsonIgnore
	private Category category;
	
	@JsonIgnore
	@OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
	private Caste caste;
	
	/**
	 * @return the caste
	 */
	public Caste getCaste() {
		return caste;
	}

	/**
	 * @param caste the caste to set
	 */
	public void setCaste(Caste caste) {
		this.caste = caste;
	}

	/**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
}
