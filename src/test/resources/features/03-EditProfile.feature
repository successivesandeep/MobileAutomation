Feature: Edit Profile

  Scenario: Change the name only
    Given I launch app
    And I login with credential
      | userEmail                   | password   |
      | payalgaur151@mailinator.com | 1234567890 |
    When I click on Menu button
    And I click on Edit Profile button
    And I change the name as "Sandeep Kumar"
    And I save the changes
    Then I am able to see profile detail
      | name          | email                       | contactNumber |
      | Sandeep Kumar | payalgaur151@mailinator.com | 987654323456  |
    And I close app

  Scenario: Change the contact number only
    Given I launch app
    And I login with credential
      | userEmail                   | password   |
      | payalgaur151@mailinator.com | 1234567890 |
    When I click on Menu button
    And I click on Edit Profile button
    And I change the contact number as "987654321011"
    And I save the changes
    Then I am able to see profile detail
      | name          | email                       | contactNumber |
      | Sandeep Kumar | payalgaur151@mailinator.com | 987654321011  |
    And I close app

  Scenario: Change the name and mobile number both
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

  Scenario: Profile is not updated on navigating back without saving updated profile
    Given I launch app
    And I login with credential
      | userEmail                   | password   |
      | payalgaur151@mailinator.com | 1234567890 |
    When I click on Menu button
    And I click on Edit Profile button
    And I click on back button
    Then I am able to see profile detail
      | name       | email                       | contactNumber |
      | Payal Gaur | payalgaur151@mailinator.com | 987654323456  |
    And I close app