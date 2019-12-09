Feature: Quotes
  The user should be able to see motivational quotes

  Scenario Outline: Bob uses the app
    Given Bob is in the app
    When Bob is in the <view>
    Then He should see <quotes> at the bottom of the screen

Examples:

  | view           | quotes                                                                   |
  | start screen   | Your "I CAN" is more important than your IQ.                             |
  | motivationList | The smallest of actions is always better than the noblest of intentions. |
  | todoList       | the purpose of life is the life of purpose                               |