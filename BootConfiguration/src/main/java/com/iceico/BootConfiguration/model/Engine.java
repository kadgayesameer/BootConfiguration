package com.iceico.BootConfiguration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rajat Patil
 * @version 0.1
 * 
 * Created Date : 21/01/2020
 *
 */
@Entity
@Table(name = "tab_engine")
public class Engine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7937296125394943529L;

	public Engine() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "engine_id")
	private Long engineId;
	
	@Column(name = "engine_model")
	private String engineModel;
	
	@Column(name = "engine_hp")
	private Integer engineHP;

	
	@OneToMany(mappedBy = "engine", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Car> car;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "factoryId", insertable = true, nullable = true, updatable = true)
	private EngineFactory engineFactory;
	
	/**
	 * @return the engineId
	 */
	public Long getEngineId() {
		return engineId;
	}

	/**
	 * @param engineId the engineId to set
	 */
	public void setEngineId(Long engineId) {
		this.engineId = engineId;
	}

	/**
	 * @return the engineModel
	 */
	public String getEngineModel() {
		return engineModel;
	}

	/**
	 * @param engineModel the engineModel to set
	 */
	public void setEngineModel(String engineModel) {
		this.engineModel = engineModel;
	}

	/**
	 * @return the engineHP
	 */
	public Integer getEngineHP() {
		return engineHP;
	}

	/**
	 * @param engineHP the engineHP to set
	 */
	public void setEngineHP(Integer engineHP) {
		this.engineHP = engineHP;
	}

	/**
	 * @return the car
	 */
	public List<Car> getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(List<Car> car) {
		this.car = car;
	}

	/**
	 * @return the engineFactory
	 */
	public EngineFactory getEngineFactory() {
		return engineFactory;
	}

	/**
	 * @param engineFactory the engineFactory to set
	 */
	public void setEngineFactory(EngineFactory engineFactory) {
		this.engineFactory = engineFactory;
	}

	
}
