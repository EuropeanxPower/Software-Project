Feature: Timeregistration
%When a developer has been added or invited to an activity, the developer should registrate the use of time
on the activity. The developer should registrate with halfhour intervals.

Scenario: Developer registrate a time
Given Developer is logged in
When Registrate "4.5"
Then Developer registrate a time