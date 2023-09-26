Feature: Validate Mouse Hover Functionality

  Background: Launching App
    Given user opens browser and navigate to Practice Page

  Scenario: TC-105 Mouse Over functionality should work as expected
    When user hover the mouse over the Main Item Two
    When user hover the mouse over the Sub Sub List
    Then user can select Sub Sub Item One using Action Class
    Then user validate Sub Sub Item is selected
