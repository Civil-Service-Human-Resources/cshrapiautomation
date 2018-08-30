package rest.cshr.createTestData;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;


public class CreateTestData extends ApiSetup  {

    //Use this to create test data before running the tests. The file 'jobdata.csv' is in resuorces.
    // Use proper syntax in location long, lat when inserting data in csv

    @BeforeTest
    public void postAllJobs() throws Exception {
        for(int i=0;i<getNoOfrowsInCsv();i++) {
            Response response = given().auth().basic(crudUserName, crudPassword).contentType("application/json").body(getVacancyFromCsv(i)).when().post("/vacancy/save");
            Assert.assertEquals(200, response.getStatusCode());
        }
        System.out.println("Creating test data finished");
    }

}
