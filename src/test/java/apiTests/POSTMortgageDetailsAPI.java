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
