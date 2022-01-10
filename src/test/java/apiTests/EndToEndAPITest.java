package apiTests;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import pojos.MortgageApplication;
import utilities.DBUtility;

import static io.restassured.RestAssured.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class EndToEndAPITest {


    //create new mortgage application with SQL
    @Test
    public void endToEndMultilayerAPITest() throws SQLException {

        int id = 100 + (int) (Math.random() * 900);
        String randomEmail = new Faker().internet().emailAddress();
        String randomEmail2 = new Faker().internet().emailAddress();
        int user_id = 1000 + (int)(Math.random() * 9000);
        Date dateAndTime = Calendar.getInstance().getTime();
        String dateTime = dateAndTime.toString();

        MortgageApplication single_application = new MortgageApplication(id,1,"James Bond", 1,"Purchase a Home", 100000000,250000,25,
                750000,"Checking/Savings (most recent bank statement)",2,"Jennifer","Lopez",randomEmail,"12/31/1975","123456789","Married",
                "123-456-7899","Rent",4500,"Barbara Lopez",100000,"Jennifer","Lopez",randomEmail,dateTime,user_id,1 );

        //System.out.println(single_application);

        DBUtility.createConnection();
//        DBUtility.updateQuery("INSERT INTO tbl_mortagage (id, realtor_status, realtor_info,loan_officer_status,purpose_loan,est_purchase_price,down_payment,down_payment_percent,total_loan_amount,src_down_payment,apply_co_borrower,b_firstName,b_lastName,b_email,b_dob,b_ssn,b_marital,b_cell,rent_own_status,monthly_rental_payment,employer_name,gross_monthly_income,eConsent_declarer_FirstName,eConsent_declarer_LastName,eConsent_declarer_Email,created_on,user_id,active \n" +
//                "values ('"+single_application+"');");
        DBUtility.updateQuery("INSERT INTO tbl_mortagage (id, realtor_status, realtor_info,loan_officer_status,purpose_loan,est_purchase_price," +
                "down_payment,down_payment_percent,total_loan_amount,src_down_payment,apply_co_borrower,b_firstName,b_lastName," +
                "b_email,b_dob,b_ssn,b_marital,b_cell,rent_own_status,monthly_rental_payment,employer_name,gross_monthly_income," +
                "eConsent_declarer_FirstName,eConsent_declarer_LastName,eConsent_declarer_Email,created_on,user_id,active" +
                "values ('"+id+"',1,'James Bond', 1,'Purchase a Home', 100000000,250000,25,750000," +
                "'Checking/Savings (most recent bank statement)',2,'Jennifer','Lopez','"+randomEmail+"','12/31/1975'," +
                "123456789,'Married','123-456-7899','Rent',4500,'Barbara Lopez',100000,'Jennifer','Lopez','"+randomEmail+"'," +
                "'"+dateTime+"',"+user_id+",1);");

        DBUtility.close();

    //verify if application added to API with POST logging in as admin
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
        JsonPath jsonPath = given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"duotechb5@gmail.com\",\n" +
                        "  \"password\": \"duotechb5\"\n" +
                        "}").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("You have successfully logged in.")).extract().jsonPath();

        String token = jsonPath.getString("token");

        JsonPath jsonPath1 = given().
                header("Authorization",token).
                when().log().all().
                get("/getmortagage.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("success",equalTo(1)).extract().jsonPath();

//        List<Object> mortagage_applications = jsonPath1.getList("mortagage_applications");
//        List listofID = jsonPath1.get("mortagage_applications.id");
//        id = listofID.get(6).toString();

        JsonPath jsonPath2 = given().
                header("Authorization",token).
                body("{\n" +
                        " \"id\":\""+id+"\"\n" +
                        "}").
                when().log().all().
                post("/mortagagedetails.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("success",equalTo(1)).extract().jsonPath();


        Map<Object,String> single_applicationForgivenUser = jsonPath2.getMap("single_application");

        Assert.assertEquals(single_application.getRealtor_info(),single_applicationForgivenUser.get("realtor_info"));
        Assert.assertEquals(String.valueOf(single_application.getEst_purchase_price()),single_applicationForgivenUser.get("est_purchase_price"));
        Assert.assertEquals(single_application.getB_firstName(),single_applicationForgivenUser.get("b_firstName"));
        Assert.assertEquals(single_application.getB_lastName(),single_applicationForgivenUser.get("b_lastName"));


    //Update query in DB by ID number

        DBUtility.createConnection();
        DBUtility.updateQuery("Update tbl_mortagage set employer_name='Angelina Jolie' where id='"+id+"';");
        DBUtility.close();


    //verify change in API
        JsonPath jsonPath3 = given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"duotechb5@gmail.com\",\n" +
                        "  \"password\": \"duotechb5\"\n" +
                        "}").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("You have successfully logged in.")).extract().jsonPath();

        String token1 = jsonPath.getString("token");

        JsonPath jsonPath4 = given().
                header("Authorization",token1).
                when().log().all().
                get("/getmortagage.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("success",equalTo(1)).extract().jsonPath();

//        List<Object> mortagage_applications = jsonPath1.getList("mortagage_applications");
//        List listofID = jsonPath1.get("mortagage_applications.id");
//        id = listofID.get(6).toString();

        JsonPath jsonPath5 = given().
                header("Authorization",token1).
                body("{\n" +
                        " \"id\":\""+id+"\"\n" +
                        "}").
                when().log().all().
                post("/mortagagedetails.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("success",equalTo(1)).extract().jsonPath();


        Map<Object,String> single_applicationForgivenUser1 = jsonPath2.getMap("single_application");

        Assert.assertEquals(single_application.getEmployer_name(),single_applicationForgivenUser1.get("employer_name"));


//    //delete application from DB

        DBUtility.createConnection();
        DBUtility.updateQuery("Delete from tbl_mortagage where id='"+id+"';");
        DBUtility.close();
    //delete application with DELETE
//        given().
//
//                header("Accept", "application/json").
//                pathParam("id", id).
//
//
//                when().log().all().
//                delete("/mortagagedetails.php/{userid}").
//                then().log().all(). // assertions on the returned response are put here
//                assertThat().
//                statusCode(200).
//                body("status", is("Record Deleted Successfully"));



    //verify change in API
        JsonPath jsonPath6 = given().
                header("Accept", "application/json").
                body("{\n" +
                        "  \"email\": \"duotechb5@gmail.com\",\n" +
                        "  \"password\": \"duotechb5\"\n" +
                        "}").
                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", equalTo("You have successfully logged in.")).extract().jsonPath();

        String token2 = jsonPath.getString("token");

        JsonPath jsonPath7= given().
                header("Authorization",token2).
                when().log().all().
                get("/getmortagage.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("success",equalTo(1)).extract().jsonPath();

        given().
                header("Authorization",token2).
                body("{\n" +
                        " \"id\":\""+id+"\"\n" +
                        "}").
                when().log().all().
                post("/mortagagedetails.php").
                then().log().all().
                //assertThat().
                        statusCode(200).
                        body("single_application",equalTo(null));



    }


}
