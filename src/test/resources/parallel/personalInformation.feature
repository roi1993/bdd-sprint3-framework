@K
Feature: As a user, I should be able to land on Mortgage Application form, so that i can fill out the form.

  Background:
    Given I am on main Login page
    When I enter Email and password
    Then I click on Login Button
    Then I click on Mortgage Application
    Then I choose YES for working with realtor
    And I pass realtor Name and Phone Number

      |Name     |Phone num   |
      |Stephen  |454-343-3443|

    Then I choose Yes for working with a loan officer
    Then I enter estimated purchase price
    And I enter down payment percentage
    And I click on next button

    Scenario: Fill out Personal Information Form
      Then I choose YES for applying with co-borrower
      Then I enter information from Excel File named "Personal_info_data.xlsx" for borrower
      Then I enter information from Excel File named "Personal_info_data2.xlsx" for co-borrower
      Then I click on next button
      And I should land on expenses form

