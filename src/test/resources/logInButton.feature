
  Feature: As a registered user, I should be able to log into my DuoBank Dashboard

    Background:
      Given I am on main Login page

    @smoke
    Scenario: Log in to my DuoBank Dashboard providing email and password by clicking on Login Button

    #  Given I am on main Login page
      When I enter "email address" and "password"
      Then I click on Login Button
      Then I should land on my DuoBank Dashboard

    @regression
    Scenario: Log in to my DuoBank Dashboard providing only email

    #  Given I am on main Login page
      When I enter "email address" and leave "password" field empty
      Then I click on Login Button
      Then System should give pop-up error message on password field

    @regression
    Scenario: Log in to my DuoBank Dashboard providing only password

    #  Given I am on main Login page
      When I leave email address field empty and enter only "password"
      Then I click on Login Button
      Then System should give pop-up error message on email address field

    @regression
    Scenario: Log in to my DuoBank Dashboard providing email and password by clicking on Login Arrow

    #  Given I am on main Login page
      When I enter "email address" and "password"
      Then I click on Login Arrow on the right
      Then I should land on my DuoBank Dashboard




