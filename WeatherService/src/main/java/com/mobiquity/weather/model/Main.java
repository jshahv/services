
package com.mobiquity.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "temp_min",
    "temp_max",
    "pressure",
    "sea_level",
    "grnd_level",
    "humidity",
    "temp_kf"
})
public class Main {

    @JsonProperty("temp")
    public Float temp;
    @JsonProperty("temp_min")
    public Float tempMin;
    @JsonProperty("temp_max")
    public Float tempMax;
    @JsonProperty("pressure")
    public Integer pressure;
    @JsonProperty("sea_level")
    public Integer seaLevel;
    @JsonProperty("grnd_level")
    public Float grndLevel;
    @JsonProperty("humidity")
    public Integer humidity;
    @JsonProperty("temp_kf")
    public Integer tempKf;

    
    
    public Float getTemp() {
		return temp;
	}



	public void setTemp(Float temp) {
		this.temp = temp;
	}



	public Float getTempMin() {
		return tempMin;
	}



	public void setTempMin(Float tempMin) {
		this.tempMin = tempMin;
	}



	public Float getTempMax() {
		return tempMax;
	}



	public void setTempMax(Float tempMax) {
		this.tempMax = tempMax;
	}



	public Integer getPressure() {
		return pressure;
	}



	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}



	public Integer getSeaLevel() {
		return seaLevel;
	}



	public void setSeaLevel(Integer seaLevel) {
		this.seaLevel = seaLevel;
	}



	public Float getGrndLevel() {
		return grndLevel;
	}



	public void setGrndLevel(Float grndLevel) {
		this.grndLevel = grndLevel;
	}



	public Integer getHumidity() {
		return humidity;
	}



	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}



	public Integer getTempKf() {
		return tempKf;
	}



	public void setTempKf(Integer tempKf) {
		this.tempKf = tempKf;
	}



	@Override
    public String toString() {
        return new ToStringBuilder(this).append("temp", temp).append("tempMin", tempMin).append("tempMax", tempMax).append("pressure", pressure).append("seaLevel", seaLevel).append("grndLevel", grndLevel).append("humidity", humidity).append("tempKf", tempKf).toString();
    }

}
