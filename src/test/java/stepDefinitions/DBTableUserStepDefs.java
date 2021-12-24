package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import utilities.DBUtility;

import java.util.List;

public class DBTableUserStepDefs {
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
