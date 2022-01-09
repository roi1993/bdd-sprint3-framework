package apiTests;
import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GETMortgageAPI {

    String token;

    @Test
    //public void extractTokenForAuthentication() {
        public void testGETAPI__PositiveScenario() {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
         token=given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"duotechb5@gmail.com\",\n" +
                        "  \"password\": \"duotechb5\"\n" +
                        "}").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).extract().asString();

             token=token.substring(67,token.length()-2);

        given().
                header("Authorization",token).
                body("{\n" +
                        "  \"email\": \"duotechb5@gmail.com\",\n" +
                        "  \"password\": \"duotechb5\"\n" +
                        "}").
                when().log().all().
                get("/getmortagage.php ").
                then().log().all().
                assertThat().
                statusCode(200);





    }






}
