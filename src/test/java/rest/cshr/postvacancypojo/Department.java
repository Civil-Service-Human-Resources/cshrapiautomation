
package rest.cshr.postvacancypojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "disabilityConfidenceLevel",
    "name"
})
public class Department implements Serializable
{

    public Department(String parmList){
        String[] parts = parmList.split(";");
        this.id=Integer.parseInt(parts[0]);
        this.disabilityConfidenceLevel=parts[1];
        this.name = parts[2];
    }
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("disabilityConfidenceLevel")
    private String disabilityConfidenceLevel;
    @JsonProperty("name")
    private String name;
    private final static long serialVersionUID = -5290378287594293746L;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("disabilityConfidenceLevel")
    public String getDisabilityConfidenceLevel() {
        return disabilityConfidenceLevel;
    }

    @JsonProperty("disabilityConfidenceLevel")
    public void setDisabilityConfidenceLevel(String disabilityConfidenceLevel) {
        this.disabilityConfidenceLevel = disabilityConfidenceLevel;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", disabilityConfidenceLevel='" + disabilityConfidenceLevel + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
