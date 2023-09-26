Feature: Window Handles Functionality

  Background: Launching App
    Given user is in the Practice Page

  Scenario: TC-106 Mouse Over functionality should work as expected
    When user click on the Open Window button
    Then validate that user can switch to the second window
    Then validate that user can switch to first window
