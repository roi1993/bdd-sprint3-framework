@smokeAPI @regressionAPI

Feature: End-to-End MultiLayer API

  Scenario: Create a new User through API Call and Delete created user from DB
    Given The baseURI initialized and header is set to "Accept" to value of "application/json"
    When I pass "Jason" for firstName, "Mason" for lastName,"jason@gmail.com" for email, and "jasonMason1234#" for the password to the body and send POST request to "/register.php"
    And I should get message of "You have successfully registered." as verification for registration
    Then I should be able to login to DUOBank website through UI with following and my username on DashBoard should be "Jason Mason"
    And I access to DB and pass "delete from tbl_user where first_name = 'Jason';" for query
    Then I try to login back to website through API Access by passing above credentials to body and send POST request to "/login.php"
    And I should see the "Invalid Email Address!" message on the body and should not be able to login with deleted credentials
