Feature: Assign projectmanager
  Description: Every developer, whom are logged in, can create a project.
  Actors: Developer

  Background:
    Given These Projectnames are contained in the system
      | Tele-Kipper |
      | Sort-Pick |
    And These User IDs are contained in the system
      | SKP |
      | PTRO |
      | AL |
    And These User IDs are contained in the project "Sort-Pick"
      | SKP |
      | PTRO |
      | AL |


  Scenario: Developer assigns projectmanager
    Given Developer is logged in
    And Developer is a part of "Sort-Pick"
    And The project does not have a projectmanager
    When add projectmanager "PTRO"
    Then The projectmanager is assigned to the project

  Scenario: Developer cannot assign a new projectmanager
    Given Developer is logged in
    And Developer is a part of "Sort-Pick"
    And The project has a projectmanager
    When add projectmanager "AL"
    Then Errormessage "Only the projectmanager can assign a new projectmanager to this project"

  Scenario: Projectmanager assigns new projectmanager
    Given Developer is logged in
    And Developer is projectmanager of "Sort-Pick"
    When add projectmanager "PTRO"
    Then The projectmanager is assigned to the project

  Scenario: Developer write a false User ID
    Given Developer is logged in
    And Developer is a part of "Sort-Pick"
    When add projectmanager "PPP"
    Then Errormessage "User ID doesn't exist"