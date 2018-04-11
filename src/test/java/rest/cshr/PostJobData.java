package rest.cshr;

import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.SerenityRest.given;

@RunWith(SerenityRunner.class)
public class PostJobData extends ApiSetup {

   /* @Title("Post a valid job data with all fields matching requirement")
    @Test
    public void postJobData() throws Exception {
        int excelRows = excelDataAsJson().size();
        for(int i=0;i<excelRows;i++){
            Response statuscode = SerenityRest.rest().given().contentType("application/json").body(excelDataAsJson().get(i)).when().post("/vacancy");
            statuscode.getBody().prettyPrint();
            Assert.assertTrue(statuscode.body().asString().contains("probationary period are eligible to apply for"));
            JsonPath evaluatorForJsonPath = statuscode.jsonPath();
            String location = evaluatorForJsonPath.get("location");
            Assert.assertEquals(location, excelDataAsJson().get(i).get("location").getAsString());
        }
    }

    @Title("Post an invalid job  with a missing mandatory field-location")
    @Test
    public void postInvalidJobData() throws Exception {
        Response response = SerenityRest.rest().given().contentType("application/json").body(excelDataAsJson().get(1).remove("location")).when().post("/vacancy");
        Assert.assertEquals(400, response.getStatusCode());

    }

    @Title("Get valid data using location only")
    @Test
    public void getUsingLocation(){
        Response response = SerenityRest.rest().given().contentType("application/json").get("http://localhost:8080/vacancy/search/location/london");
        System.out.println(response.asString());
        int sizeOfRes = response.getBody().jsonPath().get("content.size()");
        List<Map<String,String>> jk = response.getBody().jsonPath().get("content");
        Assert.assertEquals("london".toLowerCase(), jk.get(1).get("location").toLowerCase());
    }*/

   @Test
   public void postJobs() throws Exception{
       for(int i=0;i<csvToJsonJob().size();i++){
           Response res = SerenityRest.rest().given().contentType("application/json").body(csvToJsonJob().get(i).toString()).when().post("/vacancy");
           System.out.println("Response status code is : "+res.body().jsonPath().get("identifier"));
       }
   }
}
