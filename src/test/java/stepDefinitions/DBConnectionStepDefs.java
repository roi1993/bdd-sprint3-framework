package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DBConnectionStepDefs {

    @Given("I am connected with the database")
    public void iAmConnectedWithTheDatabase() {
        DBUtility.createConnection();
    }

    @Then("I should be able to see message connection successful")
    public void iShouldBeAbleToSeeMessageConnectionSuccessful() {

        System.out.println("Connection Successful!");
    }


//



}
