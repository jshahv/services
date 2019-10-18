
package com.mobiquity.weather.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "main",
    "weather",
    "clouds",
    "wind",
    "sys",
    "dt_txt",
    "rain"
})
public class List {

    @JsonProperty("dt")
    public Integer dt;
    @JsonProperty("main")
    public Main main;
    @JsonProperty("weather")
    public java.util.List<Weather> weather = null;
    @JsonProperty("clouds")
    public Clouds clouds;
    @JsonProperty("wind")
    public Wind wind;
    @JsonProperty("sys")
    public Sys sys;
    @JsonProperty("dt_txt")
    public String dtTxt;
    @JsonProperty("rain")
    public Rain rain;
    
    
    
    public Integer getDt() {
		return dt;
	}



	public void setDt(Integer dt) {
		this.dt = dt;
	}



	public Main getMain() {
		return main;
	}



	public void setMain(Main main) {
		this.main = main;
	}



	public java.util.List<Weather> getWeather() {
		return weather;
	}



	public void setWeather(java.util.List<Weather> weather) {
		this.weather = weather;
	}



	public Clouds getClouds() {
		return clouds;
	}



	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}



	public Wind getWind() {
		return wind;
	}



	public void setWind(Wind wind) {
		this.wind = wind;
	}



	public Sys getSys() {
		return sys;
	}



	public void setSys(Sys sys) {
		this.sys = sys;
	}



	public String getDtTxt() {
		return dtTxt;
	}



	public void setDtTxt(String dtTxt) {
		this.dtTxt = dtTxt;
	}



	public Rain getRain() {
		return rain;
	}



	public void setRain(Rain rain) {
		this.rain = rain;
	}



	@Override
    public String toString() {
        return new ToStringBuilder(this).append("dt", dt).append("main", main).append("weather", weather).append("clouds", clouds).append("wind", wind).append("sys", sys).append("dtTxt", dtTxt).append("rain", rain).toString();
    }

}
