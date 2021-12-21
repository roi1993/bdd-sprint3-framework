@KDBTest

Feature: Sign Up feature involving DB layer


  Scenario: New user sign up
    Given I am on Sign Up Page and I am connected to DB
    When I sign up with following info
    |First Name|Last Name|Email                 |Password|
    |Fred      |Tomas    |ticevov482@videour.com|FreadT2021|
    Then I should land on home page
    And The database should also have correct record in it