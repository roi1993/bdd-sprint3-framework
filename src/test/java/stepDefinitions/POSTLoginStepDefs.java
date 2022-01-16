package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POSTLoginStepDefs {

    RequestSpecification requestSpecification;
    Response response;



    @Given("the baseURI initialize and the header {string},{string} is set")
    public void theBaseURIInitializeAndTheHeaderIsSet(String headerKey, String headerValue) {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        requestSpecification= given().
                header(headerKey, headerValue);


    }

    @When("I set a POST request to login {string} endpoint and body requirements is passed")
    public void iSetAPOSTRequestToLoginEndpointAndBodyRequirementsIsPassed(String endpoint) {

        response= requestSpecification.body("{\n" +
                "  \"email\": \"110duo@gmail.com\",\n" +
                "  \"password\": \"duotech2021\"\n" +
                "}").when().log().all().
                post(endpoint);

    }


    @Then("status code should be {int}")
    public void statusCodeShouldBe(int arg0) {
        response.then().log().all().
                assertThat().
                statusCode(200);
    }

    /////////////////////////////////////
    //Test PostAPI Negative Scenario Missing Body

    @When("I set a POST request to login {string} endpoint")
    public void iSetAPOSTRequestToLoginEndpoint(String endpoint) {
        response= requestSpecification.when().log().all().
                post(endpoint);
    }

    ///////////////////////////////////////////
    ////Test PostAPI With Invalid Credentials
    @When("I set a POST request to {string} endpoint and body with invalid credential is passed")
    public void iSetAPOSTRequestToEndpointAndBodyWithInvalidCredentialIsPassed(String endpoint) {
        response= requestSpecification.body("{\n" +
                "  \"email\": \"000@gmail.com\",\n" +
                "  \"password\": \"2021\"\n" +
                "}").when().log().all().
                post(endpoint);

    }

    /////////////////////////////////////
    ///Test PostAPI With Invalid Method Type
    @When("I set a DELETE request to {string} endpoint and body with valid credential is passed")
    public void iSetADeleteRequestToEndpointAndBodyWithInvalidCredentialIsPassed(String endpoint) {
        response= requestSpecification.body("{\n" +
                "  \"email\": \"110duo@gmail.com\",\n" +
                "  \"password\": \"duotech2021\"\n" +
                "}").when().log().all().
                delete(endpoint);

    }


    //Jenkins check
}
