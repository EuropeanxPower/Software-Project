Feature: Adding an activity
The projectmanager can add an activity. Here will the projetmanager indicate a start and a deadline of the project,
and the expected use of time, on Weeknumber-level.\\

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
  And these activities are contained in the project "Sort-Pick"
    | Design |
    | Analyse |
    | Budget  |

Scenario: Projectmanager add an activity
  Given Developer is logged in
  And Developer is projectmanager of "Sort-Pick"
  When add activity "Implementing"
  Then An activity with name "Implementing" is added

Scenario: Developer try to add an activity
  Given Developer is logged in
  And Developer is a part of "Sort-Pick"
  When add activity "Implementing"
  Then Errormessage "It's only the projectmanager, who can add an activity"

Scenario: Projectmanager indicate a name, which already exists
  Given Developer is logged in
  And Developer is projectmanager of "Sort-Pick"
  When add activity "Design"
  Then Errormessage "There are already an activity with this name"