package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CreditReportPage;
import utilities.DBUtility;
import utilities.Driver;

public class CreditReportStepDefs {

    CreditReportPage creditReportPage= new CreditReportPage();




    @Then("I choose YES for order credit report")
    public void iChooseYESForOrderCreditReport() {
    creditReportPage.orderCreditReportYES.click();

    }


    @Then("I should land on econsent form")
    public void iShouldLandOnEconsentForm() {
        String expected="";
        String actual= Driver.getDriver().getTitle();
        Assert.assertEquals(expected,actual);
    }



    @Then("I choose NO for order credit report")
    public void iChooseNOForOrderCreditReport() {
        creditReportPage.orderCreditReportNO.click();
    }
}
