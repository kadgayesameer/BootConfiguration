/**
 * 
 */
package com.iceico.BootConfiguration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Engine;
import com.iceico.BootConfiguration.repository.EngineRepository;
import com.iceico.BootConfiguration.service.EngineService;

/**
 * @author Rajat
 *
 */

@Service
@Transactional
public class EngineServiceImpl implements EngineService {

	@Autowired
	EngineRepository engineRepository;
	
	/**
	 * 
	 */
	public EngineServiceImpl() {

	}

	@Override
	public void saveEngine(Engine engine) {
		this.engineRepository.save(engine);
	}

	@Override
	public void deleteEngine(Long engineId) {
		this.engineRepository.deleteById(engineId);
	}

	@Override
	public List<Engine> getEngineList() {
		return this.engineRepository.findAll();
	}

	@Override
	public Engine getEngineById(Long engineId) throws ResourceNotFoundException {
		return this.engineRepository.findById(engineId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Data Found At Id " + engineId));
	}
}
