Feature: Bluetooth find
  User should be able to see the devices around him via bluetooth


  Scenario: Bob wants to find another device via bluetooth
    Given Bob is in the Bluetooth menu
    When Bob turn Bluetooth on
    Then Bob should see other Devices