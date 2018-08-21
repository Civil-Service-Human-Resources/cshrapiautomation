
package rest.cshr.postvacancypojo;

import java.io.Serializable;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "identifier",
        "personalSpecification",
        "applyURL",
        "closingDate",
        "contactDepartment",
        "contactEmail",
        "contactName",
        "contactTelephone",
        "contractTypes",
        "department",
        "description",
        "displayCscContent",
        "eligibility",
        "governmentOpeningDate",
        "grade",
        "internalOpeningDate",
        "locationOverride",
        "nationalityStatement",
        "numberVacancies",
        "overseasJob",
        "publicOpeningDate",
        "regions",
        "responsibilities",
        "salaryMax",
        "salaryMin",
        "salaryOverrideDescription",
        "selectionProcessDetails",
        "shortDescription",
        "title",
        "whatWeOffer",
        "workingHours",
        "workingPatterns",
        "vacancyLocations",
        "atsVendorIdentifier",
        "active",
        "lengthOfEmployment"
})
public class VacancyDetails implements Serializable {

    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("personalSpecification")
    private String personalSpecification;
    @JsonProperty("applyURL")
    private String applyURL;
    @JsonProperty("closingDate")
    private String closingDate;
    @JsonProperty("contactDepartment")
    private String contactDepartment;
    @JsonProperty("contactEmail")
    private String contactEmail;
    @JsonProperty("contactName")
    private String contactName;
    @JsonProperty("contactTelephone")
    private String contactTelephone;
    @JsonProperty("contractTypes")
    private String contractTypes;
    @JsonProperty("department")
    private Department department;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayCscContent")
    private Boolean displayCscContent;
    @JsonProperty("eligibility")
    private String eligibility;
    @JsonProperty("governmentOpeningDate")
    private String governmentOpeningDate;
    @JsonProperty("grade")
    private String grade;
    @JsonProperty("internalOpeningDate")
    private String internalOpeningDate;
    @JsonProperty("locationOverride")
    private Object locationOverride;
    @JsonProperty("nationalityStatement")
    private String nationalityStatement;
    @JsonProperty("numberVacancies")
    private Integer numberVacancies;
    @JsonProperty("overseasJob")
    private Boolean overseasJob;
    @JsonProperty("publicOpeningDate")
    private String publicOpeningDate;
    @JsonProperty("regions")
    private Object regions;
    @JsonProperty("responsibilities")
    private String responsibilities;
    @JsonProperty("salaryMax")
    private Integer salaryMax;
    @JsonProperty("salaryMin")
    private Integer salaryMin;
    @JsonProperty("salaryOverrideDescription")
    private Object salaryOverrideDescription;
    @JsonProperty("selectionProcessDetails")
    private String selectionProcessDetails;
    @JsonProperty("shortDescription")
    private String shortDescription;
    @JsonProperty("title")
    private String title;
    @JsonProperty("vacancyLocations")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private VacancyLocation[] vacancyLocations = null;
    @JsonProperty("whatWeOffer")
    private String whatWeOffer;
    @JsonProperty("workingHours")
    private String workingHours;
    @JsonProperty("workingPatterns")
    private String workingPatterns;
    @JsonProperty("atsVendorIdentifier")
    private String atsVendorIdentifier;
    private final static long serialVersionUID = -606114393627405107L;
    @JsonProperty("active")
    private String active;
    @JsonProperty("lengthOfEmployment")
    private String lengthOfEmployment;

    public void setLengthOfEmployment(String lengthOfEmployment) {
        if(lengthOfEmployment ==" "||lengthOfEmployment==""){
            lengthOfEmployment=null;
        }
        this.lengthOfEmployment = lengthOfEmployment;
    }


    public String getLengthOfEmployment() {
        return lengthOfEmployment;
    }
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @JsonProperty("atsVendorIdentifier")
    public String getAtsVendorIdentifier() {
        return atsVendorIdentifier;
    }

