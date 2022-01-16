@smokeAPI @regressionAPI

Feature: Mortgage POST API Feature
  Scenario: Verify POST \login API
    Given the baseURI initialize and the header "Accept","application/json" is set
    When I set a POST request to login "/login.php" endpoint and body requirements is passed
    Then status code should be 200


  Scenario: Test PostAPI Negative Scenario Missing Body
    Given the baseURI initialize and the header "Accept","application/json" is set
    When I set a POST request to login "/login.php" endpoint
    Then  status code should be 200


  Scenario: Test PostAPI With Invalid Credentials
    Given the baseURI initialize and the header "Accept","application/json" is set
    When I set a POST request to "/login.php" endpoint and body with invalid credential is passed
    Then  status code should be 200

  Scenario: Test PostAPI With Invalid Method Type
    Given the baseURI initialize and the header "Accept","application/json" is set
    When I set a DELETE request to "/login.php" endpoint and body with valid credential is passed
    Then  status code should be 200

