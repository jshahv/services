
package com.mobiquity.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lon"
})
public class Coord {

    @JsonProperty("lat")
    public Float lat;
    @JsonProperty("lon")
    public Float lon;
    
    

    public Float getLat() {
		return lat;
	}



	public void setLat(Float lat) {
		this.lat = lat;
	}



	public Float getLon() {
		return lon;
	}



	public void setLon(Float lon) {
		this.lon = lon;
	}



	@Override
    public String toString() {
        return new ToStringBuilder(this).append("lat", lat).append("lon", lon).toString();
    }

}
