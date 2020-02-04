/**
 * 
 */
package com.iceico.BootConfiguration.service;

import java.util.List;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Engine;


/**
 * @author Rajat
 *
 */

public interface EngineService {
	public void saveEngine(Engine engine);

	public void deleteEngine(Long engineId);

	public List<Engine> getEngineList();

	public Engine getEngineById(Long engineId) throws ResourceNotFoundException;
}
