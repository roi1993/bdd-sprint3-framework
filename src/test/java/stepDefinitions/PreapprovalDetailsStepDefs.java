package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.PreapprovalDetailsPage;

public class PreapprovalDetailsStepDefs {


    PreapprovalDetailsPage preapprovalDetailsPage=new PreapprovalDetailsPage();
    HomePage homePage=new HomePage();

    @Then("I click on Mortgage Application")
    public void i_click_on_mortgage_application() throws InterruptedException {
        Thread.sleep(3000);
      homePage.mortgageApplicationButton.click();
    }
}
