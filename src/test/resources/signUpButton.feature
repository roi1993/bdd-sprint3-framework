  @regression
  Feature: As a non-registered user, I should be able to register to the website

    Background:
      Given I am on Sign Up Page
      And   I click on Sign Up Button

    Scenario: Sign Up to the website by providing required info properly in correct format

      When  I pass this information
        | First Name  | Last Name | Email Address        | Password     |
        | James       | Temple    | JaTemple@gmail.com   |  ohch4vaep9O |
      Then  I should land on back on Login main Page


    Scenario: Sign Up to the website by providing First and Last Name in lowercase

      When  I pass this information
        | First Name  | Last Name | Email Address       | Password     |
        | john        | doe       | johnd@gmail.com     | cei1Michoh   |
      Then  I should get error message
      #registration must fail if there is format rule on the website

    Scenario: Sign Up to the website by providing email without domain

      When  I pass this information
        | First Name   | Last Name     | Email Address       | Password     |
        | Linda        | Butcher       | l.Butcher@          |  kee1ooHi    |
      Then  I should get error message on email address field


    Scenario: Sign Up to the website by only providing email and password

      When  I leave a blank on field first name and last name
      And   I only enter email address and password
      Then  I should get error message on First Name Field











