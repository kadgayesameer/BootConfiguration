/**
 * 
 */
package com.iceico.BootConfiguration.service;

import java.util.List;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Exam;


/**
 * @author Rajat
 *
 */

public interface ExamService {
	public void saveExam(Exam exam);

	public void deleteExam(Long examId);

	public List<Exam> getExamList();

	public Exam getExamById(Long examId) throws ResourceNotFoundException;
}
