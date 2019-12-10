Feature: Share via Bluetooth
  User should be able to share his list via bluetooth

  Scenario: Bob wants to share his List via bluetooth
    Given Bob can see the device he wants to share his file with
    When Bob clicks the device
    And cofirms he wants to share his list
    Then Bob should see his file was sent

