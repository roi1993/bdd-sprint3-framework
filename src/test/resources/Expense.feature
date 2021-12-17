
@Zi
Feature: Fill out Expenses page

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
    Then I choose NO for applying with co-borrower
    Then I enter following information

      | FirstName | LastName | Email                     | DOB      | SSN       | Cell Phone |
      | Jane      | Ray      | ditote3350@leanrights.com | 12131985 | 123456789 | 123456789  |

    And I choose marital status
    Then I click on next button

    Scenario: I fill in Expenses Form
      When I choose Rent for current monthly expenses
      Then I enter monthly rental payment
      Then I click on next button
      And  I should land on Employment and Income Page

