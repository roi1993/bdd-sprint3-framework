package apiTests;

import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POSTLoginAPI {
    @Test
    public void testPostAPI__PositiveScenario() {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"110duo@gmail.com\",\n" +
                        "  \"password\": \"duotech2021\"\n" +
                        "}").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("You have successfully logged in."));

    }


    @Test
    public void testPostAPI__bodyMissing() {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        given().
                header("Accept", "application/json").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("status", equalTo(422)).
                body("message",equalTo("Please Fill in all Required Fields!"));

    }

    @Test
    public void testPostAPI__InvalidCredentials() {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"000@gmail.com\",\n" +
                        "  \"password\": \"2021\"\n" +
                        "}").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("Invalid Email Address!"));

    }


    ///Why 200???
    @Test
    public void testPostAPI__InvalidMethodType() {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"110duo@gmail.com\",\n" +
                        "  \"password\": \"duotech2021\"\n" +
                        "}").
                when().log().all().
                delete("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("Page Not Found!"));

    }







}
