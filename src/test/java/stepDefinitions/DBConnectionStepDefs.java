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


    List<String> actualColumnNames;
    @When("I retrieve column name")
    public void iRetrieveColumnName() {
       actualColumnNames= DBUtility.getColumnNames("select * from tbl_user ;");


    }


    @Then("It should be the following")
    public void itShouldBeTheFollowing(List<String> expected) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualColumnNames).isEqualTo(expected);
        DBUtility.close();
        softAssertions.assertAll();

    }
}
