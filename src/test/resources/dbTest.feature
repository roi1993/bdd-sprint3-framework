@DB
Feature: DB Test

Scenario: Check for duplicate values in the username column
Given I am connected to the DB
When I send a query to check for duplicate email
Then The returned result list should be empty



  Scenario: Verify the column length for first_name column of the tbl_user table
    Given I am connected to the DB
    When I update the first_name column with a String with an invalid length of 101 , the update should truncate the length to 100

