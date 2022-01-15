package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;

public class POSTRegisterStepDefs {



    RequestSpecification requestSpecification;
    Response response;

    @Given("the baseURI is initialize and the header {string},{string} is set")
    public void the_header_is_set(String headerKey, String headerValue) {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
      requestSpecification= given().
                header(headerKey, headerValue);


    }
    @When("I set a POST request to {string} endpoint")
    public void i_set_a_post_request_to_endpoint(String endpoint) {

      response= requestSpecification.when().log().all().
                post(endpoint);


    }
    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer int1) {

        response.then().log().all().
                assertThat().
                statusCode(200);
                //body("message", equalTo("You have successfully registered."));


    }



}
