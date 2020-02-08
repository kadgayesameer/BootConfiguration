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
@Table(name = "tab_engine_factory")
public class EngineFactory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7937296125394943529L;

	public EngineFactory() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "factory_id")
	private Long factoryId;
	
	@Column(name = "factory_name")
	private String factoryName;


	@OneToMany(mappedBy = "engineFactory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Engine> engine;

	/**
	 * @return the factoryId
	 */
	public Long getFactoryId() {
		return factoryId;
	}

	/**
	 * @param factoryId the factoryId to set
	 */
	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}

	/**
	 * @return the factoryName
	 */
	public String getFactoryName() {
		return factoryName;
	}

	/**
	 * @param factoryName the factoryName to set
	 */
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	/**
	 * @return the engine
	 */
	public List<Engine> getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(List<Engine> engine) {
		this.engine = engine;
	}
	
	
}
