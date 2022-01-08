package apiTests;

import org.junit.Assert;
import org.junit.Test;
import utilities.Driver;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class POSTRegisterAPI {


    int x = 100 + (int) (Math.random() * 900);

    //POST REGISTER
    @Test
    public void testPostAPI__PositiveScenarioWithValidRequiredParameters() {


        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"first_name\": \"Duotech\",\n" +
                        "  \"last_name\": \"Academy\",\n" +
                        "  \"email\": \"" + x + "duo@gmail.com\",\n" +
                        "  \"password\": \"duotech2021\"\n" +
                        "}").
                when().log().all().
                post("/register.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("You have successfully registered."));

    }

    //POST REGISTER
    @Test
    public void testPostAPI__negativeSceanrioMissingBody(){
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";


        given().
                header("Accept", "application/json").
                when().log().all().
                post("/register.php").
                then().log().all().
                statusCode(200).
                body("status", equalTo(422));


    }


    //POST REGISTER
    @Test
    public void testPostAPI__NegativeScenarioWithValidRequiredParameters() {


        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"first_name\": \"Duotech\",\n" +
                        "  \"last_name\": \"Academy\",\n" +
                        "  \"email\": \"duotech@gmail.com\",\n" +
                        "  \"password\": \"duotech2021\"\n" +
                        "}").
                when().log().all().
                post("/register.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("This E-mail already in use!")).
                body("status",equalTo(422));

    }



}

