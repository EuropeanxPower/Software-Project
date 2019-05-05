Feature: Create project
  Description: Every developer, whom are logged in, can create a project.
  Actors: Developer

  Background:
    Given These User IDs are contained in the system
      | SKP |
      | PTRO |
      | AL |
    And These Projectnames are contained in the system
      | Tele-Kipper |
      | Sort-Pick |


  Scenario: Developer add a project
    Given Developer is logged in
    When Add project with name "Boost-Fix"
    Then A project with name "Boost-Fix" is added

  Scenario: Developer indicates a name, which already exists
    Given Developer is logged in
    When Add project with name "Tele-Kipper"
    Then Errormessage "A project with this name already exists"