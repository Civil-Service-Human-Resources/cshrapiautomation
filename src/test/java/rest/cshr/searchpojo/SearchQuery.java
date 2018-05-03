
package rest.cshr.searchpojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "contractTypes",
    "department",
    "keyword",
    "location",
    "workingPatterns",
    "maxSalary",
    "minSalary",
    "overseasJob"
})
public class SearchQuery {

    public SearchQuery(String contractTypes, List<String> department, String keyword, SearchLocation location, String workingPatterns,
                       Integer maxSalary, Integer minSalary, Boolean overseasJob){
        this.contractTypes = contractTypes;
        this.department= department;
        this.keyword = keyword;
        this.location = location;
        this.workingPatterns = workingPatterns;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.overseasJob = overseasJob;

    }
    @JsonProperty("contractTypes")
    private String contractTypes;
    @JsonProperty("department")
    private List<String> department = null;
    @JsonProperty("keyword")
    private String keyword;
    @JsonProperty("location")
    private SearchLocation location;
    @JsonProperty("workingPatterns")
    private String workingPatterns;
    @JsonProperty("maxSalary")
    private Integer maxSalary;
    @JsonProperty("minSalary")
    private Integer minSalary;
    @JsonProperty("overseasJob")
    private Boolean overseasJob;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("contractTypes")
    public String getContractTypes() {
        return contractTypes;
    }

    @JsonProperty("contractTypes")
    public void setContractTypes(String contractTypes) {
        this.contractTypes = contractTypes;
    }

    @JsonProperty("department")
    public List<String> getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(List<String> department) {
        this.department = department;
    }

    @JsonProperty("keyword")
    public String getKeyword() {
        return keyword;
    }

    @JsonProperty("keyword")
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @JsonProperty("location")
    public SearchLocation getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(SearchLocation location) {
        this.location = location;
    }

    @JsonProperty("workingPatterns")
    public String getWorkingPatterns() {
        return workingPatterns;
    }

    @JsonProperty("workingPatterns")
    public void setWorkingPatterns(String workingPatterns) {
        this.workingPatterns = workingPatterns;
    }

    @JsonProperty("maxSalary")
    public Integer getMaxSalary() {
        return maxSalary;
    }

    @JsonProperty("maxSalary")
    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @JsonProperty("minSalary")
    public Integer getMinSalary() {
        return minSalary;
    }

    @JsonProperty("minSalary")
    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    @JsonProperty("overseasJob")
    public Boolean getOverseasJob() {
        return overseasJob;
    }

    @JsonProperty("overseasJob")
    public void setOverseasJob(Boolean overseasJob) {
        this.overseasJob = overseasJob;
    }

}
