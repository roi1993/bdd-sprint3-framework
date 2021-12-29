@DB
Feature: DB tbl_mortgage test

  Scenario: Verify the column names in DB
    Given I am connected to the DB
    When I retrieve the column name from tbl_mortgage table
    Then it should contain the following

      | id                           |
      | realtor_status               |
      | realtor_info                 |
      | loan_officer_status          |
      | purpose_loan                 |
      | est_purchase_price           |
      | down_payment                 |
      | down_payment_percent         |
      | total_loan_amount            |
      | src_down_payment             |
      | add_fund_available           |
      | apply_co_borrower            |
      | b_firstName                  |
      | b_middleName                 |
      | b_lastName                   |
      | b_suffix                     |
      | b_email                      |
      | b_dob                        |
      | b_ssn                        |
      | b_marital                    |
      | b_cell                       |
      | b_home                       |
      | c_firstName                  |
      | c_middleName                 |
      | c_lastName                   |
      | c_suffix                     |
      | c_email                      |
      | c_dob                        |
      | c_ssn                        |
      | c_marital                    |
      | c_cell                       |
      | c_home                       |
      | rent_own_status              |
      | monthly_rental_payment       |
      | first_mortagage_total_payment |
      | employer_name                |
      | position                     |
      | city                         |
      | state                        |
      | start_date                   |
      | end_date                     |
      | current_job                  |
      | co_employer_name             |
      | co_position                  |
      | co_city                      |
      | co_state                     |
      | co_start_date                |
      | co_end_date                  |
      | co_current_job               |
      | gross_monthly_income         |
      | monthly_over_time            |
      | monthly_bonuses              |
      | monthly_commision            |
      | monthly_dividents            |
      | c_gross_monthly_income       |
      | c_monthly_over_time          |
      | c_monthly_bonuses            |
      | c_monthly_commision          |
      | c_monthly_dividents          |
      | add_belong                   |
      | income_source                |
      | amount                       |
      | eConsent_declarer            |
      | eConsent_declarer_FirstName  |
      | eConsent_declarer_LastName   |
      | eConsent_declarer_Email      |
      | created_on                   |
      | modified_on                  |
      | loan_status                  |
      | user_id                      |
      | active                       |



    Scenario: Verify if info appear in tbl_mortgage after filling out the full application for mortgage from UI side
      Given I am connected to the DB
      Given I am on Login main Page
      When I enter Email and password
      Then I click on Login Button
      Then I click on Mortgage Application
      And  I choose YES for working with realtor
      Then I pass realtor information
      Then I enter estimated purchase price
      And I enter down payment percentage
      And I click on next button
      Then I enter borrowers information
      And I click on next button
      Then I enter monthly rental payment
      And I click on next button
      Then I enter employer name
      And I enter gross monthly income
      Then I click on next button
      Then I click on next button
      And I enter personal information
      And I choose agree
      And I click on next button
      Then I click on save button
      When I send query to check the information entered
      Then I should be able to see my application on DB side



      Scenario: Verify the number of application on DB and UI
        Given I am connected to the DB
        Given  I am on Login main Page
        When  I enter Email and password
        And  I click on Login Button
        Then  I go to Application List page on the website
        Then  The number of applications on UI should match the number of applications on DB




