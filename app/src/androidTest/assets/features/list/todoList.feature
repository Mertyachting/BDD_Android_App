Feature: ToDos
  User is able to create todos for his Motivation List

  Scenario: Bob wants to enter Todos in his Motivation List
    Given Bob has created a Motivation List
    When Bob clicks on the add symbol on the bottom
    And enters the name of his todo
    Then He should be able to see his Todo