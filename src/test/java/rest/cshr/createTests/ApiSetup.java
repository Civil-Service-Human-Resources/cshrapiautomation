package rest.cshr.createTests;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import org.junit.Before;
import rest.cshr.postvacancypojo.VacancyDetails;
import rest.cshr.searchpojo.SearchLocation;
import rest.cshr.searchpojo.SearchQuery;

import java.io.File;
import java.util.List;

public class ApiSetup {
    private File input = new File("/Users/ravigeda/Desktop/Docs/cshr/cshrapitestautomation/src/test/resources/data/JobData.csv");
    @Before
    public void setUp(){
        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost:8080";
        }else {
            RestAssured.baseURI = baseHost;
        }
    }

    public String getVacancyFromCsv(int csvrow) {
        System.out.println("csvtojson started");
        try {
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = mapper.schemaFor(VacancyDetails.class);

            MappingIterator<VacancyDetails> it = mapper.readerFor(VacancyDetails.class).with(schema).readValues(input);
            List<VacancyDetails> all = it.readAll();
            Gson gsonObj = new GsonBuilder().serializeNulls().create();
            return gsonObj.toJson(all.get(csvrow));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String searchParameters(String contractTypes, List<String> department, String keyword, SearchLocation location, String workingPatterns,
                                 Integer maxSalary, Integer minSalary, Boolean overseasJob){
        System.out.println("Building search");
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
}