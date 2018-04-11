package rest.cshr;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;

public class JobDataPojo {

   String identifier;
   String applyURL;
   String closingDate;
   String contactDepartment;
   String contactEmail;
   String contactName;
   String contactTelephone;
   String contractTypes;
   String description;
   String displayCscContent;
   String eligibility;
   String governmentOpeningDate;
   String grade;
   String internalOpeningDate;
   String locationOverride;
   String nationalityStatement;
   String numberVacancies;
   String overseasJob;
   String publicOpeningDate;
   String regions;
   String responsibilities;
   Double salaryMax;
   Double salaryMin;
   String salaryOverrideDescription;
   String selectionProcessDetails;
   String shortDescription;
   String title;
   String whatWeOffer;
   String workingHours;
   String workingPatterns;
   Integer locTimes;

   /* String title;
    String description;
    String location;
    Double salaryMax;
    Double salaryMin;
    String numberVacancies;
    String closingDate;
    String publicOpeningDate;
    String governmentOpeningDate;
    String internalOpeningDate;
    String grade;
    String responsibilities;
    String workingHours;
    String contactName;
    String contactDepartment;
    String contactEmail;
    String contactTelephone;
    String eligibility;
    String deptid;
    String deptname;
*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        identifier = RandomStringUtils.randomNumeric(6);
        this.identifier = identifier;
    }

    public String getApplyURL() {
        return applyURL;
    }

    public void setApplyURL(String applyURL) {
        if(applyURL.equalsIgnoreCase("")){
            applyURL=null;
        }
        this.applyURL = applyURL;
    }

    public String getContractTypes() {
        return contractTypes;
    }

    public void setContractTypes(String contractTypes) {
        this.contractTypes = contractTypes;
    }

    public String getDisplayCscContent() {
        return displayCscContent;
    }

    public void setDisplayCscContent(String displayCscContent) {
        this.displayCscContent = displayCscContent;
    }

    public String getLocationOverride() {
        return locationOverride;
    }

    public void setLocationOverride(String locationOverride) {
        if(locationOverride.equalsIgnoreCase("")){
            locationOverride=null;
        }
        this.locationOverride = locationOverride;
    }

    public String getNationalityStatement() {
        return nationalityStatement;
    }

    public void setNationalityStatement(String nationalityStatement) {
        if(nationalityStatement.equalsIgnoreCase("")){
            nationalityStatement = null;
        }
        this.nationalityStatement = nationalityStatement;
    }

    public String getOverseasJob() {
        return overseasJob;
    }

    public void setOverseasJob(String overseasJob) {
        if(overseasJob.equalsIgnoreCase("")){
            overseasJob="false";
        }
        this.overseasJob = overseasJob;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        if(regions.equalsIgnoreCase("")){
            regions=null;
        }
        this.regions = regions;
    }

    public String getSalaryOverrideDescription() {
        return salaryOverrideDescription;
    }

    public void setSalaryOverrideDescription(String salaryOverrideDescription) {
        if(salaryOverrideDescription.equalsIgnoreCase("")){
            salaryOverrideDescription=null;
        }
        this.salaryOverrideDescription = salaryOverrideDescription;
    }

    public String getSelectionProcessDetails() {
        return selectionProcessDetails;
    }

    public void setSelectionProcessDetails(String selectionProcessDetails) {
        this.selectionProcessDetails = selectionProcessDetails;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getWhatWeOffer() {
        return whatWeOffer;
    }

    public void setWhatWeOffer(String whatWeOffer) {
        this.whatWeOffer = whatWeOffer;
    }

    public String getWorkingPatterns() {
        return workingPatterns;
    }

    public void setWorkingPatterns(String workingPatterns) {
        this.workingPatterns = workingPatterns;
    }

    public Double getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Double salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Double getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Double salaryMin) {
        this.salaryMin = salaryMin;
    }

    public String getNumberVacancies() {
        return numberVacancies;
    }

    public void setNumberVacancies(String numberVacancies) {
        this.numberVacancies = numberVacancies;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public String getPublicOpeningDate() {
        return publicOpeningDate;
    }

    public void setPublicOpeningDate(String publicOpeningDate) {
        this.publicOpeningDate = publicOpeningDate;
    }

    public String getGovernmentOpeningDate() {
        return governmentOpeningDate;
    }

    public void setGovernmentOpeningDate(String governmentOpeningDate) {
        this.governmentOpeningDate = governmentOpeningDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactDepartment() {
        return contactDepartment;
    }

    public void setContactDepartment(String contactDepartment) {
        this.contactDepartment = contactDepartment;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }
    public String getInternalOpeningDate() {
        return internalOpeningDate;
    }

    public void setInternalOpeningDate(String internalOpeningDate) {
        this.internalOpeningDate = internalOpeningDate;
    }

    public Integer getLocTimes() {
        return locTimes;
    }

    public void setLocTimes(Integer locTimes) {
        this.locTimes = locTimes;
    }

}
