@K
Feature: Fill out preapproval details form on mortgage application
  Background:
    Given I am on main Login page
    Then I enter email and password
    And I click on login button
    Then I click on Mortgage application

  Scenario Outline: Preapproval application
    Then I choose Yes working with realtor
    And I pass realtor information "name" and "phone number"
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





