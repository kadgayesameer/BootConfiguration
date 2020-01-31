/**
 * 
 */
package com.iceico.BootConfiguration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Exam;
import com.iceico.BootConfiguration.repository.ExamRepository;
import com.iceico.BootConfiguration.service.ExamService;

/**
 * @author Rajat
 *
 */

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	ExamRepository examRepository;
	
	/**
	 * 
	 */
	public ExamServiceImpl() {

	}

	@Override
	public void saveExam(Exam exam) {
		this.examRepository.save(exam);
	}

	@Override
	public void deleteExam(Long examId) {
		this.examRepository.deleteById(examId);
	}

	@Override
	public List<Exam> getExamList() {
		return this.examRepository.findAll();
	}

	@Override
	public Exam getExamById(Long examId) throws ResourceNotFoundException {
		return this.examRepository.findById(examId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Data Found At Id " + examId));
	}
}
