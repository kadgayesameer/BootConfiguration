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
@Table(name = "tab_caste")
public class Caste implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2094619891814575883L;

	public Caste() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "caste_id")
	private Long casteId;
	
	@Column(name = "caste_name")
	private String casteName;
	
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
	 * @return the casteId
	 */
	public Long getCasteId() {
		return casteId;
	}

	/**
	 * @param casteId the casteId to set
	 */
	public void setCasteId(Long casteId) {
		this.casteId = casteId;
	}

	/**
	 * @return the casteName
	 */
	public String getCasteName() {
		return casteName;
	}

	/**
	 * @param casteName the casteName to set
	 */
	public void setCasteName(String casteName) {
		this.casteName = casteName;
	}
}
