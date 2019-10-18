
package com.mobiquity.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "main",
    "description",
    "icon"
})
public class Weather {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("main")
    public String main;
    @JsonProperty("description")
    public String description;
    @JsonProperty("icon")
    public String icon;

    
    
    public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMain() {
		return main;
	}



	public void setMain(String main) {
		this.main = main;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getIcon() {
		return icon;
	}



	public void setIcon(String icon) {
		this.icon = icon;
	}



	@Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("main", main).append("description", description).append("icon", icon).toString();
    }

}
