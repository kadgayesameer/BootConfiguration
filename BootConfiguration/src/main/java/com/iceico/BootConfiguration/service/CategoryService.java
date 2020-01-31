/**
 * 
 */
package com.iceico.BootConfiguration.service;

import java.util.List;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Category;


/**
 * @author Rajat
 *
 */

public interface CategoryService {
	public void saveCategory(Category category);

	public void deleteCategory(Long categoryId);

	public List<Category> getCategoryList();

	public Category getCategoryById(Long categoryId) throws ResourceNotFoundException;
}
