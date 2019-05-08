package app;

import javax.sound.sampled.SourceDataLine;

// Case 1 is Login Screen
// Case 2 is General Overview
// Case 3 is Project Overview
// Case 4 is Create Project
// Case 5 is Add New Developer to System
// Case # is Go to project "..."

public class UI {

    private String activeProject;

    void screen(int screen){
        switch (screen){
            case 1: //Login
                System.out.println("Please enter your login.");
                break;
            case 2: //Login succesful
                System.out.println("You are now logged in.");
                break;
            case 3: //Login unsuccesful
                System.out.println("User ID does not exist.");
                break;
            case 4: //Overview
                System.out.println("Please choose your next action:");
                System.out.println("Type 1 to manage an active project.");
                System.out.println("Type 2 to create new project.");
                break;
            case 5: //Go to project
                System.out.println("Enter active project.");
                break;
            case 6: //Go to project unsuccesful
                System.out.println("The given project does not exist.");
                break;
            case 7: //Create project
                System.out.println("Please enter the name of the project.");
                break;
            case 8: //Create project failed
                System.out.println("A project with this name already exists.");
                break;
            case 9: //Project Creation
                System.out.println("A project with name " + activeProject + " has been created.");
                break;
            case 10: //Project Overview
                System.out.println("Welcome to project: " + activeProject);
                System.out.println("Please choose your next action:");
                System.out.println("Type 1 to manage an active activity.");
                System.out.println("Type 2 to assign project manager.");
                System.out.println("Type 3 to add developer to project.");
                System.out.println("Type 4 to add an activity to project.");
                System.out.println("Type 5 to get project report.");
                System.out.println("Type 6 to return to General Overview.");
                break;
            case 11: //Go to project unsuccesful - userID doesn't have access to the project.
                System.out.println("You do not have access to the project: " + activeProject);
                break;
            case 12: //Go to activity
                System.out.println("Please enter the name of the activity.");
                break;
            case 13: //Go to activity failed
                System.out.println("The given activity does not exist.");
                break;
            case 14: //Need project manager permission
                System.out.println("Only the project manager may use this function.");
                break;
            case 15: //Assign project manager
                System.out.println("Please enter a user ID to be assigned as project manager.");
                break;
            case 16: //Assign project manager failed
                System.out.println("The user ID does not exist or is not a part of this project.");
                break;
            case 17: //Add developer to 
                break;
            case 18: //Get projectreport.

                break;
            case 19: //Start date of an activity
                System.out.println("Please enter the start date of the activity in given format 'YYYY-MM-DD'.");
                break;
            case 20: //End date of an activity
                System.out.println("Please enter the end date of the activity in given format 'YYYY-MM-DD'.");
                break;
            case 21: //Create activity failed
                System.out.println("A activity with this name already exists.");
                break;
            case 22: //Successful activity Creation
                System.out.println("A activity with name " + activeProject + " has been created.");
                break;
            case 23: //Incorrect dates
                System.out.println("This is not a valid date.");
                break;
            case 24: //Projectmanager set
                System.out.println("The projectmanager of " +activeProject+ " has been set.");
                break;
            case 25: // Developer not part of project
                System.out.println("The given developer is not a part of the current project or does not exist.");
                break;
        }
    }

    public String getProjectName() {
        return activeProject;
    }

    public void setProjectName(String name){
        activeProject = name;
    }
}