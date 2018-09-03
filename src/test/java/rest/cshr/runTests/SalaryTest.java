package rest.cshr.runTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.cshr.createTestData.CreateTestData;
import rest.cshr.searchpojo.SearchLocation;

import static io.restassured.RestAssured.given;

public class SalaryTest extends CreateTestData {

    Integer filterMinSalary = 30000;
    Integer filterMaxSalary = 40000;

    @Test(description = "Filter jobs with minsal greater than 20k,The jobs to be displayed are " +
            "greater than and equal to 20k if max salary is null in the job and " +
            "jobs with salary ranges between 15k to 25k and 20k to 25k")
    public void filterOnSalaryGreaterThan20K(){

        Response response = given().auth().basic(searchUserName, searchPassword).contentType("application/json")
                .body(this.searchParameters(null,null,null,
                        new SearchLocation(null,5),null,
                        null,filterMinSalary,false))
                .post("/vacancy/search");


        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));

        for(int i=0;
            i<Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString());i++ ){
            Integer salaryMin= response.body().jsonPath().get("vacancies.content[" +i+ "].salaryMin");
            Integer salaryMax= response.body().jsonPath().get("vacancies.content[" +i+ "].salaryMax");

            System.out.println("Above "+ salaryMin +" filtered results are : "+"salaryMin : "+ salaryMin+ " salaryMax: "+salaryMax);

            Assert.assertTrue(areSalaryResultsInGivenFilters(salaryMin,salaryMax ,filterMinSalary,null));

            //Case1: MinSalary = 20000 and MaxSalary = 30000 -- Should Show
            //Case2: MinSalary = 21000 and MaxSalary = 25000 -- Should Show
            //Case3: MinSalary = 22000 and MaxSalary = null  -- Should Show
        }
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(description = "Filter salary between 30k to 40k, The jobs to be displayed are ranges " +
            "25k to 31k, 31k to 36k, 40k to 45k and 32k and jobs such as 29k," +
            "45k, 41k to 45k shouldn't be displayed")
    public void filterOnSalaryBetween30KAnd40K(){
        Response response = given().auth().basic(searchUserName, searchPassword).contentType("application/json")
                .body(this.searchParameters(null,null,null,
                        new SearchLocation(null,5),null,
                        filterMaxSalary,filterMinSalary,false))
                .post("/vacancy/search");
        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));
        for(int i=0;
            i<Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString());i++ ){

            Integer salaryMin= response.body().jsonPath().get("vacancies.content[" +i+ "].salaryMin");
            Integer salaryMax= response.body().jsonPath().get("vacancies.content[" +i+ "].salaryMax");

            System.out.println("Between "+filterMinSalary +" and "+ filterMaxSalary +" filtered results are : "+"salaryMin : "+ salaryMin+ " salaryMax: "+salaryMax);
            //Case1: MinSalary = 28000 and MaxSalary = 31000 -- Should Show
            //Case2: MinSalary = 31000 and MaxSalary = 40000 -- Should Show
            //Case3: MinSalary = 40000 and MaxSalary = 45000  -- Should Show
            //Case4: MinSalary = 32000 and MaxSalary = null  -- Should Show
            Assert.assertTrue(areSalaryResultsInGivenFilters(salaryMin,salaryMax ,filterMinSalary,filterMaxSalary));
        }
        Assert.assertEquals(200,response.getStatusCode());
    }
}
