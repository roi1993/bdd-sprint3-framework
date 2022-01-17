package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.APIUtils;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import pojos.MortgageApplication;
import pojos.User;
import utilities.EndPoints;


import java.util.List;
import java.util.Map;


public class GETMortgageStepDefs {

    RequestSpecification requestSpecification;
    Response response;
    String token;
    JsonPath jsonPath;
    Map<String, String> row;

    User user = new User("ditote3350@leanrights.com","Janeray2021");

    MortgageApplication mortgageApplication = new MortgageApplication(33483,"Mary","Kennedy","",224854);

    @Given("The baseURI initialized")
    public void theBaseURIInitialized() {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";


    }

    @Given("I logged in as a valid user with following and  I have the JWT token extracted")
    public void i_logged_in_as_a_valid_user_with_following_and_I_have_the_JWT_token_extracted(List<Map<String,String >> data) {
        row = data.get(0);
        token = APIUtils.generateToken(row.get("email"),row.get("password"));

    }


    @When("I set header to {string}, {string}")
    public void i_set_header_to(String key, String value) {
        value = token;
        requestSpecification = given().
                header(key, value);

    }
    @Then("I send GET request to a {string} endpoint")
    public void i_send_get_request_to_a_endpoint(String endPoint) {
      //  endPoint = Endpoints.GET_ALL_MORTGAGES;
        response = requestSpecification.when().log().all().
                get(EndPoints.GET_ALL_MORTGAGES);


    }
//HamcrestMatchers Used
    @Then("I should be able to retrieve all the mortgage applications that belong to user and the total number of applications should be {int}")
    public void i_should_be_able_to_retrieve_all_the_mortgage_applications_that_belong_to_user_and_the_total_number_of_applications_should_be(Integer size) {
       response.then().log().all().
                assertThat().
                statusCode(200).
 //               header("Authorization",token).
                body("mortagage_applications.size()",is(11)).
                body("mortagage_applications.id",hasItems("33492","33490","33483","33482")).
//                body("mortgage_applications.id",hasItem(mortgageApplication.getId())).
                body("mortagage_applications.b_firstName",hasItem(mortgageApplication.getB_FirstName())).
                body("mortagage_applications.b_lastName",hasItem(mortgageApplication.getB_LastName())).
                body("mortagage_applications",not(empty()));
//                body("mortagage_applications",hasKey("total_loan_amount"));
//                body("mortagage_applications.[2]",hasEntry("total_loan_amount",mortgageApplication.getTotalLoanAmount()));
// //             body("mortagage_applications.[10]",not(empty()));
    }

    @When("I send GET request to a {string} endpoint without token number")
    public void iSendGETRequestToAEndpointWithoutTokenNumber(String endpoint) {
        response = given().
                when().log().all().
                get(EndPoints.GET_ALL_MORTGAGES);

    }


    @Then("I should get statusCode of {int} with body message of {string}")
    public void iShouldGetStatusCodeOfWithBodyMessageOf(int statusCode, String message) {
        response.then().log().all().log().all().
                 assertThat().
                 statusCode(statusCode).
                 body("message",equalTo(message));


    }


    @Given("I logged in as an admin with following and  I have the JWT token extracted")
    public void iLoggedInAsAnAdminWithFollowingAndIHaveTheJWTTokenExtracted(List<Map<String,String >> data) {
        row = data.get(0);
        token = APIUtils.generateToken(row.get("email"),row.get("password"));

    }

    @When("I send GET request to a given endpoint")
    public void iSendGETRequestToAGivenEndpoint() {
        response = given().
                header("Authorization", token).
                when().log().all().
                get(EndPoints.GET_ALL_MORTGAGES);

    }


    @Then("I should be able to see the list of all applications with different users")
    public void iShouldBeAbleToSeeTheListOfAllApplicationsWithDifferentUsers() {
        response.then().log().all().
                assertThat().
                statusCode(200).
                body("mortagage_applications.size()", is(297)).
  //              body("mortagage_applications",hasValue("Kurush")).
                body("mortagage_applications.total_loan_amount",hasItems("55766","45017","56141","68922","56067"));
 //               body("mortagage_applications.b_middleName",contains(nullValue()));



    }
}
