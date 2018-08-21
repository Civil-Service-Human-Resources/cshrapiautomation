
package rest.cshr.postvacancypojo;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "latitude",
    "location",
    "longitude"
})
public class VacancyLocation implements Serializable
{
    public VacancyLocation(String parmList){
        String[] parts = parmList.split("\\|");
            this.latitude = parts[0].equals("")?null:Double.parseDouble(parts[0]);
            this.location = parts[1];
            this.longitude = parts[0].equals("")?null:Double.parseDouble(parts[2]);
    }

    @JsonProperty("latitude")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Object latitude;
    @JsonProperty("location")
    private String location;
    @JsonProperty("longitude")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Object longitude;
      private final static long serialVersionUID = -7183345758056554481L;

    @JsonProperty("latitude")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    public Object getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {

        this.location = location;
    }

    @JsonProperty("longitude")
    public Object getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "VacancyLocation{" +
                "latitude=" + latitude +
                ", location='" + location + '\'' +
                ", longitude=" + longitude +
                '}';
    }
}
