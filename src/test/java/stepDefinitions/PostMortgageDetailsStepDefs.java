package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utilities.APIUtils;
import utilities.EndPoints;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostMortgageDetailsStepDefs {


    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse body;
    String token;
    JsonPath jsonPath;
    Map<String, String> row;
    String id;

    @Given("The baseURI initialized and I logged in as an admin with following and  I have the JWT token extracted")
    public void the_base_uri_initialized_and_i_logged_in_as_an_admin_with_following_and_i_have_the_jwt_token_extracted(List<Map<String,String >> data) {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        row = data.get(0);
        token = APIUtils.generateToken(row.get("email"),row.get("password"));
    }
//HamcrestMatchers
    @When("I send GET request to {string} endpoint, I will retrieve all the mortgage applications under user account")
    public void i_send_get_request_to_endpoint_i_will_retrieve_all_the_mortgage_applications_under_user_account(String endpoint) {
        endpoint = EndPoints.GET_ALL_MORTGAGES;
         body = given().
                header("Authorization", token).
                when().log().all().
                get(endpoint).
                then().log().all().
                assertThat().
                statusCode(200).
                body("success", equalTo(1)).
                body("mortagage_applications.size()", is(297));

    }

    @Then("I extract specific id from the list of applications")
    public void i_extract_specific_id_from_the_list_of_applications() {
//        List<Object> mortagage_applications = jsonPath.getList("mortagage_applications");
//        List listofID = jsonPath.get("mortagage_applications.id");
        id = "661";
    }

    @Then("I pass extracted id setting header key to {string} and value to token number")
    public void i_pass_extracted_id_setting_header_key_to_and_value_to_token_number(String key) {
        requestSpecification = given().
                header(key, token).
                body("{\n" +
                        " \"id\":\"" + id + "\"\n" +
                        "}");
    }

    @Then("I send POST request to {string} endpoint")
    public void i_send_post_request_to_endpoint(String endpoint) {
        endpoint = EndPoints.GET_MORTGAGE_DETAILS;
        response = requestSpecification.when().log().all().
                post(endpoint);

    }
//HamCrestMatchers
    @Then("I should be able to retrieve the single application under the id that was passed")
    public void i_should_be_able_to_retrieve_the_single_application_under_the_id_that_was_passed() {
        response.then().log().all().
                 assertThat().
                statusCode(200).
                body("success",equalTo(1)).
                body("single_application.id",is("661")).
                body("single_application.realtor_info",equalTo("Seema Kuhic, hyman.dach@yahoo.com")).
                body("single_application", hasValue("Checking/Savings (most recent bank statement)")).
                body("single_application",hasEntry("purpose_loan","Purchase a Home"));



    }
}
