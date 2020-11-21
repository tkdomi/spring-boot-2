package pl.hqbusiness.springboot2.week5.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "location",
    "current"
})
public class Weather {
  @JsonProperty("location")
  private Location location;
  @JsonProperty("current")
  private Current current;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  @JsonProperty("location")
  public Location getLocation() {
    return location;
  }

  @JsonProperty("location")
  public void setLocation(Location location) {
    this.location = location;
  }

  @JsonProperty("current")
  public Current getCurrent() {
    return current;
  }

  @JsonProperty("current")
  public void setCurrent(Current current) {
    this.current = current;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
