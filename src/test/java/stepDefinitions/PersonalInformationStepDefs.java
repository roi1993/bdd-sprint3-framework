package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

    @Then("I choose NO for applying with co-borrower")
    public void iChooseYESForApplyingWithCoBorrower() {
        personalInformationPage.coBorrowerNO.click();
    }

    @Then("I enter information from Excel File named {string} for borrower")
    public void iEnterInformationFromExcelFileNamedForBorrower(String path) throws Throwable {

        ExcelUtils excelUtils = new ExcelUtils(path,"data");

        List<Map<String, String>> dataAsMap = excelUtils.getDataAsMap();
        Throwable ex = null;

        for (int i = 0; i < dataAsMap.size(); i++) {
            Map<String, String> row = dataAsMap.get(i);

            if(row.get("execute").equalsIgnoreCase("T")){

                try {
                    personalInformationPage.bFirstName.sendKeys(row.get("bFirst_Name"));
                    personalInformationPage.bMiddleName.sendKeys(row.get("bMiddle_Name"));
                    personalInformationPage.bLastName.sendKeys(row.get("bLast_Name"));
                    personalInformationPage.bEmail.sendKeys(row.get("email"));
                    personalInformationPage.bSSN.sendKeys(row.get("SSN"));
                    personalInformationPage.bCellPhone.sendKeys(row.get("bCell_Phone"));
                    personalInformationPage.bHomePhone.sendKeys(row.get("bHome_Phone"));

                }catch(Throwable e){
                    ex = e;
                    excelUtils.setCellData("FAIL", "Status", i + 1);
                }

                Driver.getDriver().navigate().back();

            }else{
                excelUtils.setCellData("SKIPPED", "Status", i + 1);
            }


        }

        throw ex;

    }



    @And("I should land on expenses form")
    public void iShouldLandOnExpensesForm() {
        String expected="";
        String actual= Driver.getDriver().getTitle();
        Assert.assertEquals(expected,actual);
    }

}
