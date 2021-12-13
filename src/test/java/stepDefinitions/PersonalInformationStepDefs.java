package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.PersonalInformationPage;
import pages.PreapprovalDetailsPage;
import utilities.Driver;
import utilities.ExcelUtils;

import java.util.List;
import java.util.Map;

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

    @Then("I enter information from Excel File named {string} for borrower")
    public void iEnterInformationFromExcelFileNamedForBorrower(String path) throws Throwable {

        ExcelUtils excelUtils = new ExcelUtils(path,"data");

        List<Map<String, String>> dataAsMap = excelUtils.getDataAsMap();
        Throwable exception = null;

        for (int i = 0; i < dataAsMap.size(); i++) {
            Map<String, String> row = dataAsMap.get(i);

            if(row.get("execute").equalsIgnoreCase("T")){



                try {
                    personalInformationPage.bFirstName.sendKeys(row.get("bFirst_Name"));


                    excelUtils.setCellData("PASSED", "status", i + 1);

                }catch(Throwable e){
                    exception = e;
                    excelUtils.setCellData("FAILED","status",i+1);

                }

            }else{
                excelUtils.setCellData("SKIPPED","status",i+1);

            }
            Thread.sleep(2000);
        }
        throw exception;



    }


    @Then("I enter information from Excel File named {string} for co-borrower")
    public void iEnterInformationFromExcelFileNamedForCoBorrower(String arg0) {
        personalInformationPage.nextButton.click();
    }

    @And("I should land on expenses form")
    public void iShouldLandOnExpensesForm() {
        String expected="";
        String actual= Driver.getDriver().getTitle();
        Assert.assertEquals(expected,actual);
    }
}
