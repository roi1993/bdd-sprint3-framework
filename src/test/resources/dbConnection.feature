Feature: DB connection Test

  Background:
    Given I am connected with the database

  Scenario: I want to test the database connection
    When I run the select query
    Then I should see the result as


  Scenario: DB testing
    When I retrieve column name
    Then It should be the following
    |id |
    |email|
    |password|
    |first_name|
    |last_name |
    |phone     |
    |image     |
    |type      |
    |created_at|
    |modify_at |
    |zone_id   |
    |church_id|
    |country_id|
    |active    |