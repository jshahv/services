package com.mobiquity.weather.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mobiquity.weather.model.WeatherMetrics;

@Component
public interface WeatherService {
	
	public List<WeatherMetrics> retriveWeatherMetrics(String cityName) throws Exception ;

}
