package com.mobiquity.weather.exception;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.mobiquity.weather.service.WeatherServiceImpl;

@ControllerAdvice
@RestController
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

	  @ExceptionHandler(Exception.class)
	  public final ResponseEntity<CustomApplicationError> handleAllExceptions(Exception ex, WebRequest request) {
		
		CustomApplicationError customError = new CustomApplicationError();
		ex.printStackTrace();
		log.info(ex.getMessage());
		if ( ex instanceof BaseApplicationException) {	
			 customError.setHttpStatus(((BaseApplicationException)ex).getHttpStatus());
			 customError.setErrorDesc(((BaseApplicationException)ex).getErrorDesc());	
		} else if ( ex instanceof URISyntaxException) {	
			 customError.setHttpStatus(HttpStatus.NOT_FOUND);
			 customError.setErrorDesc("Malformed URL");	
		}
		else if ( ex instanceof JsonMappingException) {
			customError.setHttpStatus(HttpStatus.NOT_FOUND);
			customError.setErrorDesc("Response Parsing Error");
		} else {
			customError.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			customError.setErrorDesc("Unknown Error");
		}
		
		 return new ResponseEntity<>(customError, customError.getHttpStatus());
		
	}
	
}
