Feature: Filter directory

  Background:
    Given I launch app
    And I login with credential
      | userEmail                   | password   |
      | payalgaur151@mailinator.com | 1234567890 |

  Scenario: Filter the directory with vendor name
    When I navigate on directory page
    Then I can filter the directory by vendor name "ACHIN"
    And I close app

  Scenario: Filter the directory with user partial vendor name
    When I navigate on directory page
    Then I can filter the directory by vendor partial name "CHIN"
    And I close app

  Scenario: Filter the directory with vendor type
    When I navigate on directory page
    Then I can filter the directory by vendor type "Kiosk Support"
    And I close app

  Scenario: Filter the directory with user partial vendor type
    When I navigate on directory page
    Then I can filter the directory by vendor type with partial text "iosk"
    And I close app

  Scenario: Filter the directory with vendor type by selecting drop down
    When I navigate on directory page
    Then I can filter the directory by vendor type "Camera Support" by selecting through dropdown
    And I close app