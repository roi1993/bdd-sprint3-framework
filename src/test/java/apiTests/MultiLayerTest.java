package apiTests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.LoginPage;
import utilities.DBUtility;
import utilities.Driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MultiLayerTest {

    String email = new Faker().internet().emailAddress();
    String password = "jasonMason1234#";

    //Create a new user through API Call
    @Test
    public void apiToUITest(){
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";

//        String email = new Faker().internet().emailAddress();
//        String password = "jasonMason1234#";

        given().
                header("Accept", "application/json").
                body("{\n" +
                        " \"first_name\":\"Jason\",\n"+
                        " \"last_name\":\"Mason\",\n" +
                        " \"email\":\""+email+"\",\n" +
                        " \"password\":\""+password+"\"\n" +
                        "}").
                when().log().all().
                post("/register.php").
                then().log().all().
                statusCode(200).
                body("message",equalTo("You have successfully registered."));

        LoginPage loginPage = new LoginPage();
        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/");
        loginPage.email.sendKeys(email, Keys.TAB,password,Keys.TAB,Keys.ENTER);
        //loginPage.password.sendKeys(password);
        Assert.assertEquals("Jason Mason",loginPage.userNameOnDashboard.getText());
        Driver.quitDriver();



    }

    @Test
    public void dbToAPITest() throws SQLException {

        DBUtility.createConnection();
        DBUtility.updateQuery("delete from tbl_user where first_name = 'Jason';");
        DBUtility.close();

        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        given().
                header("Accept", "application/json").
                body("{\n" +
                            "  \"email\": \""+email+"\",\n" +
                            "  \"password\": \""+password+"\"\n" +
                            "}").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("Invalid Email Address!"));



    }


}
