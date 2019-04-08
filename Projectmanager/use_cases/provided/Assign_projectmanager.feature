Feature: Create project
  Description: Every developer, whom are logged in, can create a project.
  Actors: Developer

  Background:
    Given These User IDs are contained in the system
      | SKP |
      | PTRO |
      | AL |
    Given These Projectnames are contained in the system
      | Tele-Kipper |
      | Sort-Pick |

  Scenario: Developer assigns projectmanager
    Given Developer is logged in
    And Developer is a part of "Sort-Pick"
    And The project does not have a projectmanager
    When Write "add projectmanager" + "PTRO"
    Then The projectmanager is assigned to the project

  Scenario: Developer cannot assign a new projectmanager
    Given Developer is logged in
    And Developer is a part of "Sort-Pick"
    And The project has a projectmanager
    When Write "add projectmanager" + "AL"
    Then Errormessage "Only the projectmanager can assign a new projectmanager to this project"

  Scenario: Developer assigns projectmanager
    Given Developer is logged in
    And Developer is a part of "Sort-Pick"
    And The project does not have a projectmanager
    When Write "add projectmanager" + "PTRO"
    Then The projectmanager is assigned to the project