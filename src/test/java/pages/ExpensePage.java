package pages;

public class ExpensePage {
    public ExpensePage() {PageFactory.initElements(Driver.getDriver(),this); }


//EXPENSE PAGE
    //checkbox
    @FindBy(xpath = "//label[@for='expense1']")
    public WebElement currentMonthlyHousingExpenses;

    //entry slot
    @FindBy(xpath = "//input[@type='number']")
    public Webelement monthlyRentalPayment;

    @FindBy(xpath = "//a[@href='#next']")
    public WebElement nextButton;
}