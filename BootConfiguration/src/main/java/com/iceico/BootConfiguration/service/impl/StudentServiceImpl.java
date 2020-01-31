/**
 * 
 */
package com.iceico.BootConfiguration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Student;
import com.iceico.BootConfiguration.repository.StudentRepository;
import com.iceico.BootConfiguration.service.StudentService;

/**
 * @author Rajat
 *
 */

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	/**
	 * 
	 */
	public StudentServiceImpl() {

	}

	@Override
	public void saveStudent(Student student) {
		this.studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long studentId) {
		this.studentRepository.deleteById(studentId);
	}

	@Override
	public List<Student> getStudentList() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long studentId) throws ResourceNotFoundException {
		return this.studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Data Found At Id " + studentId));
	}
}
