package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignInLinkPage;
import pages.SignUpButtonPage;
import utilities.DBUtility;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class DBSignUp {

    SignInLinkPage signInLinkPage=new SignInLinkPage();
    SignUpButtonPage signUpButtonPage=new SignUpButtonPage();
    Map<String,String > expectedMap;

    @Given("I am on Sign Up Page and I am connected to DB")
    public void iAmOnSignUpPageAndIAmConnectedToDB() {
     signInLinkPage.clickOnSignInLink();
     DBUtility.createConnection();

    }


    @When("I sign up with following info")
    public void iSignUpWithFollowingInfo(List<Map<String,String >> dataTable) {
      expectedMap=dataTable.get(0);

        signUpButtonPage.firstName.sendKeys(expectedMap.get("First Name"));
        signUpButtonPage.lastName.sendKeys(expectedMap.get("Last Name"));
        signUpButtonPage.emailAddress.sendKeys(expectedMap.get("Email"));
        signUpButtonPage.password.sendKeys(expectedMap.get("Password"));
        signUpButtonPage.clickOnSignUpButton();

    }

    @Then("I should land on home page")
    public void iShouldLandOnHomePage() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Loan Application"));

    }

    @And("The database should also have correct record in it")
    public void theDatabaseShouldAlsoHaveCorrectRecordInIt() {
        String expectedFirstName= expectedMap.get("First Name");
        String expectedLastName= expectedMap.get("Last Name");
        String expectedEmail= expectedMap.get("Email");
        String expectedPassword= expectedMap.get("Password");

        String query="Select * from tbl_user where email='"+expectedFirstName+"'";
        List<Map<String, Object>> queryResultListOfMaps = DBUtility.getQueryResultListOfMaps(query);
        Map<String ,Object>actualMap=queryResultListOfMaps.get(0);

        String actualFirstName=(String)(actualMap.get("first_name"));
        String actualLastName=(String)(actualMap.get("last_name"));
        String actualEmail=(String)(actualMap.get("email"));
        String actualPassword=(String)(actualMap.get("password"));

        Assert.assertEquals(expectedFirstName,actualFirstName);
        Assert.assertEquals(expectedLastName,actualLastName);
        Assert.assertEquals(expectedEmail,actualEmail);
        Assert.assertEquals(expectedPassword,actualPassword);

    }
}
