@API

Feature: Mortgage POST API Feature


  Scenario: Verify POST \register API
    Given the baseURI is initialize and the header "Accept","application/json" is set
    When I set a POST request to "/register.php" endpoint and body requirements is passed
    Then the status code should be 200


    Scenario: Test PostAPI Negative Scenario Missing Body
      Given the baseURI is initialize and the header "Accept","application/json" is set
      When I set a POST request to "/register.php" endpoint
      Then the status code should be 200


  Scenario: Test PostAPI Negative Scenario With Valid Required Parameters
        Given the baseURI is initialize and the header "Accept","application/json" is set
        When I set a POST request to "/register.php" endpoint and body with used credential is passed
        Then the status code should be 200


