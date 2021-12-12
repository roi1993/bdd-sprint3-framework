
@K
Feature: As a user, I should be able to land on Mortgage Application form, so that i can fill out the form.
  Background:
    Given I am on main Login page
    When I enter Email and password
    Then I click on Login Button
    Then I click on Mortgage Application

    Scenario: Fill out Preapproval Form
      Then I choose YES for working with realtor
      And I pass realtor Name and Phone Number
