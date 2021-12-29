@DB

Feature: Sign Up feature involving DB layer

  Scenario: New user sign up
    Given I am on main Login page
    And I am connected to the DB
    Then I click on Sign Up Blue Link
    When I sign up with following info
      | First Name | Last Name | Email               | Password   |
      | Fred       | Tomas     | tyrh@mvideoiiur.com  | FreadT20215 |
    Then I should land on Login main Page
    And The database should also have correct record in it


  Scenario: New User Creation from DB to UI flow
    Given I am connected to the DB
    When I add a new user to the database with the following info
      | First Name | Last Name | Email                 | Password  |
      | Nick       | James     | 123nija@videour.com   | James2021 |
    Then I should be able to log in with the "123nija@videour.com" as email and "James2021" as password on the UI

  Scenario: Test if input field leading and trailing spaces are truncated before committing data to the database
    Given I am on main Login page
    Given I click on Sign Up Blue Link and I am connected to DB
    When I sign up with the following info "Julia" "Roberts" "    1234jurortb@gmail.com     "  "julia12345"
    Then I should land on Login main Page
    And The database should also have the correct info without spaces


     Scenario: Verify Email update in the DB
      Given I am connected to the DB
      When I update email "tom@gmail.com" email with to  "tom1@gmail.com"
      Then I am on Login main Page
       And I should be able to log in with new credentials











