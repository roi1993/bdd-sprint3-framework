package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.LoginPage;
import pojos.User;
import utilities.DBUtility;
import utilities.Driver;
import utilities.EndPoints;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EndToEndMultiLayerStepDefs {

    RequestSpecification requestSpecification;
    Response response;
    Map<String,String> row;
    User user = new User("Jason","Mason","jason@gmail.com","jasonMason1234#");

    @Given("The baseURI initialized and header is set to {string} to value of {string}")
    public void the_base_uri_initialized_and_header_is_set_to_to_value_of(String key, String value) {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        requestSpecification = given().
                header(key, value);

    }

    @When("I pass {string} for firstName, {string} for lastName,{string} for email, and {string} for the password to the body and send POST request to {string}")
    public void iPassForFirstNameForLastNameForEmailAndForThePasswordToTheBodyAndSendPOSTRequestTo(String firstName, String lastName, String email, String password, String endpoint) {
        endpoint = EndPoints.REGISTER;

        response = requestSpecification.body("{\n" +
                " \"first_name\":\"" + firstName + "\",\n" +
                " \"last_name\":\"" + lastName + "\",\n" +
                " \"email\":\"" + email+ "\",\n" +
                " \"password\":\"" + password + "\"\n" +
                "}").
                when().log().all().
                post(endpoint);

    }

    @When("I should get message of {string} as verification for registration")
    public void i_should_get_message_of_as_verification_for_registration(String message) {
         response.then().log().all().
                 statusCode(200).
                 body("message",equalTo(message));
    }

    @Then("I should be able to login to DUOBank website through UI with following and my username on DashBoard should be {string}")
    public void i_should_be_able_to_login_to_duo_bank_website_with_through_ui_and_my_username_on_dash_board_should_be(String userName){

        LoginPage loginPage = new LoginPage();
        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/");
        loginPage.email.sendKeys(user.getEmail(), Keys.TAB,user.getPassword(),Keys.TAB,Keys.ENTER);
        //loginPage.password.sendKeys(password);
        Assert.assertEquals(userName,loginPage.userNameOnDashboard.getText());
        Driver.quitDriver();
    }

    @Then("I access to DB and pass {string} for query")
    public void i_access_to_db_and_pass_for_query(String query) throws SQLException {
        DBUtility.createConnection();
        DBUtility.updateQuery(query);
        DBUtility.close();

    }

    @Then("I try to login back to website through API Access by passing above credentials to body and send POST request to {string}")
    public void i_try_to_login_back_to_website_through_api_access_by_passing_following_to_body_and_send_post_request_to(String endpoint) {
        endpoint = EndPoints.LOGIN;
        response = given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"" + user.getEmail() + "\",\n" +
                        "  \"password\": \"" + user.getPassword() + "\"\n" +
                        "}").
                when().log().all().
                post(endpoint);
    }

    @Then("I should see the {string} message on the body and should not be able to login with deleted credentials")
    public void i_should_see_the_message_on_the_body_and_will_not_be_able_to_login_with_deleted_credentials(String message) {
       response.then().log().all().
               assertThat().
               statusCode(200).
               body("message", equalTo(message));
    }


}
