package rest.cshr.runTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.cshr.createTestData.CreateTestData;
import rest.cshr.searchpojo.SearchLocation;

import static io.restassured.RestAssured.given;

public class SalaryTest extends CreateTestData {

    @Test(description = "The jobs to be displayed are greater than and equal to 20k if max salary is null in the job and " +
            "jobs with salary ranges between 15k to 25k and 20k to 25k")
    public void filterOnSalaryGreaterThan20K(){

        Response response = given().auth().basic(searchUserName, searchPassword).contentType("application/json")
                .body(this.searchParameters(null,null,null,
                        new SearchLocation(null,5),null,
                        null,20000,false))
                .post("/vacancy/search");

        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));

        for(int i=Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements"));

            i<=Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements"));i++ ){
            Integer salaryMin= response.body().jsonPath().get(".vacancies.content[" +i+ "].salaryMin");
            Integer salaryMax= response.body().jsonPath().get(".vacancies.content[" +i+ "].salaryMax");

            //Case1: MinSalary = 20000 and MaxSalary = 30000 -- Should Show
            //Case2: MinSalary = 21000 and MaxSalary = 25000 -- Should Show
            //Case3: MinSalary = 22000 and MaxSalary = null  -- Should Show
        }

        Assert.assertTrue(Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString())==1);
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(description = "The jobs to be displayed are ranges 25k to 31k, 31k to 36k, 40k to 45k and 32k and jobs such as 29k," +
            "45k, 41k to 45k shouldn't be displayed")
    public void filterOnSalaryBetween30KAnd40K(){
        Response response = given().auth().basic(searchUserName, searchPassword).contentType("application/json")
                .body(this.searchParameters(null,null,null,
                        new SearchLocation(null,5),null,
                        40000,30000,false))
                .post("/vacancy/search");
        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));
        for(int i=Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements"));

            i<=Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements"));i++ ){
            Integer salaryMin= response.body().jsonPath().get(".vacancies.content[" +i+ "].salaryMin");
            Integer salaryMax= response.body().jsonPath().get(".vacancies.content[" +i+ "].salaryMax");

            //Case1: MinSalary = 25000 and MaxSalary = 31000 -- Should Show
            //Case2: MinSalary = 31000 and MaxSalary = 40000 -- Should Show
            //Case3: MinSalary = 40000 and MaxSalary = 45000  -- Should Show
            //Case4: MinSalary = 32000 and MaxSalary = null  -- Should Show

        }
        Assert.assertTrue(Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString())==2);
        Assert.assertEquals(200,response.getStatusCode());
    }

    public void areSalaryResultsInGivenFilters(Integer salMin, Integer salMax, Integer FilSalMin, Integer FilSalMax ){

    }
}
