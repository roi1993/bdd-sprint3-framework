Feature:DB tbl_usr test

  Background:
    Given I am connected with the database

Scenario: DB testing
When I retrieve column name
Then It should be the following
| id         |
| email      |
| password   |
| first_name |
| last_name  |
| phone      |
| image      |
| type       |
| created_at |
| modified_at  |
| zone_id    |
| church_id  |
| country_id |
| active     |
