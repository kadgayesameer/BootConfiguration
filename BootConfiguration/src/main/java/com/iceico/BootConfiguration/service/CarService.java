/**
 * 
 */
package com.iceico.BootConfiguration.service;

import java.util.List;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Car;


/**
 * @author Rajat
 *
 */

public interface CarService {
	public void saveCar(Car car);

	public void deleteCar(Long carId);

	public List<Car> getCarList();

	public Car getCarById(Long carId) throws ResourceNotFoundException;
}
