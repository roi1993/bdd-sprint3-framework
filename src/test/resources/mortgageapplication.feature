
@regression
Feature: As a user, I should be able to click on mortgage application link, so that I`ll land on Mortgage Application form

  Background:
    Given I am on main Login page
    When I enter Email and password
    Then I click on Login Button

@smoke
  Scenario: Mortgage Application
    Then I click on Mortgage Application
    And I should be able to land on Mortgage Application form
