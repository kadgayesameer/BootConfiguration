package com.iceico.BootConfiguration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Rajat Patil
 * @version 0.1
 * 
 * Created Date : 21/01/2020
 */
@Entity
@Table(name = "tab_exam")
public class Exam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2094619891814575883L;

	public Exam() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_id")
	private Long examId;
	
	@Column(name = "marks")
	private Double marks;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "studentId", insertable = true, nullable = true, updatable = true)
	@JsonIgnore
	private Student student;

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the examId
	 */
	public Long getExamId() {
		return examId;
	}

	/**
	 * @param examId the examId to set
	 */
	public void setExamId(Long examId) {
		this.examId = examId;
	}

	/**
	 * @return the marks
	 */
	public Double getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(Double marks) {
		this.marks = marks;
	}
	
}
