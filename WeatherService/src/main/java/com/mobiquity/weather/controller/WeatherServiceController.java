package com.mobiquity.weather.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.mobiquity.weather.exception.BaseApplicationException;
import com.mobiquity.weather.model.WeatherMetrics;
import com.mobiquity.weather.service.WeatherService;
import com.mobiquity.weather.service.WeatherServiceImpl;

@RestController
public class WeatherServiceController {
	
	private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

	@Autowired
	private WeatherService weatherService;

	@GetMapping("/weather/metrics/{cityName}")
	public List<WeatherMetrics> retriveWeatherMetrics(@PathVariable String cityName) throws Exception {
		
		List<WeatherMetrics> weatherMetrics = new ArrayList<>();
		validateInputRequest(cityName);
		weatherMetrics = weatherService.retriveWeatherMetrics(cityName);
					
		return weatherMetrics;
	}
	
	
	/*
	 * Validate Input Request for Mandatory Parameter
	 */
	
	private void validateInputRequest(String cityName) throws BaseApplicationException {

		BaseApplicationException baseException = new BaseApplicationException();
		if (cityName.isEmpty()) {
			 baseException.setHttpStatus(HttpStatus.NOT_FOUND);
			 baseException.setErrorDesc("Mandator Input Missing");
			 throw baseException;
		}
				
	} 

}
