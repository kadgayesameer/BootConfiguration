/**
 * 
 */
package com.iceico.BootConfiguration.service;

import java.util.List;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.EngineFactory;


/**
 * @author Rajat
 *
 */

public interface EngineFactoryService {
	public void saveEngineFactory(EngineFactory engineFactory);

	public void deleteEngineFactory(Long engineFactoryId);

	public List<EngineFactory> getEngineFactoryList();

	public EngineFactory getEngineFactoryById(Long engineFactoryId) throws ResourceNotFoundException;
}
