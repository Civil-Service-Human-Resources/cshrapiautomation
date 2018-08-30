package rest.cshr.runTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.cshr.createTestData.CreateTestData;
import rest.cshr.searchpojo.SearchLocation;

import static io.restassured.RestAssured.given;

public class KeywordTest extends CreateTestData {

    @Test(description="List all vacancies using keyword only")
    public void listVacanciesUsingKeyword(){
        Response response = given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,null,"program",
                        new SearchLocation(null,30),null,null,null,true))
                .post("/vacancy/search");
        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));
        Assert.assertEquals(200,response.getStatusCode());
    }

}
