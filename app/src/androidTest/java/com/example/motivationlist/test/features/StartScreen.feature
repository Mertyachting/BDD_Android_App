Feature: Start screen
  The User should be able to enter his name

  Scenario Outline: <name> wants to use the app
    Given <name> opens the app for the first time
    And <name> sees the Start screen
    When <name> enters his name
    And click done
    Then <name> should see his <name>

    Examples:

      | name    |
      | Mert    |
      | Tatjana |



