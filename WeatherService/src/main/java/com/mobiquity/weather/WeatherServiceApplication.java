package com.mobiquity.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@SpringBootApplication
public class WeatherServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(WeatherServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
		System.out.println("success---->");
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
}
