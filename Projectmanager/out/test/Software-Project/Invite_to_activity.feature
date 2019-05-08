Feature: Invite colleage to activity
%When a developer is added to an activity, will the developer have the opportunity to add a colleage to the activity.

Background:
  Given These activities are contained in the system
    | Design |
    | Analyse |
    | Budget  |
  And These User IDs are contained in the system
    | SKP |
    | PTRO |
    | AL |

Scenario: Developer invite a colleague to the activity
Given Developer is logged in
And Developer is on the activity "Budget"
When Invite "SKP" to the activity "Budget"
Then SKP are now on the activity with name "Budget"

Scenario: Developer invite a User who not exists
Given Developer is logged in
And Developer is on the activity "Budget"
When Invite "PPP" to the activity "Budget"
Then Errormessage "User ID doesn't exists"

Scenario: Developer invite a colleague to an activity, the developer doesn't are on
Given Developer is logged in
And Developer is on the activity "Budget"
When Write "Invite" + "SKP" + "Analyse"
Then Errormessage "You can't invite to this activity"