package apiTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GETMortgageAPI {

    @Test
    public void testGETMortgageAPI_logInWithUser() {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        JsonPath jsonPath = given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"ditote3350@leanrights.com\",\n" +
                        "  \"password\": \"Janeray2021\"\n" +
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


        Assert.assertEquals(10,mortagage_applications.size());



    }





}
