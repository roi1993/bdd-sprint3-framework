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


    @When("I run the select query")
    public void iRunTheSelectQuery() {
        DBUtility.getQueryResultListOfMaps("Select * from tbl_user where email='tivNN823@videour.com';");

    }

    @Then("I should see the result as")
    public void iShouldSeeTheResultAs() {



    }



}
