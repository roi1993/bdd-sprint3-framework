package apiTests;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POSTMortgageDetailsAPI{

    @Test
    public void testMortgageDetailsAPIPositiveScenario_returnSpecificMortgageAppDetailsForLoggedInUser(){

 
        String id;

        int id = 661;

        //String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9sb2NhbGhvc3RcL2xvYW5cL2FwaSIsImF1ZCI6Imh0dHA6XC9cL2xvY2FsaG9zdFwvbG9hblwvYXBpIiwiaWF0IjoxNjQxNzU2MjUyLCJleHAiOjE2NDE3NTk4NTIsImRhdGEiOnsidXNlcl9pZCI6IjM1NjgiLCJ0eXBlIjoiMSJ9fQ.fTaj5x1d0InRA1di6Pop8jj3T6J6tTDmt_ziruZj5Cc";


        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        JsonPath jsonPath = given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"duotechb5@gmail.com\",\n" +
                        "  \"password\": \"duotechb5\"\n" +
                        "}").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("You have successfully logged in.")).extract().jsonPath();

        String token = jsonPath.getString("token");

        JsonPath jsonPath1 = given().
                header("Authorization",token).
                when().log().all().
                get("/getmortagage.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("success",equalTo(1)).extract().jsonPath();

        List<Object> mortagage_applications = jsonPath1.getList("mortagage_applications");
        List listofID = jsonPath1.get("mortagage_applications.id");
        id = listofID.get(6).toString();

        JsonPath jsonPath2 = given().
                header("Authorization",token).
                body("{\n" +
                        " \"id\":\""+id+"\"\n" +
                        "}").
                when().log().all().
                post("/mortagagedetails.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("success",equalTo(0)).extract().jsonPath();

        List<Object> single_application = jsonPath1.getList("single_application");
        System.out.println(single_application);



    }



    @Test
    public void testMortgageDetailsAPI_UserCredential(){


int id=778;

        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        JsonPath jsonPath = given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"791duo@gmail.com\",\n" +
                        "  \"password\": \"duotech2021\"\n" +
                        "}").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("You have successfully logged in.")).extract().jsonPath();

        String token = jsonPath.getString("token");

        JsonPath jsonPath1 = given().
                header("Authorization",token).
                body("{\n" +
                        " \"id\":\""+id+"\"\n" +
                        "}").
                when().log().all().
                post("/mortagagedetails.php").
                then().log().all().

                        statusCode(200).
                        body("success",equalTo(1)).extract().jsonPath();


         Map<Object,String>  single_application = jsonPath2.getMap("single_application");

        Assert.assertEquals("Seema Kuhic, hyman.dach@yahoo.com",single_application.get("realtor_info"));
        Assert.assertEquals("812274",single_application.get("est_purchase_price"));
        Assert.assertEquals("Kerstin",single_application.get("b_firstName"));
        Assert.assertEquals("Haag",single_application.get("b_lastName"));



    }


    @Test
    public void testMortgageDetailsAPINegativeScenario_withInvalidId(){

        String id = "12300";

        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        JsonPath jsonPath = given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"duotechb5@gmail.com\",\n" +
                        "  \"password\": \"duotechb5\"\n" +
                        "}").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("You have successfully logged in.")).extract().jsonPath();

        String token = jsonPath.getString("token");

        given().
                header("Authorization",token).
                when().log().all().
                get("/getmortagage.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("success",equalTo(1));


         given().
                header("Authorization",token).
                body("{\n" +
                        " \"id\":\""+id+"\"\n" +
                        "}").
                when().log().all().
                post("/mortagagedetails.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("single_application",equalTo(null));


    }




}
