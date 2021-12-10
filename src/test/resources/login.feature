@smoke
Feature: As a registered user, I should be able to log into my DuoBank Dashboard

  Scenario: Log in to my DuoBank Dashboard

    Given I am on main Login page
    When I enter "Email" and "password"
    Then I click on Login Button
    Then I should land on my DuoBank Dashboard