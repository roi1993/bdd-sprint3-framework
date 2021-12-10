
  Feature: As a non-registered user, I should be able to register to the website

    Scenario: Sign Up to the website by providing required info properly in correct format
      Given I am on Sign Up Page
      When  I pass this information
        | First Name  | Last Name | Email Address       | Password     |
        | James       | Temple    | JTemple@gmail.com   |  ohch4vaep9O |
      And   I click on Sign Up Button
      Then  I should land on back on Login main Page


    Scenario: Sign Up to the website by providing First and Last Name in lowercase
      Given I am on Sign Up Page
      When  I pass this information
        | First Name  | Last Name | Email Address       | Password     |
        | john        | doe       | johnd@gmail.com     | cei1Michoh   |
      And   I click on Sign Up Button
      Then  I should get error message
      #registration must fail if there is format rule on the website

    Scenario: Sign Up to the website by providing email without domain
      Given I am on Sign Up Page
      When  I pass this information
        | First Name   | Last Name     | Email Address       | Password     |
        | Linda        | Butcher       | l.Butcher@          |  kee1ooHi    |
      And   I click on Sign Up Button
      Then  I should get error message of "Please enter a part following '@'. is incomplete."


    Scenario: Sign Up to the website by only providing email and password
      Given I am on Sign Up Page
      When  I pass this information
        | Email Address              | Password     |
        | jill.Serrano@gmail.com     | thooZ8oo     |
      And   I click on Sign Up Button
      Then  I should get error message on First Name Field
      #registration must fail if there is format rule on the website










