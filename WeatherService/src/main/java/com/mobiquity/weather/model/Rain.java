
package com.mobiquity.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "3h"
})
public class Rain {

    @JsonProperty("3h")
    public Float _3h;

    
    
    public Float get_3h() {
		return _3h;
	}



	public void set_3h(Float _3h) {
		this._3h = _3h;
	}



	@Override
    public String toString() {
        return new ToStringBuilder(this).append("_3h", _3h).toString();
    }

}
