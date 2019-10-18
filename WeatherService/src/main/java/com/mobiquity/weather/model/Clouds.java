
package com.mobiquity.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "all"
})
public class Clouds {

    @JsonProperty("all")
    public Integer all;

    public Integer getAll() {
		return all;
	}

	public void setAll(Integer all) {
		this.all = all;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this).append("all", all).toString();
    }

}
