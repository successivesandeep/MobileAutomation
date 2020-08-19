Feature: Work order automation
#
#  Background:
#    Given I launch app
#    And I login with credential
#      | userEmail                   | password   |
#      | payalgaur151@mailinator.com | 1234567890 |
#    And I click on Add work order button
#
#
#  Scenario: Create a work order
#    And I Enter data in title field as "Successive"
#    And I Enter data in description field as "Organization"
#    And I select date in due date field
#    And I select "7th floor" in facility field
#    And I select "unit7677" in unit field
#    And I select "Shashank Gwari" in assign to field
#    And I select "Low" in priority field
#    And I select "Customer Complaint" in category field
#    And I check checkboxes in notification field
#    And I check checkbox of "Shashank Gwari" in watchers field
#    And I click on create button
#    Then I will see the work order created with title "Successive" and description "Organization"
#    And I close app
#
#  Scenario: Try to create work plan without filling mandatory fields
#    And I leave the mandatory fields blank
#      | title          | description |
#      |                | Automation  |
#      | Mobile testing |             |
#      |                |             |
#    And I select "ACTIVITY FACILITY one" in facility field
#    And I select "Bbbbb" in unit field
#    And I select "Low" in priority field
#    And I click on create button
#    Then I see the error message as "Fill all the required fields properly."
#    And I close app
#
#
#  Scenario: Try to create work plan without selecting value from mandatory dropdowns
#    And I Enter data in title field as "Successive"
#    And I Enter data in description field as "Organization"
#    And I select "Low" in priority field
#    And I click on create button
#    Then  I see the error message as "Fill all the required fields properly."
#    And I close app
#
#  Scenario: Try to create work plan without selecting value from priority dropdown
#    And I Enter data in title field as "Successive"
#    And I Enter data in description field as "Organization"
#    And I select "ACTIVITY FACILITY one" in facility field
#    And I select "Bbbbb" in unit field
#    And I click on create button
#    Then I see the error message as "Fill all the required fields properly."
#    And I close app
#
#
#  Scenario: Cancellation of work order
#    When I cancel the work order creation
#    Then I navigate on "Work Order" page
#    And I close app