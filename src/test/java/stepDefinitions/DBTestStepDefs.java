package stepDefinitions;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtility;

import java.sql.SQLException;
import java.util.List;

public class DBTestStepDefs {



    //Scenario: Check for duplicate values in the username column

    List<List<Object>> queryResultAsListOfLists;
    @When("I send a query to check for duplicate email")
    public void iSendAQueryToCheckForDuplicateUsernames() {
        queryResultAsListOfLists = DBUtility.getQueryResultAsListOfLists("select email, count(*) from tbl_user group by email having count(*)>1");

    }

    @Then("The returned result list should be empty")
    public void theReturnedResultListShouldBeEmpty() {
        //Assert.assertTrue("The list is not empty and the size is " + queryResultAsListOfLists.size(), queryResultAsListOfLists.isEmpty() );
        Assert.assertNotEquals("The list is not empty and the size is " + queryResultAsListOfLists.size(), queryResultAsListOfLists.isEmpty() );

    }


    //  Scenario: Verify the column length for first_name column of the tbl_user table
    @When("I update the first_name column with a String with an invalid length of {int} , the update should truncate the length to {int}")
    public void iUpdateTheFirst_nameColumnWithAStringWithAnInvalidLengthOfTheUpdateShouldTruncateTheLengthTo(int length, int truncated) throws SQLException {
        String str = "";
        for (int i = 0; i < length; i++) {
            char ch =  (char)('a' + (int)(Math.random()*102));
            str += ch;
        }

        try{
            DBUtility.updateQuery("update tbl_user set first_name='"+str+"' where id=3324");
        }catch (MysqlDataTruncation ex){
            ex.printStackTrace();
        }


        List<List<Object>> queryResultAsListOfLists = DBUtility.getQueryResultAsListOfLists("select first_name from tbl_user where id=1");
        Integer actualLength = ((String)(queryResultAsListOfLists.get(2).get(0))).length();

        Assert.assertEquals(java.util.Optional.of(truncated), actualLength);


    }






    }

