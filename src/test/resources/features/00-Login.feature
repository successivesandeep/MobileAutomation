Feature: Login

  Scenario: Login with valid user credential
    Given I launch app
    When I enter emailId as "payalgaur151@mailinator.com"
    And I enter password as "1234567890"
    And I click on SignIn Button
    Then I navigate on "Work Order" page
    And I close app

  Scenario: Login with valid email and wrong password
    Given I launch app
    And I enter emailId as "payalgaur151@mailinator.com"
    And I enter password as "0987654321"
    And I click on SignIn Button
    Then I can see message as "Invalid email address or password."
    And I press "Ok" button
    And I close app

  Scenario: Login with invalid user credential
    Given I launch app
    And I enter emailId as "xyz@gmail.com"
    And I enter password as "12345678"
    And I click on SignIn Button
    Then I can see message as "Invalid email address or password."
    And I press "Ok" button
    And I close app

  Scenario: Login without user credential
    Given I launch app
    And I click on SignIn Button
    Then I can see message as "Email address cannot be empty."
    And I press "Ok" button
    And I close app
