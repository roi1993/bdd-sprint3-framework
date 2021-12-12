package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.PreapprovalDetailsPage;

public class PreapprovalDetailsStepDefs {

   PreapprovalDetailsPage preapprovalDetailsPage=new PreapprovalDetailsPage();

    @Then("I choose YES for working with realtor")
    public void i_choose_yes_for_working_with_realtor() {
      preapprovalDetailsPage.realtorYES.click();
    }

    @And("I pass realtor Name and Phone Number")
    public void iPassRealtorNameAndPhoneNumber() {
        preapprovalDetailsPage.realtorInformation.sendKeys("blabla");
    }
}
