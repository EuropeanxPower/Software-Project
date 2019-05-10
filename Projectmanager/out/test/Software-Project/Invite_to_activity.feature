Feature: Invite colleage to activity
%When a developer is added to an activity, will the developer have the opportunity to add a colleage to the activity.

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

Scenario: Developer invite a colleague to the activity
Given Developer is logged in
And Developer is on the activity "Budget"
When Invite "AL" to the activity "Budget"
Then "AL" are now on the activity with name "Budget"

Scenario: Developer invite a User who not exists
Given Developer is logged in
And Developer is on the activity "Budget"
When Invite "PPP" to the activity "Budget"
Then Errormessage "User ID doesn't exists"

Scenario: Developer invite a colleague to an activity, the developer doesn't are on
Given Developer is logged in
And Developer is on the activity "Budget"
When Invite "AL" to the activity "Analyse"
Then Errormessage "You can't invite to this activity"