
Feature: As a registered user, I should be able to log into my DuoBank Dashboard

  Background:
    Given I am on main Login page

  @smoke
  Scenario: Log in to my DuoBank Dashboard

 #   Given I am on main Login page
    When I enter "ditote3350@leanrights.com" and "Janeray2021"
    Then I click on Login Button
    Then I should land on my DuoBank Dashboard
    And  The username should be "Jane Ray"

  @regression
  Scenario Outline: Verify Username On the DashBoard

  #  Given I am on main Login page
    When I enter "<Email>" and "<password>"
    Then I click on Login Button
    Then I should land on my DuoBank Dashboard
    And  The username should be "<Username>"

    Examples:
      |Email                           |password     |  Username          |
      |mhasselby26@dot.gov             |6vSWpNgYl    | Madelle Hasselby   |
      |srustan27@usatoday.com          |39PqYt1q8    | Sidnee Rustan      |
      |kcotte28@parallels.com          |s7pYDPg      | Kenyon Cotte       |
      |cedgeler29@nyu.edu              |M781fIv      | Chevalier Edgeler  |
      |sgjerde2a@soundcloud.com        |6WckSIYM8RGm | Sergio Gjerde      |
      |jroff2b@hibu.com                |dUMy42A5     | Janenna Roff       |
      |vvallintine2c@reference.com     |7BddnPin7D   | Valle Vallintine   |
      |mmarthen2d@blogs.com            | 35lquyW     | Maressa Marthen    |