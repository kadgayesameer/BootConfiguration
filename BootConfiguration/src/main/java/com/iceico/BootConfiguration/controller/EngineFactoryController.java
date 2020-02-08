/**
 * 
 */
package com.iceico.BootConfiguration.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;
import com.iceico.BootConfiguration.model.Car;
import com.iceico.BootConfiguration.model.Engine;
import com.iceico.BootConfiguration.model.EngineFactory;
import com.iceico.BootConfiguration.service.CarService;
import com.iceico.BootConfiguration.service.EngineFactoryService;
import com.iceico.BootConfiguration.service.EngineService;

/**
 * @author Rajat
 *
 */
@Controller
public class EngineFactoryController {

	@Autowired
	EngineFactoryService engineFactoryService;

	@Autowired
	CarService carService;

	@Autowired
	EngineService engineService;

	/**
	 * 
	 */
	public EngineFactoryController() {

	}

	@RequestMapping("/admin/engine/factory")
	public String adminDashboard(ModelMap modelMap, Locale locale) throws ResourceNotFoundException, ParseException {
		modelMap.addAttribute("engineFactory", new EngineFactory());
		modelMap.addAttribute("user", this.getPrincipal());
		return "engineFactory";
	}

	@RequestMapping("/admin/engine/factory/save")
	public String saveStudent(@ModelAttribute("engineFactory") @Valid EngineFactory engineFactory,
			@RequestParam("engineJson") String engineFactoryJson, BindingResult bindingResult, ModelMap modelMap,
			Locale locale) throws org.json.simple.parser.ParseException {
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("user", this.getPrincipal());
			return "engineFactory";
		} else {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(engineFactoryJson);
			List<Engine> engines = new ArrayList<Engine>();

			for (int i = 0; i < array.size(); i++) {
				JSONObject engineObj = new JSONObject();
				Engine engine = new Engine();
				engineObj = (JSONObject) array.get(i);

				engine.setEngineHP(Integer.parseInt(engineObj.get("engineHP").toString()));
				engine.setEngineModel(engineObj.get("engineModel").toString());
				List<Car> cars = new ArrayList<Car>();

				JSONArray carsArray = new JSONArray();
				carsArray = (JSONArray) parser.parse(engineObj.get("cars").toString());

				for (int j = 0; j < carsArray.size(); j++) {
					Car car = new Car();

					JSONObject carObj = new JSONObject();
					carObj = (JSONObject) carsArray.get(j);
					car.setCarName(carObj.get("carName").toString());
					car.setEngine(engine);
					cars.add(car);
				}

				engine.setCar(cars);
				engine.setEngineFactory(engineFactory);
				engines.add(engine);
			}
			engineFactory.setEngine(engines);
			
			
			System.out.println("Engine Factory Name ===> "+engineFactory.getFactoryName());
			for (Engine engine : engineFactory.getEngine()) {
				System.out.println("Engine Model ===> "+engine.getEngineModel());
				System.out.println("Engine HP ===> "+engine.getEngineHP());
				System.out.println("Engine Factory ===> "+engine.getEngineFactory().getFactoryName());
				
				for (Car car : engine.getCar()) {
					System.out.println("Car ===> "+car.getCarName());
					System.out.println("Engine Model Name ===> "+car.getEngine().getEngineModel());
				}
			}

			this.engineFactoryService.saveEngineFactory(engineFactory);

			modelMap.addAttribute("user", this.getPrincipal());
			return "redirect:/admin/engine/factory";
		}
	}

	@GetMapping("/admin/engine/factory/edit/{id}")
	public String editStudent(@PathVariable("id") Long studentId, ModelMap modelMap, Locale locale)
			throws ResourceNotFoundException {
		modelMap.addAttribute("edit", true);
		modelMap.addAttribute("user", this.getPrincipal());
		return "engineFactory";
	}

	@GetMapping("/admin/engine/factory/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long studentId, ModelMap modelMap, Locale locale)
			throws ResourceNotFoundException {
		modelMap.addAttribute("user", this.getPrincipal());
		return "redirect:/admin/engine/factory";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
