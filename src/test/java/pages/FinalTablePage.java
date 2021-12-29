package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class FinalTablePage {

    public FinalTablePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div//span[text()='Application List']")
    public WebElement applicationListPageTab;

    @FindBy(tagName = "table")
    public List<WebElement> finalTable;
}
