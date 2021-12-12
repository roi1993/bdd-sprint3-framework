
@K
Feature: As a user, I should be able to land on Mortgage Application form, so that i can fill out the form.
  Background:
    Given I am on main Login page
    When I enter Email and password
    Then I click on Login Button
    Then I click on Mortgage Application

    Scenario Outline: Fill out Preapproval Form
      Then I choose YES for working with realtor
      And I pass realtor Name and Phone Number
      Then I choose Yes for working with a loan officer
      And I choose purpose of the loan
      Then I enter <estimated purchase price>
      And I enter <down payment amount>
      And My down payment <percentage> should be
      Then My <loan amount is>
      Then I provide source of down payment
      And I click on next button
      And I should land on personal information part of application
    Examples:
      | estimated purchase price | down payment amount | percentage | loan amount is |
      |360000                    | 1000                |35000 $     |2               |
