@smokeAPI @regressionAPI

Feature: Mortgage GET API Feature

  Background:
    Given The baseURI initialized

  Scenario: Verify GET /getmortagage.php API
    #Given The baseURI initialized
    Given I logged in as a valid user with following and  I have the JWT token extracted
      | email                     | password    |
      | ditote3350@leanrights.com | Janeray2021 |

    When I set header to "Authorization", "token"
    And I send GET request to a "/getmortgage.php" endpoint
    Then I should be able to retrieve all the mortgage applications that belong to user and the total number of applications should be 11


  Scenario: Verify GET /getmortagae.php API with missing Authorization Token
  #  Given The baseURI initialized
    Given I logged in as a valid user with following and  I have the JWT token extracted
      | email                     | password    |
      | ditote3350@leanrights.com | Janeray2021 |

    When I send GET request to a "/getmortgage.php" endpoint without token number
    Then I should get statusCode of 200 with body message of "Unauthorized"

  Scenario: Verify GET /getmortagae.php API with logging in with Admin Account
  #  Given The baseURI initialized
    Given I logged in as an admin with following and  I have the JWT token extracted
      | email                     | password    |
      | duotechb5@gmail.com       | duotechb5   |

    When I send GET request to a given endpoint
    Then I should be able to see the list of all applications with different users