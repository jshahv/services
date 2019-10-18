
package com.mobiquity.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "coord",
    "country",
    "population",
    "timezone",
    "sunrise",
    "sunset"
})
public class City {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("coord")
    public Coord coord;
    @JsonProperty("country")
    public String country;
    @JsonProperty("population")
    public Integer population;
    @JsonProperty("timezone")
    public Integer timezone;
    @JsonProperty("sunrise")
    public Integer sunrise;
    @JsonProperty("sunset")
    public Integer sunset;

    
    
    public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Coord getCoord() {
		return coord;
	}



	public void setCoord(Coord coord) {
		this.coord = coord;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public Integer getPopulation() {
		return population;
	}



	public void setPopulation(Integer population) {
		this.population = population;
	}



	public Integer getTimezone() {
		return timezone;
	}



	public void setTimezone(Integer timezone) {
		this.timezone = timezone;
	}



	public Integer getSunrise() {
		return sunrise;
	}



	public void setSunrise(Integer sunrise) {
		this.sunrise = sunrise;
	}



	public Integer getSunset() {
		return sunset;
	}



	public void setSunset(Integer sunset) {
		this.sunset = sunset;
	}



	@Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("coord", coord).append("country", country).append("population", population).append("timezone", timezone).append("sunrise", sunrise).append("sunset", sunset).toString();
    }

}
