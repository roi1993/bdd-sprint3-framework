@smokeAPI @regressionAPI

  Feature: Mortgage POST API /mortagagedetails.php endpoint - returns a specific mortgage
    application details for a logged in user

  Scenario: Test Mortgage Details API Positive Scenario returns Specific Mortgage App Details For Logged In User (admin)
    Given  The baseURI initialized and I logged in as an admin with following and  I have the JWT token extracted
      | email                     | password    |
      | duotechb5@gmail.com       | duotechb5   |
    When I send GET request to "/getmortagage.php" endpoint, I will retrieve all the mortgage applications under user account
    Then I extract specific id from the list of applications
    And  I pass extracted id setting header key to "Authorization" and value to token number
    Then I send POST request to "/mortagagedetails.php" endpoint
    Then I should be able to retrieve the single application under the id that was passed
