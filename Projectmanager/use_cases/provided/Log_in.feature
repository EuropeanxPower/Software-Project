Feature: Log in
  Description: Checking that the written User ID exists, and if it does, you are logged in
  Actors: Developer

Background:
      Given These User IDs are contained in the system
      | SKP |
      | PTRO |
      | AL |

Scenario: User ID exists
  When Login with "SKP"
  Then User is logged in


Scenario: User ID doesn't exists
    When Login with "PPP"
    Then Errormessage "User ID doesn't exists"