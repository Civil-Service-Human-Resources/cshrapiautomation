package rest.cshr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.junit.Before;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiSetup {
    @Before
    public void setUp(){
        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost:8080";
        }else {
            RestAssured.baseURI = baseHost;
        }
    }

    public ArrayList<JSONObject> csvToJsonJob() throws Exception{
        File input = new File("src/test/resources/data/jobData.csv");
        File deptInput = new File("src/test/resources/data/deptData.csv");
        File locInput = new File("src/test/resources/data/locationdata.csv");
        CsvSchema jobDataSchema = CsvSchema.builder()
                .addColumn( "identifier",CsvSchema.ColumnType.STRING)
                .addColumn( "applyURL",CsvSchema.ColumnType.STRING)
                .addColumn( "closingDate",CsvSchema.ColumnType.STRING)
                .addColumn( "contactDepartment",CsvSchema.ColumnType.STRING)
                .addColumn( "contactEmail",CsvSchema.ColumnType.STRING)
                .addColumn( "contactName",CsvSchema.ColumnType.STRING)
                .addColumn( "contactTelephone",CsvSchema.ColumnType.STRING)
                .addColumn( "contractTypes",CsvSchema.ColumnType.STRING)
                .addColumn( "description",CsvSchema.ColumnType.STRING)
                .addColumn( "displayCscContent",CsvSchema.ColumnType.STRING)
                .addColumn( "eligibility",CsvSchema.ColumnType.STRING)
                .addColumn( "governmentOpeningDate",CsvSchema.ColumnType.STRING)
                .addColumn( "grade",CsvSchema.ColumnType.STRING)
                .addColumn( "internalOpeningDate",CsvSchema.ColumnType.STRING)
                .addColumn( "locationOverride",CsvSchema.ColumnType.STRING)
                .addColumn( "nationalityStatement",CsvSchema.ColumnType.STRING)
                .addColumn( "numberVacancies",CsvSchema.ColumnType.STRING)
                .addColumn( "overseasJob",CsvSchema.ColumnType.STRING)
                .addColumn( "publicOpeningDate",CsvSchema.ColumnType.STRING)
                .addColumn( "regions",CsvSchema.ColumnType.STRING)
                .addColumn( "responsibilities",CsvSchema.ColumnType.STRING)
                .addColumn( "salaryMax",CsvSchema.ColumnType.NUMBER)
                .addColumn( "salaryMin", CsvSchema.ColumnType.NUMBER)
                .addColumn( "salaryOverrideDescription",CsvSchema.ColumnType.STRING)
                .addColumn( "selectionProcessDetails",CsvSchema.ColumnType.STRING)
                .addColumn( "shortDescription",CsvSchema.ColumnType.STRING)
                .addColumn( "title",CsvSchema.ColumnType.STRING)
                .addColumn( "whatWeOffer",CsvSchema.ColumnType.STRING)
                .addColumn( "workingHours",CsvSchema.ColumnType.STRING)
                .addColumn( "workingPatterns",CsvSchema.ColumnType.STRING)
                .addColumn("locTimes")
                .build();

        CsvSchema deptSchema = CsvSchema.builder()
                .addColumn("id",CsvSchema.ColumnType.NUMBER)
                .addColumn("disabilityConfidenceLevel",CsvSchema.ColumnType.STRING)
                .addColumn("name",CsvSchema.ColumnType.STRING)
                .build();
        CsvSchema locationSchema = CsvSchema.builder()
                .addColumn("location",CsvSchema.ColumnType.STRING)
                .addColumn("longitude",CsvSchema.ColumnType.NUMBER)
                .addColumn("latitude",CsvSchema.ColumnType.NUMBER)
                .build();
        CsvMapper csvMapper = new CsvMapper();
        CsvMapper deptCsvMapper = new CsvMapper();
        CsvMapper locationMapper = new CsvMapper();

        // Read data from CSV file
        List<Object> readAll = csvMapper.readerFor(JobDataPojo.class).with(jobDataSchema).readValues(input).readAll();
        List<Object> deptReadAll = deptCsvMapper.readerFor(DepartmentPoJo.class).with(deptSchema).readValues(deptInput).readAll();
        List<Object> locReadAll = locationMapper.readerFor(VacancyLocationPoJo.class).with(locationSchema).readValues(locInput).readAll();

        ObjectMapper jobDataMapper = new ObjectMapper();
        ObjectMapper deptDataMapper = new ObjectMapper();
        ObjectMapper locDataMapper = new ObjectMapper();

        ArrayList<JSONObject> jObj = new ArrayList<JSONObject>();
        for(int i=0;i<Integer.parseInt(jobDataMapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll.size()));i++){
            jObj.add(new JSONObject(jobDataMapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll.get(i))));
            ArrayList<JSONObject> locationList = new ArrayList<>();
            jObj.get(i).get("locTimes");
            for(int ii=0;ii<Integer.parseInt(locDataMapper.writerWithDefaultPrettyPrinter().writeValueAsString(locReadAll.size()));ii++){
                locationList.add(ii, new JSONObject(locDataMapper.writerWithDefaultPrettyPrinter().writeValueAsString(locReadAll.get(ii))));
            }
            jObj.get(i).put("department",new JSONObject(deptDataMapper.writerWithDefaultPrettyPrinter().writeValueAsString(deptReadAll.get(i))));
            jObj.get(i).put("vacancyLocations",locationList.toArray());
        }
        return jObj;
    }

  /*  public List<JsonObject> excelDataAsJson() throws Exception {
                File source = new File(System.getProperty("user.dir") + "/src/test/resources/data/*.xlsx");
                FileInputStream fis = new FileInputStream(source);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheetOne = wb.getSheetAt(0);
                int lastCell = sheetOne.getRow(0).getLastCellNum();
                int noOfRows = sheetOne.getPhysicalNumberOfRows();
                List<JsonObject> excelRows = new ArrayList<>();
                for(int rows=0;rows<noOfRows-1;rows++){
                        JsonObject dataConvert = new JsonObject();
                        String subHead = null;
                        JsonObject dept= new JsonObject() ;
                        for (int i = 0; i < lastCell; i++) {
                                if(sheetOne.getRow(0).getCell(i).toString().contains("/")){ //Splits heading and converts to
                                        List<String> headSplit = Arrays.asList(sheetOne.getRow(0).getCell(i).toString().split("/"));
                                        if(headSplit.get(1).equals("id")){
                                                dept.addProperty(headSplit.get(1), sheetOne.getRow(rows + 1).getCell(i).getNumericCellValue());
                                            }
                                        else {
                                                dept.addProperty(headSplit.get(1), sheetOne.getRow(rows + 1).getCell(i).toString());
                                            }
                                        if(subHead!=null){

                                                    }
                                        else{
                                                subHead = headSplit.get(0);
                                            }
                                    }
                                else{
                                        if(sheetOne.getRow(0).getCell(i).toString().contains("sal")||sheetOne.getRow(0).getCell(i).toString().contains("acancies")){
                                                dataConvert.addProperty(sheetOne.getRow(0).getCell(i).toString(), (int)sheetOne.getRow(rows + 1).getCell(i).getNumericCellValue());
                                            }else {
                                                dataConvert.addProperty(sheetOne.getRow(0).getCell(i).toString(), sheetOne.getRow(rows + 1).getCell(i).toString());
                                            }
                                    }

                                    }
                        dataConvert.add(subHead,dept);
                        excelRows.add(dataConvert);
                    }
                fis.close();
                return excelRows;
            }*/
}