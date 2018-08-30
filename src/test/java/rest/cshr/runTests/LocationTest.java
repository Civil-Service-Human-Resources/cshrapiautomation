package rest.cshr.runTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.cshr.createTestData.CreateTestData;
import rest.cshr.searchpojo.SearchLocation;

import static io.restassured.RestAssured.given;

public class LocationTest extends CreateTestData {

    @Test(description="List all vacancies using location only and no overseas, the location(york) entered has no jobs with in 5 miles")
    public void getVacanciesUsingLocation() {
        Response response = given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,null,null,
                                            new SearchLocation("york",5),null,
                                            null,null,false))
                .post("/vacancy/search");
        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));
        Assert.assertTrue(Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString())==0);
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(description="List all vacancies including overseas jobs filtering on location (york), " +
            "should show one job as there is one overseas job and no jobs in 5 miles of the location")
    public void listVacanciesIncOverseas(){
        Response response = given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,
                        null,null,
                        new SearchLocation("york",5),
                        null,null,null,true))
                .post("/vacancy/search");
        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));
        Assert.assertTrue(Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString())==1);
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(description="List all vacancies using full postcode(post code used related swansea)")
    public void getVacanciesUsingFullPostCode() {
        Response response = given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,null,null,
                        new SearchLocation("SA1 1NX",5),null,
                        null,null,false))
                .post("/vacancy/search");
        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));
        Assert.assertTrue(Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString())==1);
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(description="List all vacancies using partial postcode, partial post code ralead to bristol")
    public void getVacanciesUsingPartialPostCode() {
        Response response = given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,null,null,
                        new SearchLocation("bs1",5),null,
                        null,null,false))
                .post("/vacancy/search");
        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));
        Assert.assertTrue(Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString())==1);
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Test(description="List all vacancies using keyword and location bristol")
    public void listVacanciesUsingKeywordandLocation(){
        Response response = given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,null,"program",
                        new SearchLocation("bristol",5),null,
                        null,null,false))
                .post("/vacancy/search");
        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));
        Assert.assertTrue(Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString())==1);
        Assert.assertEquals(200,response.getStatusCode());
    }

}
