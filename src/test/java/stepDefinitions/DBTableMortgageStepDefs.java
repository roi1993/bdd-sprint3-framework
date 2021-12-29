package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.FinalTablePage;
import utilities.DBUtility;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class DBTableMortgageStepDefs {

    FinalTablePage finalTablePage = new FinalTablePage();

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


    List<Map<String, Object>> queryResultListOfMaps;
    @When("I send query to check the information entered")
    public void iSendQueryToCheckTheInformationEntered() {
        queryResultListOfMaps = DBUtility.getQueryResultListOfMaps("Select * from tbl_mortagage where realtor_info='John Carry'");

    }

    @Then("I should be able to see my application on DB side")
    public void iShouldBeAbleToSeeMyApplicationOnDBSide() {
        String expectedName = "John Carry";
        String actualName = queryResultListOfMaps.get(0).get("realtor_info").toString();
        Assert.assertEquals(expectedName,actualName);

    }

    @Then("I go to Application List page on the website")
    public void iGoToApplicationListPageOnTheWebsite() {
        finalTablePage.applicationListPageTab.click();

    }

    @Then("The number of applications on UI should match the number of applications on DB")
    public void theNumberOfApplicationsOnUIShouldMatchTheNumberOfApplicationsOnDB() {

        List<WebElement>totalRows = finalTablePage.finalTable.findElements(By.tagName("tr"));
        String expected = "" + (totalRows.size()-1);


        List<Map<String, Object>> queryResultListOfMaps = DBUtility.getQueryResultListOfMaps("select b_firstName,  count(*) from tbl_mortagage group by b_firstName having b_firstName='Mary'");
        String actual = queryResultListOfMaps.get(0).get("count(*)").toString();

        Assert.assertEquals(expected,actual);







    }

    List<Map<String, Object>> queryOfMaps;
    @When("I change b_lastName to {string} on DB on the first row and It should reflect on UI side")
    public void iChangeB_lastNameToOnDBonTheFirstRowAndItShouldReflectOnUISide(String lastName) {
         queryOfMaps = DBUtility.getQueryResultListOfMaps("update tbl_mortagage set b_lastName='"+lastName+"' where id=33483");

         List<WebElement>totalRows = finalTablePage.finalTable.findElements(By.tagName("tr"));
        String actual = totalRows.get(1).getText().substring(0,4);
        Assert.assertEquals(lastName,actual);



    }
}
