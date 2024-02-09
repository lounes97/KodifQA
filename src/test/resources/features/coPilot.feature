@smoke @ui
Feature: User Authentication
  User Story:
  As a user, I should be able to login with correct credentials via Salesforce platform.

  Background: Login a user
    When user enters the username
    And user enters the password
    Then user clicks on login button
    And when the user clicks on the Kodif icon, the coPilot window pops up
    When user enters the Kodif Copilot username and password
    Then user clicks on Kodif Copilot login button

  @max&min @ui
  Scenario: Maximize and minimize coPilot Window
    When the user selects the maximize option the coPilot window should expand
    And the user selects the minimize option the coPilot window should minimize

  @commandButton @ui
  Scenario: Command button in Copilot Window
    When user clicks on command button he should see at least one element

  @commandInput @ui
  Scenario: User clicks on command button and select one of the action
    When user enter a string in input field and press enter key


@dockFeature @ui
Scenario: User test Dock button
  When the user clicks on Dock button
  Then the chatbot should be docked to the left side of the screen
  When user refresh the page the chatbot should stay on the left side of the screen
  When the user clicks on Dock button
  Then the chatbot should be docked to the right side of the screen


@reloadFeature @ui
Scenario: User clicks the "Reload" button
  When the user clicks on the "Reload" button
  Then the chatbot should refresh its content


