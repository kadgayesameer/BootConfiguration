/**
 * 
 */
package com.iceico.BootConfiguration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Caste;
import com.iceico.BootConfiguration.repository.CasteRepository;
import com.iceico.BootConfiguration.service.CasteService;

/**
 * @author Rajat
 *
 */

@Service
@Transactional
public class CasteServiceImpl implements CasteService {

	@Autowired
	CasteRepository casteRepository;
	
	/**
	 * 
	 */
	public CasteServiceImpl() {

	}

	@Override
	public void saveCaste(Caste caste) {
		this.casteRepository.save(caste);
	}

	@Override
	public void deleteCaste(Long casteId) {
		this.casteRepository.deleteById(casteId);
	}

	@Override
	public List<Caste> getCasteList() {
		return this.casteRepository.findAll();
	}

	@Override
	public Caste getCasteById(Long casteId) throws ResourceNotFoundException {
		return this.casteRepository.findById(casteId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Data Found At Id " + casteId));
	}
}
