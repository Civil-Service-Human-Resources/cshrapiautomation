package rest.cshr.createTestData;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import rest.cshr.postvacancypojo.VacancyDetails;
import rest.cshr.searchpojo.SearchLocation;
import rest.cshr.searchpojo.SearchQuery;

import java.io.File;
import java.time.Instant;
import java.util.List;

public class ApiSetup {
    private static File input = new File("src/test/resources/data/JobData.csv");

    protected String searchUserName = "searchusername";
    protected String searchPassword = "searchpassword";
    protected String crudUserName = "crudusername";
    protected String crudPassword = "crudpassword";

    @BeforeSuite
    public void setUp(){
        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost:8080";
        }else {
            RestAssured.baseURI = baseHost;
        }
    }

    public static String getVacancyFromCsv(int csvrow) {
        try {
            System.out.println("Current csv row reading is: "+csvrow);
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = mapper.schemaFor(VacancyDetails.class);
            MappingIterator<VacancyDetails> it = mapper.readerFor(VacancyDetails.class).with(schema).readValues(input);
            List<VacancyDetails> all = it.readAll();
            Gson gsonObj = new GsonBuilder().serializeNulls().create();
            System.out.println("The json to send is : "+ gsonObj.toJson(all.get(csvrow)));
            return gsonObj.toJson(all.get(csvrow));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   public static int getNoOfrowsInCsv(){
       try {
           CsvMapper mapper = new CsvMapper();
           CsvSchema schema = mapper.schemaFor(VacancyDetails.class);
           MappingIterator<VacancyDetails> it = mapper.readerFor(VacancyDetails.class).with(schema).readValues(input);
           List<VacancyDetails> all = it.readAll();
           System.out.println("No of rows in csv is: "+ all.size());
           return all.size();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return 0;
   }

    public String searchParameters(String contractTypes, List<String> department, String keyword, SearchLocation location, String workingPatterns,
                                 Integer maxSalary, Integer minSalary, Boolean overseasJob){
        try {
            ObjectMapper mapper = new ObjectMapper();
            SearchQuery searchQuery = new SearchQuery(contractTypes,department,keyword,location,workingPatterns,maxSalary,minSalary,overseasJob);
            String jsonInString = mapper.writeValueAsString(searchQuery);
            return jsonInString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isPublicOpeningDateInThePast(Instant publicdate){
        if(publicdate.isBefore(Instant.now())){
            return true;
        }
        return false;
    }

    public boolean isClosingDateInTheFuture(Instant closingDate){
        if(closingDate.isAfter(Instant.now())){
            return true;
        }
        return false;
    }
}