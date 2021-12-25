@DB
Feature: DB Test

Scenario: Check for duplicate values in the username column
Given I am connected to the DB
When I send a query to check for duplicate usernames
Then The returned result list should be empty