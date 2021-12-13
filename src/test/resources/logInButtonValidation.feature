  @regression
  Feature: As a registered user, I should be able to log into my DuoBank Dashboard

    Background:
      Given I am on main Login page

#    @smoke
#    Scenario: Log in to my DuoBank Dashboard providing email and password by clicking on Login Button

    #  Given I am on main Login page
#      When I enter "email address" and "password"
#      Then I click on Login Button
#      Then I should land on my DuoBank Dashboard


    Scenario: Log in to my DuoBank Dashboard providing only email

    #  Given I am on main Login page
      When I enter "ditote3350@leanrights.com" for email and leave password field empty
      Then I click on Login Button
      Then System should give pop-up error message on password field


    Scenario: Log in to my DuoBank Dashboard providing only password

    #  Given I am on main Login page
      When I leave email address field empty and enter only "Janeray2021" for password
      Then I click on Login Button
      Then System should give pop-up error message on email address field


    Scenario: Log in to my DuoBank Dashboard providing email and password by clicking on Login Arrow

    #  Given I am on main Login page
      When I enter following info for email and password
      | ditote3350@leanrights.com  |Janeray2021|
      Then I click on Login Arrow on the right
      Then I should land on my DuoBank Dashboard


    @Z
    Scenario: Sign up to the website using Excel File

      When I enter information from Excel File named "TestDataforSignUpFeature.xlsx" for required fields
      And  I click on Sign Up Button
      Then I should get Registration Successful Message on sign up page

















