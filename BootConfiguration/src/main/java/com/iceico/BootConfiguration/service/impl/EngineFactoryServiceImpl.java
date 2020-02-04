/**
 * 
 */
package com.iceico.BootConfiguration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.EngineFactory;
import com.iceico.BootConfiguration.repository.EngineFactoryRepository;
import com.iceico.BootConfiguration.service.EngineFactoryService;

/**
 * @author Rajat
 *
 */

@Service
@Transactional
public class EngineFactoryServiceImpl implements EngineFactoryService {

	@Autowired
	EngineFactoryRepository engineFactoryRepository;
	
	/**
	 * 
	 */
	public EngineFactoryServiceImpl() {

	}

	@Override
	public void saveEngineFactory(EngineFactory engineFactory) {
		this.engineFactoryRepository.save(engineFactory);
	}

	@Override
	public void deleteEngineFactory(Long engineFactoryId) {
		this.engineFactoryRepository.deleteById(engineFactoryId);
	}

	@Override
	public List<EngineFactory> getEngineFactoryList() {
		return this.engineFactoryRepository.findAll();
	}

	@Override
	public EngineFactory getEngineFactoryById(Long engineFactoryId) throws ResourceNotFoundException {
		return this.engineFactoryRepository.findById(engineFactoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Data Found At Id " + engineFactoryId));
	}
}
