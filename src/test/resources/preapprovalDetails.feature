@K
Feature: Fill out preapproval details form
  Background:
    Given I am on main Login page
    When I enter Email and password
    Then I click on Login Button
    Scenario: preapproval form
      Then I click on Mortgage Application
