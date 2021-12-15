
@regression
Feature: As a user, I should be able to land on Mortgage Application form, so that i can fill out the form.
  Background:
    Given I am on main Login page
    When I enter Email and password
    Then I click on Login Button
    Then I click on Mortgage Application

    Scenario Outline: Fill out Preapproval Form
      Then I choose YES for working with realtor
      And I pass realtor Name and Phone Number

      |Name     |Phone num    |
      |Stephen  |454-343-3443 |

      Then I choose Yes for working with a loan officer
      Then I enter estimated purchase price "<est price>"
      And I enter down payment percentage "<percentage>"

      Then My loan amount is "<loan amount>"

      And I click on next button
      And I should land on personal information part of application


    Examples:
      | est price | percentage | down amount | loan amount  |
      |360000     | 2          |7200         |352800 $      |
      |999999     | 4          |39999        |960000 $       |
      |567444     | 6          |34046        |533398 $       |
      |500000     | 10         |50000        |450000 $       |
      |198333     | 25         |49583        |148750 $       |
      |999222     | 50         |499611       |499611 $       |


