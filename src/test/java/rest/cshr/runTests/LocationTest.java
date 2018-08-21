package rest.cshr.runTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.cshr.createTestData.CreateTestData;
import rest.cshr.searchpojo.SearchLocation;

import static io.restassured.RestAssured.given;

public class LocationTest extends CreateTestData {

    @Test(description="List all vacancies using location only")
    public void getVacanciesUsingLocation() {
        Response response = given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,null,null, new SearchLocation("london",30),null,null,null,true))
                .post("/vacancy/search");
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(description="List all vacancies using full postcode")
    public void getVacanciesUsingFullPostCode() {
        Response response = given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,null,null, new SearchLocation("bs1 6nb",30),null,null,null,true))
                .post("/vacancy/search");
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(description="List all vacancies using partial postcode")
    public void getVacanciesUsingPartialPostCode() {
        Response response = given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,null,null, new SearchLocation("bs1",30),null,null,null,true))
                .post("/vacancy/search");
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(description="List all vacancies using keyword and location")
    public void listVacanciesUsingKeywordandLocation(){

    }

}
