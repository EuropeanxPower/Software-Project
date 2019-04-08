Feature: Log in
  Description: Checking that the written User ID exists, and if it does, you are logged in
  Actors: User

  Background:
    Given These User IDs are contained in the system
      | SKP |
      | PTRO |
      | AL |

  Scenario: User ID exists
    Given User ID exists
    When Write "log in" + "SKP"
    Then User is logged in

  Scenario: User ID doesn't exists
    Given User ID doesn't exists
    When Write "log in" + "PPP"
    Then Errormessage "User ID doesn't exists"