package apiTests;

import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POSTMortgageDetailsAPI{

    @Test
    public void testMortgageDetailsAPI_returnSpecificMortgageAppDetailsForLoggedInUser(){

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
                body("{\n" +
                        " \"id\":\""+id+"\"\n" +
                        "}").
                when().log().all().
                get("/mortagagedetails.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("success",equalTo(0)).extract().jsonPath();

        List<Object> single_application = jsonPath1.getList("single_application");
        System.out.println(single_application);



    }



    @Test
    public void testMortgageDetailsAPI_User(){


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

        List<Object> single_application = jsonPath1.getList("single_application");
        System.out.println(single_application);



    }






}
