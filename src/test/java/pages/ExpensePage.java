package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExpensePage {
    public ExpensePage() {
        PageFactory.initElements(Driver.getDriver(),this); }


//EXPENSE PAGE
    //checkbox
   // @FindBy(xpath = "//label[@for='expense1']")
    @FindBy(xpath = "//div//input[@id='expense1']")
    public WebElement currentMonthlyHousingExpenses;

    //entry slot
    //@FindBy(xpath = "//div//input[@name='monthly_rental_payment']")
    @FindBy(id = "monthlyrentalpayment")
    public WebElement monthlyRentalPayment;

    @FindBy(xpath = "//a[@href='#next']")
    public WebElement nextButton;

    @FindBy(xpath = "//h6[text()='Borrower Employment Information']")
    public WebElement employmentPageTitle;
}