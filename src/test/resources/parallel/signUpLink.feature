@smoke
Feature: As a non-registered user, I should be able to click on Sign Up Blue Link on Login main Page to be able to register
         to the website

  Scenario: on Login main Page click on Sign Up Blue Link
    Given I am on Login main Page
    When I click on Sign Up Blue Link
    Then I should land on Sign Up Page to be able to register to the website