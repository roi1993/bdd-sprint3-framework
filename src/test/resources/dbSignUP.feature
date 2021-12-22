@KDBTest

Feature: Sign Up feature involving DB layer
Background:
  Given I am on main Login page

  Scenario: New user sign up
    Then I click on Sign Up Blue Link
    When I sign up with following info
    |First Name|Last Name|Email                 |Password|
    |Fred      |Tomas    |tivNN823@videour.com  |FreadT2021|
    Then I should land on Login main Page
    And The database should also have correct record in it








