@regression
Feature: As a non-registered user, I should be able to register to the website

  Background:
    Given I am on Sign Up Page


  Scenario: Sign Up to the website by providing required info properly in correct format

    When  I pass this information
      | First Name | Last Name | Email Address       | Password    |
      | James      | Temple    | JamTemple@gmail.com | ohch4vaep9O |
    And   I click on Sign Up Button
    Then  I should land on back on Login main Page


  Scenario: Sign Up to the website by providing First and Last Name in lowercase

    When  I pass this information
      | First Name | Last Name | Email Address | Password   |
      | john       | doe       | jod@gmail.com | cei1Michoh |
    And   I click on Sign Up Button
    Then  I should get error message
      #registration must fail if there is format rule on the website

  Scenario: Sign Up to the website by providing email without domain

    When  I pass this information
      | First Name | Last Name | Email Address | Password |
      | Linda      | Butcher   | l.Butcher@    | kee1ooHi |
    And   I click on Sign Up Button
    Then  I should get error message on email address field


  Scenario: Sign Up to the website by only providing email and password

    When  I leave a blank on field first name and last name
    And   I only enter email address and password
    And   I click on Sign Up Button
    Then  I should get error message on First Name Field


  Scenario:
    When I enter following information on required field on sign up
      | FIRST NAME | LAST NAME | EMAIL                  | PASSWORD |
      | Holmes     | Hulme     | hhulme2ny@e-recht24.de | t22UNy3  |

    And  I click on Sign Up Arrow on the right
    Then I should get Registration Successful Message on sign up page


  Scenario Outline:

    When I enter following information on required field on sign up
      | FIRST NAME   | LAST NAME   | EMAIL   | PASSWORD   |
      | <FIRST NAME> | <LAST NAME> | <EMAIL> | <PASSWORD> |

    And  I click on Sign Up Arrow on the right
    Then I should get Registration Successful Message on sign up page

    Examples:
      | FIRST NAME | LAST NAME | EMAIL                         | PASSWORD     |
      | Hanson     | Luck      | hluck301@bing.com             | DZXk23iT     |
      | Patsy      | Ucchino   | pucchino302@redcross.org      | Bel1iThZ     |
      | Jill       | Stiegers  | jstiegers303@fc2.com          | 0iB4hHI      |
      | Rourke     | Lukacs    | rlukacs304@comsenz.com        | Ry9Pdb2g0    |
      | Candra     | Hargreave | chargreave305@marketwatch.com | DQapoG1      |
      | Deni       | Freear    | dfreear306@kickstarter.com    | lb4QISgZ     |
      | Waldon     | Andriuzzi | wandriuzzi307@icq.com         | DseGhJY365ae |
      | Kelbee     | Barz      | kbarz308@instagram.com        | nZbVAu       |
      | Matthus    | Boldra    | mboldra309@hibu.com           | QRmoV3M      |
      | Merell     | Lohmeyer  | mlohmeyer30a@dropbox.com      | Ts2iJiEc     |


  Scenario: Sign up to the website using Excel File

    When I enter information from Excel File named "TestDataforSignUpFeature.xlsx" for required fields
    And  I click on Sign Up Button
    Then I should get Registration Successful Message on sign up page












