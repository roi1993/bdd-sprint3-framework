@smokeAPI @regressionAPI

Feature: End-to-End MultiLayer API

  Scenario: Create a new User through API Call and Delete created user from DB
    Given The baseURI initialized and header is set to "Accept" to value of "application/json"
    When I pass following to the body and send POST request to "/register.php"
      | first_name | Jason           |
      | last_name  | Mason           |
      | email      | randomEmail     |
      | password   | jasonMason1234# |
    And I should get message of "You have successfully registered." as verification for registration
    Then I should be able to login to DUOBank website with through UI and my username on DashBoard should be "Jason Mason"
    And I access to DB and pass "delete from tbl_user where first_name = 'Jason';" for query
    Then I try to login back to website through API Access by passing following to body and send POST request to "/login.php"
    And I should see the "Invalid Email Address!" message on the body and will not be able to login with deleted credentials
