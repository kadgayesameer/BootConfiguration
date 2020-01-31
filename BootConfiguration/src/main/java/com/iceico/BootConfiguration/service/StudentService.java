/**
 * 
 */
package com.iceico.BootConfiguration.service;

import java.util.List;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Student;


/**
 * @author Rajat
 *
 */

public interface StudentService {
	public void saveStudent(Student student);

	public void deleteStudent(Long studentId);

	public List<Student> getStudentList();

	public Student getStudentById(Long studentId) throws ResourceNotFoundException;
}
