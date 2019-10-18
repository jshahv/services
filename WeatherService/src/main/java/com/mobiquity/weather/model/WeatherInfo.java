
package com.mobiquity.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cod",
    "message",
    "cnt",
    "list",
    "city"
})
public class WeatherInfo {

    @JsonProperty("cod")
    public String cod;
    @JsonProperty("message")
    public Integer message;
    @JsonProperty("cnt")
    public Integer cnt;
    @JsonProperty("list")
    public java.util.List<com.mobiquity.weather.model.List> list = null;
    @JsonProperty("city")
    public City city;

    
    
    public String getCod() {
		return cod;
	}



	public void setCod(String cod) {
		this.cod = cod;
	}



	public Integer getMessage() {
		return message;
	}



	public void setMessage(Integer message) {
		this.message = message;
	}



	public Integer getCnt() {
		return cnt;
	}



	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}



	public java.util.List<com.mobiquity.weather.model.List> getList() {
		return list;
	}



	public void setList(java.util.List<com.mobiquity.weather.model.List> list) {
		this.list = list;
	}



	public City getCity() {
		return city;
	}



	public void setCity(City city) {
		this.city = city;
	}



	@Override
    public String toString() {
        return new ToStringBuilder(this).append("cod", cod).append("message", message).append("cnt", cnt).append("list", list).append("city", city).toString();
    }

}