    @JsonProperty("atsVendorIdentifier")
    public void setAtsVendorIdentifier(String atsVendorIdentifier) {
        this.atsVendorIdentifier = atsVendorIdentifier;
    }

    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        String id = String.valueOf(new Random().nextInt(1000000));
        this.identifier = id;
    }

    @JsonProperty("personalSpecification")
    public String getPersonalSpecification() {
        return personalSpecification;
    }

    @JsonProperty("personalSpecification")
    public void setPersonalSpecification(String personalSpecification) {
        this.personalSpecification = personalSpecification;
    }

    @JsonProperty("applyURL")
    public String getApplyURL() {
        return applyURL;
    }

    @JsonProperty("applyURL")
    public void setApplyURL(String applyURL) {
        this.applyURL = applyURL;
    }

    @JsonProperty("closingDate")
    public String getClosingDate() {
        return closingDate;
    }

    @JsonProperty("closingDate")
    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    @JsonProperty("contactDepartment")
    public String getContactDepartment() {
        return contactDepartment;
    }

    @JsonProperty("contactDepartment")
    public void setContactDepartment(String contactDepartment) {
        this.contactDepartment = contactDepartment;
    }

    @JsonProperty("contactEmail")
    public String getContactEmail() {
        return contactEmail;
    }

    @JsonProperty("contactEmail")
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @JsonProperty("contactName")
    public String getContactName() {
        return contactName;
    }

    @JsonProperty("contactName")
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @JsonProperty("contactTelephone")
    public String getContactTelephone() {
        return contactTelephone;
    }

    @JsonProperty("contactTelephone")
    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    @JsonProperty("contractTypes")
    public String getContractTypes() {
        return contractTypes;
    }

    @JsonProperty("contractTypes")
    public void setContractTypes(String contractTypes) {
        this.contractTypes = contractTypes;
    }

    @JsonProperty("department")
    public Department getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(Department department) {
        this.department = department;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("displayCscContent")
    public Boolean getDisplayCscContent() {
        return displayCscContent;
    }

    @JsonProperty("displayCscContent")
    public void setDisplayCscContent(Boolean displayCscContent) {
        this.displayCscContent = displayCscContent;
    }

    @JsonProperty("eligibility")
    public String getEligibility() {
        return eligibility;
    }

    @JsonProperty("eligibility")
    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    @JsonProperty("governmentOpeningDate")
    public String getGovernmentOpeningDate() {
        return governmentOpeningDate;
    }

    @JsonProperty("governmentOpeningDate")
    public void setGovernmentOpeningDate(String governmentOpeningDate) {
        this.governmentOpeningDate = governmentOpeningDate;
    }

    @JsonProperty("grade")
    public String getGrade() {
        return grade;
    }

    @JsonProperty("grade")
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @JsonProperty("internalOpeningDate")
    public String getInternalOpeningDate() {
        return internalOpeningDate;
    }

    @JsonProperty("internalOpeningDate")
    public void setInternalOpeningDate(String internalOpeningDate) {
        this.internalOpeningDate = internalOpeningDate;
    }

    @JsonProperty("locationOverride")
    public Object getLocationOverride() {
        return locationOverride;
    }

    @JsonProperty("locationOverride")
    public void setLocationOverride(Object locationOverride) {
        this.locationOverride = locationOverride;
    }

    @JsonProperty("nationalityStatement")
    public String getNationalityStatement() {
        return nationalityStatement;
    }

    @JsonProperty("nationalityStatement")
    public void setNationalityStatement(String nationalityStatement) {
        this.nationalityStatement = nationalityStatement;
    }

    @JsonProperty("numberVacancies")
    public Integer getNumberVacancies() {
        return numberVacancies;
    }

    @JsonProperty("numberVacancies")
    public void setNumberVacancies(Integer numberVacancies) {
        this.numberVacancies = numberVacancies;
    }

    @JsonProperty("overseasJob")
    public Boolean getOverseasJob() {
        return overseasJob;
    }

    @JsonProperty("overseasJob")
    public void setOverseasJob(Boolean overseasJob) {
        this.overseasJob = overseasJob;
    }

    @JsonProperty("publicOpeningDate")
    public String getPublicOpeningDate() {
        return publicOpeningDate;
    }

    @JsonProperty("publicOpeningDate")
    public void setPublicOpeningDate(String publicOpeningDate) {
        this.publicOpeningDate = publicOpeningDate;
    }

    @JsonProperty("regions")
    public Object getRegions() {
        return regions;
    }

    @JsonProperty("regions")
    public void setRegions(Object regions) {
        if(regions ==" "||regions==""){
            regions=null;
        }
        this.regions = regions;
    }

    @JsonProperty("responsibilities")
    public String getResponsibilities() {
        return responsibilities;
    }

    @JsonProperty("responsibilities")
    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    @JsonProperty("salaryMax")
    public Integer getSalaryMax() {
        return salaryMax;
    }

    @JsonProperty("salaryMax")
    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    @JsonProperty("salaryMin")
    public Integer getSalaryMin() {
        return salaryMin;
    }

    @JsonProperty("salaryMin")
    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }

    @JsonProperty("salaryOverrideDescription")
    public Object getSalaryOverrideDescription() {
        return salaryOverrideDescription;
    }

    @JsonProperty("salaryOverrideDescription")
    public void setSalaryOverrideDescription(Object salaryOverrideDescription) {
        if(salaryOverrideDescription ==" "||salaryOverrideDescription==""){
            salaryOverrideDescription=null;
        }
        this.salaryOverrideDescription = salaryOverrideDescription;
    }

    @JsonProperty("selectionProcessDetails")
    public String getSelectionProcessDetails() {
        return selectionProcessDetails;
    }

    @JsonProperty("selectionProcessDetails")
    public void setSelectionProcessDetails(String selectionProcessDetails) {
        this.selectionProcessDetails = selectionProcessDetails;
    }

    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("vacancyLocations")
    public VacancyLocation[] getVacancyLocations() {
        return vacancyLocations;
    }

    @JsonProperty("vacancyLocations")
    public void setVacancyLocations(VacancyLocation[] vacancyLocations) {
        this.vacancyLocations = vacancyLocations;
    }

    @JsonProperty("whatWeOffer")
    public String getWhatWeOffer() {
        return whatWeOffer;
    }

    @JsonProperty("whatWeOffer")
    public void setWhatWeOffer(String whatWeOffer) {
        this.whatWeOffer = whatWeOffer;
    }

    @JsonProperty("workingHours")
    public String getWorkingHours() {
        return workingHours;
    }

    @JsonProperty("workingHours")
    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    @JsonProperty("workingPatterns")
    public String getWorkingPatterns() {
        return workingPatterns;
    }

    @JsonProperty("workingPatterns")
    public void setWorkingPatterns(String workingPatterns) {
        this.workingPatterns = workingPatterns;
    }

    @Override
    public String toString() {
        return "VacancyDetails{" +
                "identifier='" + identifier + '\'' +
                ", personalSpecification='" + personalSpecification + '\'' +
                ", applyURL='" + applyURL + '\'' +
                ", closingDate='" + closingDate + '\'' +
                ", contactDepartment='" + contactDepartment + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactTelephone='" + contactTelephone + '\'' +
                ", contractTypes='" + contractTypes + '\'' +
                ", department=" + department +
                ", description='" + description + '\'' +
                ", displayCscContent=" + displayCscContent +
                ", eligibility='" + eligibility + '\'' +
                ", governmentOpeningDate='" + governmentOpeningDate + '\'' +
                ", grade='" + grade + '\'' +
                ", internalOpeningDate='" + internalOpeningDate + '\'' +
                ", locationOverride=" + locationOverride +
                ", nationalityStatement='" + nationalityStatement + '\'' +
                ", numberVacancies=" + numberVacancies +
                ", overseasJob=" + overseasJob +
                ", publicOpeningDate='" + publicOpeningDate + '\'' +
                ", regions=" + regions +
                ", responsibilities='" + responsibilities + '\'' +
                ", salaryMax=" + salaryMax +
                ", salaryMin=" + salaryMin +
                ", salaryOverrideDescription=" + salaryOverrideDescription +
                ", selectionProcessDetails='" + selectionProcessDetails + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", title='" + title + '\'' +
                ", vacancyLocations=" + Arrays.toString(vacancyLocations) +
                ", whatWeOffer='" + whatWeOffer + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ", workingPatterns='" + workingPatterns + '\'' +
                '}';
    }
}
