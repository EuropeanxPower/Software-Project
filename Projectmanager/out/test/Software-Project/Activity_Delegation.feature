Feature: Delegation of activities
The projectmanager can delegate assignments/activities to related developers of the project.

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
  And these activities are contained in the project "Sort-Pick"
    | Design |
    | Analyse |
    | Budget  |

Scenario: Projectmanager delegate an activity to a member of the project
Given Developer is logged in
And Developer is projectmanager of "Sort-Pick"
When delegate "PTRO" the activity "Design"
Then "PTRO" are now on the activity with name "Design"

Scenario: Projectmanager delegate an activity to a developer, who isn't on the project
Given Developer is logged in
And Developer is projectmanager of "Sort-Pick"
When delegate "AL" the activity "Design"
Then Errormessage "The developer isn't added to the project"
