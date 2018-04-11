package rest.cshr;

public class DepartmentPoJo {
    Integer id;
    String disabilityConfidenceLevel;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisabilityConfidenceLevel() {
        return disabilityConfidenceLevel;
    }

    public void setDisabilityConfidenceLevel(String disabilityConfidenceLevel) {
        if(disabilityConfidenceLevel==""){
            disabilityConfidenceLevel=null;
        }
        this.disabilityConfidenceLevel = disabilityConfidenceLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
