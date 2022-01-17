package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.time.Duration;

import static io.restassured.RestAssured.baseURI;

public class Hooks {


    @Before
    public void setupScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
    //    baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
    }
    @After
    public void tearDownScenario(Scenario scenario){

        if(scenario.isFailed()){

            byte[] screenshotAs = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotAs,"image/png","failed_scenario_screenshot");

        }
        Driver.quitDriver();

    }
}
