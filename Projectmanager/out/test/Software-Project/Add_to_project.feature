  Feature: Ad to proejct
  Description: The developer, whom has created the project can invite colleages to the project, 
  and the invited colleages can invite other colleages, 
  but only if there has not been assigned a projectmanager.
  Actors: Developer

  Background:
    Given These User IDs are contained in the system
      | SKP |
      | PTRO |
      | AL |
    And These Projectnames are contained in the system
      | Tele-Kipper |
      | Sort-Pick |

  Scenario: Developer adds a colleage to project
    Given Developer is logged in
    And Developer is a part of "Sort-Pick"
    And The project does not have a projectmanager
    When add developer "AL"
    Then A developer is added

  Scenario: Developer cannot add a colleage to project
    Given Developer is logged in
    And Developer is a part of "Sort-Pick"
    And The project has a projectmanager
    When add developer "PTRO"
    Then Errormessage "Only the projectmanager may add colleages to the project"

  Scenario: Developer adds a colleage to project
    Given Developer is logged in
    And Developer is a part of "Sort-Pick"
    When add developer "PPP"
    Then Errormessage "User ID doesn't exist"

  Scenario: Projectmanager adds a colleage to project
    Given Developer is logged in
    And Developer is projectmanager of "Sort-Pick"
    When add developer "PTRO"
    Then A developer is added