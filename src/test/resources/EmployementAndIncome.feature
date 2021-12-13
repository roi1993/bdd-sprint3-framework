
  Feature:

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
      When I choose Rent for current monthly expenses
      Then I enter monthly rental payment
      Then I click on next button

      Scenario: I fill in the Employment and Income Form
        Then I check This is my current job field
        Then I enter "Anna Jordan" for employer name
        Then I enter "Upper position" for position
        Then I enter "Fairfax" for city and select state
        Then I enter 01012021 for start date
        Then I enter 2500.00 to monthly income and enter 234.42 for monthly overtime
        Then I click on next button
        And I should land on next Credit Report page





