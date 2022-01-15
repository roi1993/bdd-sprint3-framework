Feature: Mortgage API Feature

  @API
  Scenario: Verify POST \register API
    Given the baseURI is initialize and the header "Accept","application/json" is set
    When I set a POST request to "/register.php" endpoint
    Then the status code should be 200
