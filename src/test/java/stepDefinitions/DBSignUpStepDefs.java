package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.LoginPage;
import pages.SignInLinkPage;
import pages.SignUpButtonPage;
import pages.SignUpLinkPage;
import utilities.ConfigReader;
import utilities.DBUtility;
import utilities.Driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBSignUpStepDefs {


    SignUpLinkPage signUpLinkPage=new SignUpLinkPage();
    SignUpButtonPage signUpButtonPage=new SignUpButtonPage();
    Map<String,String > expectedMap;

    @When("I sign up with following info")
    public void iSignUpWithFollowingInfo(List<Map<String,String >> dataTable) throws InterruptedException {
      expectedMap=dataTable.get(0);

        signUpButtonPage.firstName.sendKeys(expectedMap.get("First Name"));
        signUpButtonPage.lastName.sendKeys(expectedMap.get("Last Name"));
        signUpButtonPage.emailAddress.sendKeys(expectedMap.get("Email"));
        signUpButtonPage.password.sendKeys(expectedMap.get("Password"));

        Thread.sleep(2000);
        signUpButtonPage.clickOnSignUpButton();

    }

    @And("The database should also have correct record in it")
    public void theDatabaseShouldAlsoHaveCorrectRecordInIt() throws SQLException {
        String expectedFirstName= expectedMap.get("First Name");
        String expectedLastName= expectedMap.get("Last Name");
        String expectedEmail= expectedMap.get("Email");
        String expectedPassword= expectedMap.get("Password");

        String queryEmail="Select * from tbl_user where email='"+expectedEmail+"'";
        List<Map<String, Object>> queryResultListOfMaps = DBUtility.getQueryResultListOfMaps(queryEmail);
  //      System.out.println(queryResultListOfMaps);
        Map<String,Object>actualMap=queryResultListOfMaps.get(0);

        String actualEmail=(String)(actualMap.get("email"));
        String actualPassword=(String)(actualMap.get("password"));
        String actualFirstName=(String)(actualMap.get("first_name"));
        String actualLastName=(String)(actualMap.get("last_name"));


        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(expectedEmail).isEqualTo(actualEmail);
        String expectedPasswordMD5 = DigestUtils.md5Hex(expectedPassword);
        softAssertions.assertThat(expectedPasswordMD5).isEqualTo(actualPassword);
        softAssertions.assertThat(expectedFirstName).isEqualTo(actualFirstName);
        softAssertions.assertThat(expectedLastName).isEqualTo(actualLastName);

        softAssertions.assertAll();



//        Assert.assertEquals(expectedFirstName,actualFirstName);
//        Assert.assertEquals(expectedLastName,actualLastName);
//        Assert.assertEquals(expectedEmail,actualEmail);
//        Assert.assertEquals(expectedPassword,actualPassword);

        DBUtility.updateQuery("delete from tbl_user where email='"+expectedEmail +"'");
        DBUtility.close();

    }


    @Given("I am connected to the DB")
    public void iAmConnectedToTheDB() {
        DBUtility.createConnection();
    }

    @When("I add a new user to the database with the following info")
    public void iAddANewUserToTheDatabaseWithTheFollowingInfo(List<Map<String,String>> data) throws SQLException {
        Map<String,String> expectedMap = data.get(0);

        String passwordAsMD5 = DigestUtils.md5Hex(expectedMap.get("Password"));
        System.out.println(passwordAsMD5);
        String phone = "123";
        String image = "assets/images/profile-pics/head";
        String type = "2";
        String created = "2021-12-22 02:38:30";
        String modified = "2";
        String zoneId= "2";
        String churchId = "2";
        String countryId = "2";
        String active = "2";
        String query = "INSERT INTO tbl_user (email, password, first_name, last_name, phone, image, type, created_at, modified_at, zone_id, church_id, country_id, active) values " +
                "('"+expectedMap.get("Email")+"','"+passwordAsMD5+"','"+expectedMap.get("First Name")+"','"+expectedMap.get("Last Name")+"'," +
                "'"+phone+"','"+image+"','"+type+"','"+created+"','"+modified+"','"+zoneId+"','"+churchId+"','"+countryId+"','"+active+"')";
        DBUtility.updateQuery(query);
        System.out.println(query);


    }

    @Then("I should be able to log in with the {string} as email and {string} as password on the UI")
    public void iShouldBeAbleToLogInWithTheAsEmailAndAsPasswordOnTheUI(String email, String password) throws SQLException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();

        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();

        String expectedUsername = "Nick James";
        String actualUsername = loginPage.userNameOnDashboard.getText();
        Assert.assertEquals(expectedUsername,actualUsername);

        DBUtility.updateQuery("delete from users where email='"+email+"'");
        DBUtility.close();
    }

    @Given("I click on Sign Up Blue Link and I am connected to DB")
    public void iClickOnSignUpBlueLinkAndIAmConnectedToDB() {
        signUpLinkPage.signUpLinkClick();
        DBUtility.createConnection();
    }


    String firstName1;
    String lastName1;
    String email1;
    String password1;

    @When("I sign up with the following info {string} {string} {string}  {string}")
    public void iSignUpWithTheFollowingInfo(String firstName, String lastName, String email, String password) {

        firstName1 = firstName;
        lastName1 = lastName;
        email1 = email;
        password1 = password;

        signUpButtonPage.firstName.sendKeys(firstName);
        signUpButtonPage.lastName.sendKeys(lastName);
        signUpButtonPage.emailAddress.sendKeys(email);
        signUpButtonPage.password.sendKeys(password);
        signUpButtonPage.signUpButton.click();

    }

    @And("The database should also have the correct info without spaces")
    public void theDatabaseShouldAlsoHaveTheCorrectInfoWithoutSpaces() throws SQLException {
        String query = "select * from tbl_user where email='"+email1.trim()+"'";
        List<Map<String,Object>> result = DBUtility.getQueryResultListOfMaps(query);
        Map<String,Object> actualMap = result.get(0);

        String actualEmail=(String)(actualMap.get("email"));
        String actualPassword=(String)(actualMap.get("password"));
        String actualFirstName=(String)(actualMap.get("first_name"));
        String actualLastName=(String)(actualMap.get("last_name"));

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(email1.trim()).isEqualTo(actualEmail);
        String expectedPasswordMD5 = DigestUtils.md5Hex(password1);
        softAssertions.assertThat(expectedPasswordMD5.trim()).isEqualTo(actualPassword);
        softAssertions.assertThat(firstName1.trim()).isEqualTo(actualFirstName);
        softAssertions.assertThat(lastName1.trim()).isEqualTo(actualLastName);

        softAssertions.assertAll();
        DBUtility.updateQuery("delete from users where email='"+email1.trim()+"'");
        DBUtility.close();

    }


}
