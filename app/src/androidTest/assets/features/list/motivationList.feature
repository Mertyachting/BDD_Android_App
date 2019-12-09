Feature: Motivation List
  User should will be able to create a motivation list and inside
  this list he will be able to create tasks to reach his goal

  Scenario: Bob wants to create a Motivation List
    Given Bob is has started the App
    And is has passed the start screen
    When Bob clicks on the add icon
    And enters a name for his Motivation
    Then he sould see the Motivation list

