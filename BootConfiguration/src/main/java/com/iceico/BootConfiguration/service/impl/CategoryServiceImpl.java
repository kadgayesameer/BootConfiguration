/**
 * 
 */
package com.iceico.BootConfiguration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Category;
import com.iceico.BootConfiguration.repository.CategoryRepository;
import com.iceico.BootConfiguration.service.CategoryService;

/**
 * @author Rajat
 *
 */

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	/**
	 * 
	 */
	public CategoryServiceImpl() {

	}

	@Override
	public void saveCategory(Category category) {
		this.categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		this.categoryRepository.deleteById(categoryId);
	}

	@Override
	public List<Category> getCategoryList() {
		return this.categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long categoryId) throws ResourceNotFoundException {
		return this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Data Found At Id " + categoryId));
	}
}
