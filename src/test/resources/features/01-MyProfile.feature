Feature: My Profile

  Scenario: See the profile created date
    Given I launch app
    And I login with credential
      | userEmail                   | password   |
      | payalgaur151@mailinator.com | 1234567890 |
    When I click on Menu button
    Then profile created date is displaying as "26 Nov 2019"
    And I close app