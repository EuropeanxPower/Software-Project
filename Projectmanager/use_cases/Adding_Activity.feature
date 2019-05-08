Feature: Adding an activity
The projectmanager can add an activity. Here will the projetmanager indicate a start and a deadline of the project,
and the expected use of time, on Weeknumber-level.\\

Background:
  Given these activities are contained in the system
    | Design |
    | Analyse |
    | Budget  |
  And These Projectnames are contained in the system
    | Tele-Kipper |
    | Sort-Pick |

Scenario: Projectmanager add an activity
  Given Developer is logged in
  And Developer is projectmanager of "Sort-Pick"
  When add activity "Implementing"
  Then An activity is added

Scenario: Developer try to add an activity
  Given Developer is logged in
  And Developer is a part of "Sort-Pick"
  When add activity "Implementing"
  Then Errormessage "It's only the projectmanager, who can add an activity"

Scenario: Projectmanager indicate a name, which already exists
  Given Developer is logged in
  And Developer is projectmanager of "Sort-Pick"
  When add activity "Implementing"
  Then Errormessage "There are already an activity with this name"