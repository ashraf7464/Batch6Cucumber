Feature: Validate DropDown Functionality

  Background: Launching App
    Given browser is open and navigate to the Base URL

  Scenario: TC-102 DropDown functionality should work as expected
    Given user navigate to practice page
    When user click on Select an option
    And user select option One
    And user select option Two
    And user select option Three
    Then Validate Option Three is selected