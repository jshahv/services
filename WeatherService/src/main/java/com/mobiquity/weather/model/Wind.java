
package com.mobiquity.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "speed",
    "deg"
})
public class Wind {

    @JsonProperty("speed")
    public Float speed;
    @JsonProperty("deg")
    public Float deg;
    
    

    public Float getSpeed() {
		return speed;
	}



	public void setSpeed(Float speed) {
		this.speed = speed;
	}



	public Float getDeg() {
		return deg;
	}



	public void setDeg(Float deg) {
		this.deg = deg;
	}



	@Override
    public String toString() {
        return new ToStringBuilder(this).append("speed", speed).append("deg", deg).toString();
    }

}
