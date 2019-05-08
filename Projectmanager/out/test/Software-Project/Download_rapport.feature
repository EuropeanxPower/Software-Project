Feature: Download rapport
Projektlederen skal kunne indhente en rapport over tidsforbrug på aktiviteter og projektet alt i alt.

Background:
Given These Projectnames are contained in the system
  | Tele-Kipper |
  | Sort-Pick |

Scenario: Projectmanager download a rapport
Given Developer is logged in
And Developer is projectmanager of "Tele-Kipper"
When Download "Tele-Kipper"
Then Projectmanager dowloaded the use of time on on the project "Tele-Kipper"

Scenario: Developer can't download, because he is not projectmanager
Given Developer is logged in
And Developer is projectmanager of "Tele-Kipper"
When Download "Sort-Pick"
Then Errormessage "It's only the projectmanager, who can download a rapport"