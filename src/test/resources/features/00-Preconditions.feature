Feature: Precondition

  Scenario: Reset the profile
    Given I launch app
    And I login with credential
      | userEmail                   | password   |
      | payalgaur151@mailinator.com | 1234567890 |
    When I click on Menu button
    And I click on Edit Profile button
    And I change the name as "Payal Gaur"
    And I change the contact number as "987654323456"
    And I save the changes
    Then I am able to see profile detail
      | name       | email                       | contactNumber |
      | Payal Gaur | payalgaur151@mailinator.com | 987654323456  |
    And I close app