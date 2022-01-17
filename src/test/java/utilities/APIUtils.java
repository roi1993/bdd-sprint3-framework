package utilities;

import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class APIUtils {



    public static String generateToken(String username, String password){

        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";

        JsonPath jsonPath = given().
                body("{\n" +
                        "    \"email\":\"" + username + "\",\n" +
                        "    \"password\":\"" + password + "\"\n" +
                        "}").
                when().post(EndPoints.LOGIN).
                then().
                statusCode(200).extract().jsonPath();


        return jsonPath.getString("token");

    }


}
