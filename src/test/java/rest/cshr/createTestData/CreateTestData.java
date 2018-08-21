package rest.cshr.createTestData;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;


public class CreateTestData extends ApiSetup  {

    @BeforeSuite
    public static void postAllJobs() throws Exception {
        for(int i=0;i<getNoOfrowsInCsv();i++) {
            Response response = given().auth().basic("crudusername", "crudpassword").contentType("application/json").body(getVacancyFromCsv(i)).when().post("/vacancy/save");
            Assert.assertEquals(200, response.getStatusCode());
        }
        System.out.println("Creating test data finished");
    }

}
