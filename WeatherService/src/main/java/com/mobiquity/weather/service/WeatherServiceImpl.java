package com.mobiquity.weather.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.server.LogStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.weather.exception.BaseApplicationException;
import com.mobiquity.weather.model.WeatherInfo;
import com.mobiquity.weather.model.WeatherMetrics;

@Component
public class WeatherServiceImpl implements WeatherService{
	
	private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

	
	 @Autowired
	 private RestTemplate restTemplate;
	
	 @Value("${openweatherURL}")
	 private String openweatherURL;
	 
	 @Value("${startDayHour}")
	 private short startDayHour;
	 @Value("${endDayHour}")
	 private short endDayHour;
	 @Value("${startNightHour}")
	 private short startNightHour;
	 @Value("${endNightHour}")
	 private short endNightHour;
	 
	 /*
	  * Main Service method to get Weather Metrics Data
	  * 
	  */
	 
	public List<WeatherMetrics> retriveWeatherMetrics(String cityName) throws Exception {
		
		log.debug("retriveWeatherMetrics Start");
		List<WeatherMetrics> weatherMetricsThreeDays = new ArrayList<>();
		
		WeatherInfo weatherInfo = 	callWeatherMetricsAPI(cityName);
	    weatherMetricsThreeDays = calculateMetricsbyDay(weatherInfo);
		
		log.debug("retriveWeatherMetrics End");
			
		return weatherMetricsThreeDays;
		 
		
	}
	
	/*
	 * Weather API Call to retrieve 5 days of Weather Metrics related to Temprature & Pressure
	 * 
	 */
	
	private WeatherInfo callWeatherMetricsAPI(String cityName)  throws  URISyntaxException , JsonMappingException , Exception {
		
		 String finalURL = openweatherURL + cityName;
		 URI uri = new URI(finalURL);
		 System.out.println("baseUrl" + openweatherURL);
		 
		 ResponseEntity<String> response  = restTemplate.getForEntity(uri , String.class);
		 String responseBody = response.getBody(); 
		 ObjectMapper mapper = new ObjectMapper();
		 WeatherInfo weatherInfo = mapper.readValue(responseBody, WeatherInfo.class);
		 
		 		 
		 return weatherInfo;
		
	}
	
   
	/*
	 * 1) This method calculates Total Temparatuer for Day (06 AM to 18 PM) and Night (18 PM to 06 AM) 
	 *  and also calculate Total Pressure for 24 hrs
	 *  
	 *  2) Temprature data is for every 3 hrs so dividing by 4 will get Average Temprature. This rules applies to Day and Night Temprature
	 *  
	 *  3) Total Pressure is divided by 24 to get Average daily Pressure
	 */
	private List<WeatherMetrics> calculateMetricsbyDay(WeatherInfo weatherInfo ) throws Exception , DateTimeParseException  {
		
		List<WeatherMetrics> weatherMetricsThreeDays = new ArrayList<>();
		DateTimeFormatter formatterYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter formatterYYYYMMDD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		

		int totalDayHours = (endDayHour-startDayHour)/3;  
		int totalNightHours = (startNightHour-endNightHour)/3;
		
		LocalDate dayAfterTomorrow = LocalDate.now().plusDays(4); 
		LocalDate today = LocalDate.now(); 
		HashMap<LocalDate,WeatherMetrics> hMapweatherMetrics = new HashMap<>();
		WeatherMetrics weatherData = null;
		
		  for(com.mobiquity.weather.model.List record : weatherInfo.getList()) {
			 	
			 LocalDateTime weatherMetricDateTime = LocalDateTime.parse(record.getDtTxt(),formatterYYYMMDDHHMMSS); 
			 LocalDate weatherMetricDate = LocalDate.of(weatherMetricDateTime.getYear(), 
					 	weatherMetricDateTime.getMonth(), weatherMetricDateTime.getDayOfMonth());
			 
			 // Weather API is giving 5 days of data so this condition is to ignore more then 3 days of data
		     // Today's data was not consistent so I wrote logic to display next 3 days excluding Today
			 if(weatherMetricDate.isBefore(dayAfterTomorrow) && weatherMetricDate.isAfter(today)) {
				 
				 if(hMapweatherMetrics.containsKey(weatherMetricDate))
					weatherData = hMapweatherMetrics.get(weatherMetricDate);
				 else
					weatherData = new WeatherMetrics();
				
				 String stringDate = weatherMetricDate.format(formatterYYYYMMDD);
				 
				 weatherData.setMetricsDate(stringDate);	 
				 if(weatherMetricDateTime.getHour() > startDayHour && weatherMetricDateTime.getHour() <= endDayHour ) { 
					weatherData.setTotalTemparature(weatherData.getTotalTemparature() + record.getMain().getTemp());
				 }		 
			
				 if(weatherMetricDateTime.getHour() > startNightHour || weatherMetricDateTime.getHour() <= endNightHour ) {
					 weatherData.setTotalNighltyTemparature(weatherData.getTotalNighltyTemparature() + record.getMain().getTemp());
				 }
				 weatherData.setTotalPressure(weatherData.getTotalPressure() + record.getMain().getPressure());	
				 hMapweatherMetrics.put(weatherMetricDate, weatherData);
			 } 				
		};
		
		hMapweatherMetrics.values().stream().forEach(
				record->{
					record.setAvgDailyTemparature(record.getTotalTemparature()/totalDayHours);
					record.setAvgNighltyTemparature(record.getTotalNighltyTemparature()/totalDayHours);					
					weatherMetricsThreeDays.add(record);
				}
		);
		
		return weatherMetricsThreeDays;
	
	}

}
