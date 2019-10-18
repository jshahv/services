
package com.mobiquity.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pod"
})
public class Sys {

    @JsonProperty("pod")
    public String pod;

    
    
    public String getPod() {
		return pod;
	}



	public void setPod(String pod) {
		this.pod = pod;
	}



	@Override
    public String toString() {
        return new ToStringBuilder(this).append("pod", pod).toString();
    }

}
