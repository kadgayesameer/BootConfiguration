/**
 * 
 */
package com.iceico.BootConfiguration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iceico.BootConfiguration.model.Exam;

/**
 * @author Rajat
 * @version 0.1
 * 
 * Created Date : 30/12/2019
 */
@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
