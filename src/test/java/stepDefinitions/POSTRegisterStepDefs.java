package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class POSTRegisterStepDefs {


    int x = 100 + (int) (Math.random() * 900);
    RequestSpecification requestSpecification;
    Response response;

    ////////////////////////////////////////
    //Verify POST \register API
    @Given("the baseURI is initialize and the header {string},{string} is set")
    public void the_header_is_set(String headerKey, String headerValue) {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
      requestSpecification= given().
                header(headerKey, headerValue);


    }
    @When("I set a POST request to {string} endpoint and body requirements is passed")
    public void i_set_a_post_request_to_endpoint(String endpoint) {

      response= requestSpecification.body("{\n" +
              "  \"first_name\": \"Duotech\",\n" +
              "  \"last_name\": \"Academy\",\n" +
              "  \"email\": \"" + x + "duo@gmail.com\",\n" +
              "  \"password\": \"duotech2021\"\n" +
              "}").when().log().all().
                post(endpoint);


    }
    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer int1) {

        response.then().log().all().
                assertThat().
                statusCode(200);

        //response.body("message", equalTo("You have successfully registered.");

    }


    @Given("the baseURI is initialize and the header {string},{string} is set and body requirements is passed")
    public void theBaseURIIsInitializeAndTheHeaderIsSetAndBodyRequirementsIsPassed(String arg0, String arg1) {
    }


    //////////////////////////////////////////////////////////
    //Test PostAPI Negative Scenario Missing Body

    @When("I set a POST request to {string} endpoint")
    public void iSetAPOSTRequestToEndpoint(String endpoint) {
        response= requestSpecification.when().log().all().
                post(endpoint);

    }
//////////////////////////////////////////////////
    //Test PostAPI Negative Scenario With Valid Required Parameters
    @When("I set a POST request to {string} endpoint and body with used credential is passed")
    public void iSetAPOSTRequestToEndpointAndBodyWithUsedCredentialIsPassed(String endpoint) {

        response= requestSpecification.body("{\n" +
                "  \"first_name\": \"Duotech\",\n" +
                "  \"last_name\": \"Academy\",\n" +
                "  \"email\": \" \"duotech@gmail.com\",\n" +
                "  \"password\": \"duotech2021\"\n" +
                "}").when().log().all().
                post(endpoint);
    }



    ///////////////////////////////////////////////////////////




}
