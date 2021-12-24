@End-to-End
Feature: End-To-End Run
  Scenario: Fill out mortgage application only required fields
    Given I am on Login main Page
    When I enter Email and password
    Then I click on Login Button
    Then I click on Mortgage Application
    And  I choose YES for working with realtor
    Then I pass realtor information
    Then I enter estimated purchase price
    And I enter down payment percentage
    And I click on next button
    Then I enter borrowers information
    And I click on next button
    Then I enter monthly rental payment
    And I click on next button
    Then I enter employer name
    And I enter gross monthly income
    Then I click on next button
    Then I click on next button
    And I enter personal information
    And I choose agree
    And I click on next button
    Then I click on save button

