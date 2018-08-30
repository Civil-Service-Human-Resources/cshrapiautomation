package rest.cshr.runTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.cshr.createTestData.CreateTestData;
import rest.cshr.searchpojo.SearchLocation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import static io.restassured.RestAssured.given;

public class DatesTest extends CreateTestData {

    @Test(description="List all vacancies and check if they are public and not closed")
    public void getVacanciesForPublicDates() {
        Response response = given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,null,null,
                        new SearchLocation(null,5),null,
                        null,null,false))
                .post("/vacancy/search");
        System.out.println("$.vacancies.totalElements value is : "+response.body().jsonPath().get("vacancies.totalElements"));
        Assert.assertEquals(200,response.getStatusCode());

        for(Integer i=0 ;
            i<Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString());i++ ){

            System.out.println("In the loop now "+ i +" "+ Integer.parseInt(response.body().jsonPath().get("vacancies.totalElements").toString()));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

            try {
                Instant publicOpeningDate = formatter.parse(response.body().jsonPath().get("vacancies.content[" + i + "].publicOpeningDate")).toInstant();
                Instant internalOpeningDate = formatter.parse(response.body().jsonPath().get("vacancies.content[" + i + "].internalOpeningDate")).toInstant();
                Instant govOpeningDate = formatter.parse(response.body().jsonPath().get("vacancies.content[" + i + "].governmentOpeningDate")).toInstant();
                Instant closingDate = formatter.parse(response.body().jsonPath().get("vacancies.content[" + i + "].closingDate")).toInstant();
                System.out.println("publicOpeningDate "+ publicOpeningDate+" internalOpeningDate "+internalOpeningDate +
                        " govOpeningDate "+govOpeningDate+ " closingdate "+closingDate);

                Assert.assertTrue(isPublicOpeningDateInThePast(publicOpeningDate) && isClosingDateInTheFuture(closingDate));
            }
            catch(ParseException pe){
                pe.printStackTrace();
            }
        }

    }

}
