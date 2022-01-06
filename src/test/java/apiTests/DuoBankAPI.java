package apiTests;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DuoBankAPI {


    int x=100+ (int) (Math.random()*900);

    @Test

    public void testPostAPI(){


        baseURI ="http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
                given().
                header("Accept", "application/json").
                        body("{\n" +
                                "  \"first_name\": \"Duotech\",\n" +
                                "  \"last_name\": \"Academy\",\n" +
                                "  \"email\": \""+x+"duo@gmail.com\",\n" +
                                "  \"password\": \"duotech2021\"\n"+
                                "}").
                when(). log().all().
                post("/register.php ").
                then(). log().all().
                assertThat().
                statusCode(200);
    }



    }

