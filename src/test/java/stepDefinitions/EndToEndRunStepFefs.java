package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.*;
import utilities.SeleniumUtils;

public class EndToEndRunStepFefs {
    PreapprovalDetailsPage preapprovalDetailsPage=new PreapprovalDetailsPage();
    PersonalInformationPage personalInformationPage=new PersonalInformationPage();
    EmploymentAndIncomePage employmentAndIncomePage=new EmploymentAndIncomePage();
    EConsentPage eConsentPage=new EConsentPage();
    SummaryPage summaryPage= new SummaryPage();

    @Then("I pass realtor information")
    public void iPassRealtorInformation() {
        preapprovalDetailsPage.realtorInformation.sendKeys("John Carry");
    }


    @Then("I enter borrowers information")
    public void iEnterBorrowersInformation() {
        personalInformationPage.bFirstName.sendKeys("Mary");
        personalInformationPage.bLastName.sendKeys("Terry");
        personalInformationPage.bEmail.sendKeys("marry@gmail.com");
        personalInformationPage.bDOB.sendKeys("23101866");
        personalInformationPage.bSSN.sendKeys("666343333");
        personalInformationPage.bMaritalStatus.click();
        personalInformationPage.bMarried.sendKeys("M", Keys.ENTER);
        personalInformationPage.bCellPhone.sendKeys("543456678");


    }


    @Then("I enter employer name")
    public void iEnterEmployerName() {
     employmentAndIncomePage.employerName.sendKeys("Wells Fargo");
    }

    @And("I enter gross monthly income")
    public void iEnterGrossMonthlyIncome() {
        employmentAndIncomePage.monthlyGrossIncome.sendKeys("4000");
    }

    @And("I choose agree")
    public void iChooseAgree() {
        eConsentPage.agreeOption.click();
    }

    @And("I enter personal information")
    public void iEnterPersonalInformation() {
        eConsentPage.eConsentFirstName.sendKeys("Jane");
        eConsentPage.eConsentLastName.sendKeys("Ray");
        eConsentPage.eConsentEmail.sendKeys("Ray@gmail.com");
    }

    @Then("I click on save button")
    public void iClickOnSaveButton() {
        //summaryPage.saveButton.click();

        SeleniumUtils.jsClick(summaryPage.saveButton);
    }


}
