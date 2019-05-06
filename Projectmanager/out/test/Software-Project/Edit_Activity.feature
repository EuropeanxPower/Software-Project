Feature: Edit activity
The projectmanager can edit the startdate, deadline and expected use of time on an activity.

Background:
  Given these activities are contained in the system
    | Design |
    | Analyse |
    | Budget  |
  And These Projectnames are contained in the system
    | Tele-Kipper |
    | Sort-Pick |

Scenario: Projectmanager edit an activity
Given Developer is logged in
And Developer is projectmanager of "Sort-Pick"
When edit activity "Design"
Then The activity with name "Design" has been edited

Scenario: Projectmanager indicate an activityname, which doesn't exists
Given Developer is logged in
And Developer is projectmanager of "Sort-Pick"
When edit activity "bingo"
Then Errormessage "Activityname doesn't exists"

Scenario: Developer try to edit activity
Given Developer is logged in
And Developer is a part of "Sort-Pick"
When edit activity "Design"
Then Errormessage "It's only the projectmanager, who can edit an activity"