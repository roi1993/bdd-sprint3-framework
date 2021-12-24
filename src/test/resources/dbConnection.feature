@DB
Feature: DB connection Test

  Background:
    Given I am connected with the database

  Scenario: I want to test the database connection
    When I run the select query
    Then I should see the result as



