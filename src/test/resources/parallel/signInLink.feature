  @smoke
  Feature: As a non-registered user, I should be able to click on Sign In Blue Link on Sign Up Page to get back to Login Page

    Scenario: on Sign Up Page click on Sign in Blue Link
      Given I am on Sign Up Page
      When I click on Sign In Blue Link
      Then I should land on Login main Page
