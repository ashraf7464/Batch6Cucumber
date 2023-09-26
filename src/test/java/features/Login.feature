Feature: Login Feature

  Background: The Login Page should be open
    Given browser is open and navigate to Base URL

    Scenario Outline: TC-101 Valid User should be able to log into the application
      Given user navigate to login page
      When user enters valid <userName>
      And user enter a valid <password>
      And user click on Login
      Then Validate that user is on the Home Page


      Examples:

      | userName      | password          |
      | "ashraf1122"  | "Black1234"       |
      | "ashraf9999"  | "RedDragon1122"   |
      | "ashraf7464"  | "Macintosh@1082"  |

