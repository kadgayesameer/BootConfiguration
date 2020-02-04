/**
 * 
 */
package com.iceico.BootConfiguration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iceico.BootConfiguration.model.Engine;

/**
 * @author Rajat
 * @version 0.1
 * 
 * Created Date : 30/12/2019
 */
@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {

}
