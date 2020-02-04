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
import javax.persistence.Table;

/**
 * @author Rajat Patil
 * @version 0.1
 * 
 * Created Date : 21/01/2020
 *
 */
@Entity
@Table(name = "tab_car")
public class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7937296125394943529L;

	public Car() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Long carFactoryId;
	
	@Column(name = "car_model")
	private String carName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "engineId", insertable = true, nullable = true, updatable = true)
	private Engine engine;

	/**
	 * @return the carFactoryId
	 */
	public Long getCarFactoryId() {
		return carFactoryId;
	}

	/**
	 * @param carFactoryId the carFactoryId to set
	 */
	public void setCarFactoryId(Long carFactoryId) {
		this.carFactoryId = carFactoryId;
	}

	/**
	 * @return the carName
	 */
	public String getCarName() {
		return carName;
	}

	/**
	 * @param carName the carName to set
	 */
	public void setCarName(String carName) {
		this.carName = carName;
	}

	/**
	 * @return the engine
	 */
	public Engine getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
}
