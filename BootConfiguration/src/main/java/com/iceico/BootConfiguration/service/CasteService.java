/**
 * 
 */
package com.iceico.BootConfiguration.service;

import java.util.List;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Caste;


/**
 * @author Rajat
 *
 */

public interface CasteService {
	public void saveCaste(Caste caste);

	public void deleteCaste(Long casteId);

	public List<Caste> getCasteList();

	public Caste getCasteById(Long casteId) throws ResourceNotFoundException;
}
