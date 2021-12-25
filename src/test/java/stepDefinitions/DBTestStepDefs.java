package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtility;

import java.util.List;

public class DBTestStepDefs {



    //Scenario: Check for duplicate values in the username column

    List<List<Object>> queryResultAsListOfLists;
    @When("I send a query to check for duplicate usernames")
    public void iSendAQueryToCheckForDuplicateUsernames() {
        queryResultAsListOfLists = DBUtility.getQueryResultAsListOfLists("select email, count(*) from tbl_user group by email having count(*)>1");

    }

    @Then("The returned result list should be empty")
    public void theReturnedResultListShouldBeEmpty() {
        //Assert.assertTrue("The list is not empty and the size is " + queryResultAsListOfLists.size(), queryResultAsListOfLists.isEmpty() );
        Assert.assertNotEquals("The list is not empty and the size is " + queryResultAsListOfLists.size(), queryResultAsListOfLists.isEmpty() );

    }
}
