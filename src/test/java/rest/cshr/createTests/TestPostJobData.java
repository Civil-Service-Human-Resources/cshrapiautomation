package rest.cshr.createTests;

import com.opera.core.systems.scope.protos.EcmascriptProtos;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import rest.cshr.searchpojo.SearchLocation;
import java.util.ArrayList;
import java.util.List;
import static net.serenitybdd.rest.SerenityRest.given;

@RunWith(SerenityRunner.class)
public class TestPostJobData extends ApiSetup {

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

    @Title("Post a valid job data with all fields matching requirement")
    @Test
    public void postvalidJob() throws Exception {

        Response response = SerenityRest.rest().given().auth().basic("crudusername", "crudpassword").contentType("application/json").body(this.getVacancyFromCsv(1)).when().post("/vacancy/save");
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Title("Get valid data using location only")
    @Test
    public void getvacanciesUsingLocation() {
        Response response = SerenityRest.rest().given().auth().basic("searchusername", "searchpassword").contentType("application/json")
                .body(this.searchParameters(null,null,null,new SearchLocation("london",30),null,null,null,true))
                .post("/vacancy/search");
        Assert.assertEquals(200,response.getStatusCode());
    }
}
