package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EndToEndMultiLayerStepDefs {

    @Given("The baseURI initialized and header is set to {string} to value of {string}")
    public void the_base_uri_initialized_and_header_is_set_to_to_value_of(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I pass following to the body and send POST request to {string}")
    public void i_pass_following_to_the_body_and_send_post_request_to(String string, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @When("I should get message of {string} as verification for registration")
    public void i_should_get_message_of_as_verification_for_registration(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should be able to login to DUOBank website with through UI and my username on DashBoard should be {string}")
    public void i_should_be_able_to_login_to_duo_bank_website_with_through_ui_and_my_username_on_dash_board_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I access to DB and pass {string} for query")
    public void i_access_to_db_and_pass_for_query(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I try to login back to website through API Access by passing following to body and send POST request to {string}")
    public void i_try_to_login_back_to_website_through_api_access_by_passing_following_to_body_and_send_post_request_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should see the {string} message on the body and will not be able to login with deleted credentials")
    public void i_should_see_the_message_on_the_body_and_will_not_be_able_to_login_with_deleted_credentials(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
