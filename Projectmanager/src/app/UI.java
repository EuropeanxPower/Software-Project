package app;

import sun.net.www.content.text.plain;

public class UI {

    private String activeProject;
    private String activeActivity;
    private String userID;

    void loginScreen(int screen){
        switch(screen){
            case 1: //Login
                System.out.println("Please enter your login.");
                break;
            case 2: //Login succesful
                System.out.println("You are now logged in.");
                break;
            case 3: //Login unsuccesful
                System.out.println("User ID does not exist.");
                break;
        }
    }
    
    void startScreen(int screen){
        switch (screen){
            case 1: //Overview
                System.out.println();
                System.out.println("Please choose your next action:");
                System.out.println("Type 1 to manage an active project.");
                System.out.println("Type 2 to create new project.");
                System.out.println("Type 3 to logout.");
                break;
            case 2: //Go to project
                System.out.println("Enter active project.");
                break;
            case 3: //Go to project unsuccesful
                System.out.println("The given project does not exist.");
                break;
            case 4: //Create project
                System.out.println("Please enter the name of the project.");
                break;
            case 5: //Project Creation successful
                System.out.println("A project with name " + activeProject + " has been created.");
                break;
            case 6: //Create project failed
                System.out.println("A project with this name already exists.");
                break;
            case 7: //Go to project unsuccesful - userID doesn't have access to the project.
                System.out.println("You do not have access to the project: " + activeProject);
                break;
        }
    }

    void projectScreen(int screen){
        switch(screen){
            case 1: //Project Overview before projectmanager has been assigned
                System.out.println();
                System.out.println("Welcome to project: " + activeProject);
                System.out.println("Please choose your next action:");
                System.out.println("Type 1 to add a developer to the project.");
                System.out.println("Type 2 to assign project manager.");
                System.out.println("Type 3 to return to General Overview.");
                break;
            case 2: // Project overview for projectmanagers
                System.out.println();
                System.out.println("Welcome to project: " + activeProject);
                System.out.println("Please choose your next action:");
                System.out.println("Type 1 to pull project report.");
                System.out.println("Type 2 to add a deleloper to the project");
                System.out.println("Type 3 to add a new activity to the project.");
                System.out.println("Type 4 to manage an active project.");
                System.out.println("Type 5 to assign new project manager.");
                System.out.println("Type 6 to return to General Overview.");
                break; 
            case 3: // Project Overview for normal developer
                System.out.println();
                System.out.println("Welcome to project: " + activeProject);
                System.out.println("Please choose your next action:");
                System.out.println("Type 1 to manage an active activity.");
                System.out.println("Type 2 pull activity list for the project.");
                System.out.println("Type 3 to return to General Overview.");
                break;

            //1 - Pull project report:
            case 4: //Pull projectreport
                System.out.println("This is the project report");
                break;

            //2 - Add a new developer:
            case 5: //Add new developer to project)
                System.out.println("Please enter the userID of the developer you wish to add");
                break;
            case 6: //Given developer is now added to the project 
                System.out.println("The developer " + userID + " is now a part of " +activeProject+ ".");
                break;
            case 7: //Given developer doesn't exist 
                System.out.println("The developer" + userID + " doesn't exist");
                break;

            //3 - Add a new project:
            case 8: //Add new activity to the project
                System.out.println("Please enter the name of the activity you wish to create");
                break;
            case 9: //Add start date to new activity
                System.out.println("Please enter the start date of the activity, in the given format 'YYYY-MM-DD'.");
                break;
            case 10: //Add end date to new activity
                System.out.println("Please enter the end date of the activity, in the given format 'YYYY-MM-DD'.");
                break; 
            case 11: //The activity has now been created
                System.out.println("An activity with name " + activeActivity + " has been created.");
                break;
            case 12: //The activity creation have failed
                System.out.println("An activity with this name already exists.");
                break;
            case 13: //Incorrect dates
                System.out.println("This is not a valid date.");
                break;

            //4 - Manage an active activity:
            case 14: //Go to activity
                System.out.println("Please enter the name of the active you wish to manage.");
                break;
            case 15: //Go to activity unsuccesfully
                System.out.println("The given activity, " + activeActivity + " doesn't exist.");
                break;

            //5 - Assign new project manager
            case 16: //Assign project manager
                System.out.println("Please enter a user ID to be assigned as project manager.");
                break;
            case 17: //New projectmanager added
                System.out.println("The developer " + userID + " is now projectmanager of the project " +activeProject+".");
                break;
            case 18: //Assign project manager failed
                System.out.println("The user ID doesn't exist or is not a part of this project.");
                break;      
        }
    }

    void activityScreen(int screen){
        switch(screen){
            case 1: //Activity Overview
                System.out.println();
                System.out.println("You are now managing " +activeProject+ " - " +activeActivity);
                System.out.println("Press 1 to Log Time.");
                System.out.println("Press 2 to add a developer to this activity.");
                System.out.println("Press 3 to change the start date.");
                System.out.println("Press 4 to change the end date.");
                System.out.println("Press 5 to return to Project Overview.");
            break;
        }
    }

    public void setProjectName(String name){
        activeProject = name;
    }

    public String getProjectName() {
        return activeProject;
    }

    public void setActivityName(String name){
        activeActivity = name;
    }

    public String getActivityName(){
        return activeActivity;
    }

    public void setUserID(String name){
        userID = name;
    }

    public String getUserID(){
        return userID;
    }
}