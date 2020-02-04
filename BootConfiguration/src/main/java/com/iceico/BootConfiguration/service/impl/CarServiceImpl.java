/**
 * 
 */
package com.iceico.BootConfiguration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Car;
import com.iceico.BootConfiguration.repository.CarRepository;
import com.iceico.BootConfiguration.service.CarService;

/**
 * @author Rajat
 *
 */

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository carRepository;
	
	/**
	 * 
	 */
	public CarServiceImpl() {

	}

	@Override
	public void saveCar(Car car) {
		this.carRepository.save(car);
	}

	@Override
	public void deleteCar(Long carId) {
		this.carRepository.deleteById(carId);
	}

	@Override
	public List<Car> getCarList() {
		return this.carRepository.findAll();
	}

	@Override
	public Car getCarById(Long carId) throws ResourceNotFoundException {
		return this.carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Data Found At Id " + carId));
	}
}
