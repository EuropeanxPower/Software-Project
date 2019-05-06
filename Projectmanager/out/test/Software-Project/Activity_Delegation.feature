Feature: Delegation of activities
The projectmanager can delegate assignments/activities to related developers of the project.

Background:
  Given These activities are contained in the system
    | Design |
    | Analyse |
    | Budget  |
  And These Projectnames are contained in the system
    | Tele-Kipper |
    | Sort-Pick |
  And These User IDs are contained in the system
    | SKP |
    | PTRO |
    | AL |

Scenario: Projectmanager delegate an activity to a member of the project
Given Developer is projectmanager of "Sort-Pick"
When delegate "SKP" the activity "Design"
Then SKP are now on the activity with name "Design"

Scenario: Projectmanager delegate an activity to a developer, who isn't on the project
Given Developer is projectmanager of "Sort-Pick"
When delegate "PPP" the activity "Design"
Then Errormessage "The developer isn't added to the project"

Scenerio: Projectmanager delegate an activity which not exists
Given Developer is projectmanager of "Sort-Pick"
When delegate "SKP" the activity "Implementing"
Then Errormessage "Activityname doesn't exists"