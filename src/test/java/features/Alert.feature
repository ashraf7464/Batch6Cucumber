Feature: Validate DropDown & iFrame Functionality

  Background: Practice page should be open
    Given Open browser and navigate to Base URL

  Scenario: TC-103 Alert functionality should work as expected
    Given user navigate to the practice page
    When user click on Try It
    And user validate Alert box is present
    Then User accept the alert
    

  Scenario: TC-104 iFrame functionality should work as expected
    Given user navigates to practice page
    When user switch to iFrame
    And user click on Practice page link
