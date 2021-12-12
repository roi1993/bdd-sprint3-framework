package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.PersonalInformationPage;
import pages.PreapprovalDetailsPage;

public class PersonalInformationStepDefs {

    PreapprovalDetailsPage preapprovalDetailsPage=new PreapprovalDetailsPage();
    PersonalInformationPage personalInformationPage= new PersonalInformationPage();

    @Then("I enter estimated purchase price")
    public void iEnterEstimatedPurchasePrice() {
        preapprovalDetailsPage.purchasePrice.sendKeys("234222");

    }
    @And("I enter down payment percentage")
    public void iEnterDownPaymentPercentage() {
        preapprovalDetailsPage.downPaymentPercent.sendKeys("4");
    }

    @Then("I choose YES for applying with co-borrower")
    public void iChooseYESForApplyingWithCoBorrower() {
        personalInformationPage.coBorrowerYES.click();
    }
}
