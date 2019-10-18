package com.mobiquity.weather.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WeatherMetrics {
	
   private float avgDailyTemparature;
   private float avgNighltyTemparature;
   private float avgPressure;
   @JsonIgnore
   private float totalTemparature;
   @JsonIgnore
   private float totalNighltyTemparature;
   @JsonIgnore
   private float totalPressure;
   private String  metricsDate;
   
   
   
    @Override
public String toString() {
	return "WeatherMetrics [avgDailyTemparature=" + avgDailyTemparature + ", avgNighltyTemparature="
			+ avgNighltyTemparature + ", avgPressure=" + avgPressure + ", totalTemparature=" + totalTemparature
			+ ", totalNighltyTemparature=" + totalNighltyTemparature + ", totalPressure=" + totalPressure
			+ ", metricsDate=" + metricsDate + "]";
}

	public float getTotalTemparature() {
    	return totalTemparature;
	}
	
	public void setTotalTemparature(float totalTemparature) {
		this.totalTemparature = totalTemparature;
	}
	
	public float getTotalNighltyTemparature() {
		return totalNighltyTemparature;
	}
	
	public void setTotalNighltyTemparature(float totalNighltyTemparature) {
		this.totalNighltyTemparature = totalNighltyTemparature;
	}
	
	public float getTotalPressure() {
		return totalPressure;
	}
	
	public void setTotalPressure(float totalPressure) {
		this.totalPressure = totalPressure;
	}

	public String getMetricsDate() {
		return metricsDate;
	}
	
   public void setMetricsDate(String metricsDate) {
		this.metricsDate = metricsDate;
   }

   public float getAvgDailyTemparature() {
		return avgDailyTemparature;
   }
   
   public void setAvgDailyTemparature(float avgDailyTemparature) {
		this.avgDailyTemparature = avgDailyTemparature;
   }
   
   public float getAvgNighltyTemparature() {
		return avgNighltyTemparature;
   }

   public void setAvgNighltyTemparature(float avgNighltyTemparature) {
		this.avgNighltyTemparature = avgNighltyTemparature;
   }

   public float getAvgPressure() {
		return avgPressure;
   }

   public void setAvgPressure(float avgPressure) {
		this.avgPressure = avgPressure;
   }
	   
}
