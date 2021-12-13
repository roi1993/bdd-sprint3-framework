package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.SignUpButtonPage;
import utilities.Driver;
import utilities.ExcelUtils;

import java.util.List;
import java.util.Map;

public class SignUpButtonStepDefs {

    SignUpButtonPage signUpButtonPage = new SignUpButtonPage();

    //Scenario #1
    @When("I pass this information")
    public void i_pass_this_information(List<Map<String,String>> data) {
        Map<String, String> row = data.get(0);

        signUpButtonPage.firstName.sendKeys(row.get("First Name"));
        signUpButtonPage.lastName.sendKeys(row.get("Last Name"));
        signUpButtonPage.emailAddress.sendKeys(row.get("Email Address"));
        signUpButtonPage.password.sendKeys(row.get("Password"));

    }

    @When("I click on Sign Up Button")
    public void i_click_on_sign_up_button() {
        signUpButtonPage.clickOnSignUpButton();

    }

    @Then("I should land on back on Login main Page")
    public void i_should_land_on_back_on_login_main_page() throws InterruptedException {

        Thread.sleep(2000);
        String expected = "Welcome Back, Automation Testers!";
        String actual = signUpButtonPage.backToLogInPage.getText();
        Assert.assertEquals(expected,actual);

    }


    @Then("I should get error message")
    public void i_should_get_error_message() {
       Assert.assertTrue(Driver.getDriver().getPageSource().contains(signUpButtonPage.firstName.getAttribute("validationMessage")));

    }


    @Then("I should get error message on email address field")
    public void i_should_get_error_message_on_email_address_field() {
        String expectedErrorMsg = "Please enter a part following '@'.'l.Butcher@' is incomplete.";
        String actualErrorMsg = signUpButtonPage.emailAddressLineErrorMsg.getText();
     //   Assert.assertEquals(expectedErrorMsg,actualErrorMsg);
        Assert.assertTrue(actualErrorMsg.contains(expectedErrorMsg));
    }


    @When("I leave a blank on field first name and last name")
    public void i_leave_a_blank_on_field_first_name_and_last_name() {
        signUpButtonPage.firstName.sendKeys(Keys.TAB,Keys.TAB);
    }

    @When("I only enter email address and password")
    public void i_only_enter_email_address_and_password() {
        signUpButtonPage.emailAddress.sendKeys("doseman3c@lulu.com");
        signUpButtonPage.password.sendKeys("NY0vsFpQ4");

    }

    @Then("I should get error message on First Name Field")
    public void i_should_get_error_message_on_first_name_field() {
        String expectedErrorMessage = "Please fill out this field.";
        String actualErrorMessage = signUpButtonPage.firstName.getAttribute("validationMessage");
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @When("I enter following information on required field on sign up")
    public void i_enter_following_information_on_required_field_on_sign_up(List<Map<String,String>> data) {
        Map<String, String> row = data.get(0);
        signUpButtonPage.firstName.sendKeys(row.get("FIRST NAME"));
        signUpButtonPage.lastName.sendKeys(row.get("LAST NAME"));
        signUpButtonPage.emailAddress.sendKeys(row.get("EMAIL"));
        signUpButtonPage.password.sendKeys(row.get("PASSWORD"));

    }

    @When("I click on Sign Up Arrow on the right")
    public void i_click_on_sign_up_arrow_on_the_right() {
       signUpButtonPage.signUpArrow.click();
    }

    @Then("I should get Registration Successful Message on sign up page")
    public void i_should_get_registration_successful_message_on_sign_up_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Registration Successfull"));
    }

    @When("I enter information from Excel File named {string} for required fields")
    public void i_enter_information_from_excel_file_named_for_required_fields(String path) throws Throwable {

        ExcelUtils excelUtils = new ExcelUtils(path,"Data1");

        List<Map<String, String>> dataAsMap = excelUtils.getDataAsMap();
        Throwable exception = null;

        for (int i = 0; i < dataAsMap.size(); i++) {
            Map<String, String> row = dataAsMap.get(i);

            if(row.get("Execute").equalsIgnoreCase("test")){
                //need to fix it, grabbing all column together
                //need to check assertion, everything passingg???

              try {
                  signUpButtonPage.firstName.sendKeys(row.get("First_name"));
                  signUpButtonPage.lastName.sendKeys(row.get("Last_name"), Keys.TAB);
                  signUpButtonPage.emailAddress.sendKeys(row.get("Email"), Keys.TAB);
                  signUpButtonPage.password.sendKeys(row.get("Password"), Keys.TAB);

                  excelUtils.setCellData("PASSED", "Status", i + 1);

              }catch(Throwable e){
                  exception = e;
                  excelUtils.setCellData("FAILED","Status",i+1);

              }

            }else{
                excelUtils.setCellData("SKIPPED","Status",i+1);

            }

        }
        throw exception;


    }





}
