package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import utilities.DBUtility;

import java.util.List;

public class DBTableMortgageStepDefs {

    List<String> actualColumn;
    @When("I retrieve the column name from tbl_mortgage table")
    public void i_retrieve_the_column_name_from_tbl_mortgage_table() {
        actualColumn = DBUtility.getColumnNames("select * from tbl_mortagage;");

    }

    @Then("it should contain the following")
    public void it_should_contain_the_following(List<String> expectedColumn) {
        SoftAssertions softAssertions = new SoftAssertions();
         softAssertions.assertThat(actualColumn).isEqualTo(expectedColumn);

         DBUtility.close();
         softAssertions.assertAll();

    }
}
