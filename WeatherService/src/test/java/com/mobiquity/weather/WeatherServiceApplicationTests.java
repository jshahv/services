package com.mobiquity.weather;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mobiquity.weather.model.WeatherMetrics;
import com.mobiquity.weather.service.WeatherService;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceApplicationTests {
   
	@Autowired
	WeatherService weatherService;
	
	
	@Test
    public void testWeatherMetrics() {
		String cityName = "Ahmedabad";
		HashMap<LocalDate,WeatherMetrics> hMapweatherMetrics = new HashMap<>();
		LocalDate firstDay = LocalDate.now().plusDays(1);  // This is Tomorrow
		LocalDate secondDay = LocalDate.now().plusDays(2); 
		LocalDate thirDay = LocalDate.now().plusDays(3); 
		
		WeatherMetrics weatherDataDay1 = new WeatherMetrics();
		weatherDataDay1.setAvgDailyTemparature((float)29.282501);
		weatherDataDay1.setAvgNighltyTemparature((float)27.3725);
		weatherDataDay1.setMetricsDate("2019-10-21");
		
		WeatherMetrics weatherDataDay2 = new WeatherMetrics();
		weatherDataDay2.setAvgDailyTemparature((float)31.437502);
		weatherDataDay2.setAvgNighltyTemparature((float)28.877499);
		weatherDataDay2.setMetricsDate("2019-10-20");
		
		WeatherMetrics weatherDataDay3 = new WeatherMetrics();
		weatherDataDay3.setAvgDailyTemparature((float)31.86);
		weatherDataDay3.setAvgNighltyTemparature((float)28.91);
		weatherDataDay2.setMetricsDate("2019-10-19");
		
		try {
			
			List<WeatherMetrics> weatherMetrics = new ArrayList<>();
			weatherMetrics = weatherService.retriveWeatherMetrics(cityName);
			
			for(WeatherMetrics weatherMetric : weatherMetrics) {
				System.out.println(weatherMetric.toString());
				if(weatherMetric.getMetricsDate().equals(weatherDataDay1.getMetricsDate())) {
					assertEquals(weatherMetric.getAvgDailyTemparature(),weatherDataDay1.getAvgDailyTemparature(),0);
					assertEquals(weatherMetric.getAvgNighltyTemparature(),weatherDataDay1.getAvgNighltyTemparature(),0);
				}
				if(weatherMetric.getMetricsDate().equals(weatherDataDay2.getMetricsDate())) {
					assertEquals(weatherMetric.getAvgDailyTemparature(),weatherDataDay2.getAvgDailyTemparature(),0);
					assertEquals(weatherMetric.getAvgNighltyTemparature(),weatherDataDay2.getAvgNighltyTemparature(),0);
				}
				if(weatherMetric.getMetricsDate().equals(weatherDataDay3.getMetricsDate())) {
					assertEquals(weatherMetric.getAvgDailyTemparature(),weatherDataDay3.getAvgDailyTemparature(),0);
					assertEquals(weatherMetric.getAvgNighltyTemparature(),weatherDataDay3.getAvgNighltyTemparature(),0);
				}
			}
		
		} catch(Exception e) {
			
		}
    }

}
