package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Model{
    private Developer VWJ = new Developer("VWJ");
    private Developer NIC = new Developer("NIC");
    private Developer CP = new Developer("CP");
    private Developer TMY = new Developer("TMY");
    private Project TeleKipper = new Project("Tele-Kipper",TMY);
    private Project SortPick = new Project("Sort-Pick",VWJ);
    private Project Pesto = new Project("Pesto",NIC);
    private Developer currentUser;
    private Project currentProject;
    private ArrayList<Developer> userIDs = new ArrayList<Developer>(Arrays.asList(VWJ,NIC,CP,TMY));
    public ArrayList<Project> projectNames = new ArrayList<Project>(Arrays.asList(TeleKipper, SortPick, Pesto));
    private boolean loggedIn = false;
    private String errorMessage;

    // Returns the logged in user - Christian
    public Developer getCurrentUser() {
        return currentUser;
    }

    // Assigns the current project - Christian
    public void setCurrentProject(Project p){
        currentProject=p;
    }

    // Returns the current project - Christian
    public Project getCurrentProject(){
        return currentProject;
    }

    // Return the loggedIn status - Thomas
    public boolean getLoggedIn(){
        return loggedIn;
    }
    //return the errorMessage - Vivian
    public String getErrorMessage(){
        return errorMessage;
    }

    //Returns the list of projects - Nicklas
    public ArrayList<Project> getProjectNames(){
        return projectNames;
    }

    //For the tests - A given set og projects will be set as the list of projects in the system - Vivian
    public void setProjectNames(ArrayList<Project> datatable){
        projectNames = datatable;
    }

    //For the tests - A given team will be set as the list of users in the system - Vivian
    public void setUserIDs(ArrayList<Developer> datatable){
        userIDs = datatable;
    }

    //Returns the list of users - Nicklas
    public ArrayList<Developer> getUserIDs(){
        return userIDs;
    }

    // Checks is given projectname already exists - Nicklas
    public boolean findProject(String name){
        boolean nameExists = false;
        for (Project p : projectNames){
            if(p.getName().equals(name)){
                nameExists = true;
            }
        }
        if (!nameExists){
            errorMessage = "Given projectname dosn't exist";
            new Errorhandler("Given projectname doesn't exist");
        }
        return nameExists;
    }

    // Checks is given projectname already exists - Nicklas
    public boolean findDeveloper(String name){
        boolean nameExists = false;
        for (Developer d : userIDs){
            if(d.getUserId().equals(name)){
                nameExists = true;
            }
        }
        if (!nameExists){
            errorMessage = "Given developer does not exist";
            new Errorhandler("Given developer does not exist");
        }
        return nameExists;
    }

    // Checks if given developer exists and return the user - Nicklas
    public Developer getDeveloper(String name){
        boolean nameExists = false;
        for (Developer d: userIDs){
            if(d.getUserId().equals(name)){
                return d;
            }
            if (!nameExists){
                errorMessage = "Given projectname dosn't exist";
                new Errorhandler("Given projectname doesn't exist");
            }
        }
        return null;
    }

    // Checks if given project exists and return the project - Christian
    public Project getProject(String name){
        boolean nameExists = false;    
        for (Project p : projectNames){
            if(p.getName().equals(name)){
                return p;
            }
        }
        if (!nameExists){
            errorMessage = "Given projectname dosn't exist";
            new Errorhandler("Given projectname doesn't exist");
        }
        return null;
    }

    //Check if the written userID exist in the system - Thomas
    public boolean Login(String userID) {
        boolean idExists = false;
        for(Developer d : userIDs){
            if (d.getUserId().equals(userID)){
                currentUser = d;
                loggedIn = true;
                idExists = true;
            }
        }
        if (!idExists) {
            errorMessage = "User ID doesn't exist";
            new Errorhandler("User ID doesn't exist");
        }
        return idExists;
    }

    // Changes the login boolean to false - Thomas
    public void logout(String userID){
        loggedIn = false;
    }
    
    //Check if the projectname exist. If not, a new project will be created - Vivian
    public boolean createProject(String name, Developer userID){
        boolean nameExists = false;
        for (Project p : projectNames){
            if (name.equals(p.getName())){
                nameExists = true;
                errorMessage = "A project with this name already exists";
                new Errorhandler("A project with this name already exists");
                break;
            }
        }
        if(!nameExists){
            projectNames.add(new Project(name,userID));
        }
        return nameExists;
    }
    //All developers can invite to the project, while they are a part of the project and the project does not have a projectmanagaer
    //If there are a projectmanger, it is only the projectmanager, who can invite more developers to the project - Vivian
    public void addToProject(Developer developer, Project name, Developer inviter){
        if (name.getProjectmanager() == null){
            if (!userIDs.contains(developer)){
                errorMessage = "User ID doesn't exist";
                new Errorhandler("User ID doesn't exist");
            } else {
                name.addDeveloper(developer);
            }
        }
        else if (name.getProjectmanager() == inviter){
            if (!userIDs.contains(developer)){
                errorMessage = "User ID doesn't exist";
                new Errorhandler("User ID doesn't exist");
            } else {
                name.addDeveloper(developer);
            }
        }
        else{
            errorMessage = "Only the projectmanager may add colleages to the project";
            new Errorhandler("Only the projectmanager may add colleages to the project");
        }
    }


    //While there aren't a projectmanager, all developers at the project can assign one.
    //If there are a projectmanager, its only himself, who can assign a new one - Vivian
    public void assignProjectmanager(Developer developer, Project name, Developer assigner){
        if (name.getProjectmanager() == null){
            if (name.getDevelopers().contains(developer)){
                name.setProjectmanager(developer);
            }
            else {
                errorMessage = "User ID doesn't exist";
                new Errorhandler("User ID doesn't exist");
            }
        }
        else if (name.getProjectmanager() != null){
            if ((name.getProjectmanager()==assigner)&&(name.getDevelopers().contains(developer))) {
                name.setProjectmanager(developer);
            }
            else{
                errorMessage = "Only the projectmanager can assign a new projectmanager to this project";
                new Errorhandler("Only the projectmanager can assign a new projectmanager to this project");
            }
        }
    }

    // Adds the new developer to the system - Nicklas
    public void newDeveloper (Developer developer) {
        String userID = developer.getUserId().toUpperCase();
        if (!userID.toUpperCase().matches("^[a-zA-Z]+$")) {
            new Errorhandler("The userID may only contain letters");
        } else if (userID.length() > 4) {
            new Errorhandler("The userID may not contain more then 4 letters");
        } else if (findDeveloper(userID.toUpperCase())) {
            new Errorhandler("The given userID already exists");
        } else {
            developer.setUserID(userID);
            userIDs.add(developer);
        }
    }

    // Adds the new developer - Nicklas
    public void addDeveloper (String userID){
        Developer newUserID = new Developer(userID);
        newDeveloper(newUserID);
    }

    // Print a report for the given project - Nicklas
    public String[] getReport(){
        String[] report = new String[3];
        report[0] = "Name of the project: " + getCurrentProject().getName() + " and the project ID: " + getCurrentProject().getProjectSN();
        report[1] = "Projectmanager: " + getCurrentProject().getProjectmanager().getUserId();
        report[2] = "Activities: ";
        return report;
    }

    // Adds an activity to the current project - Christian
    public boolean addActivity(String activityName, String start, String end, Project project) {
        boolean activityAdded;
        if (findActivity(activityName, project) != -1) {
            activityAdded = false;
            errorMessage = "There are already an activity with this name";
        } else {
            if (project.getProjectmanager()==currentUser) {
                project.getActivityList().add(new Activity(activityName, start, end));
                activityAdded = true;
            }
            else{
                errorMessage = "It's only the projectmanager, who can add an activity";
                activityAdded = false;
            }
        }
        return activityAdded;
    }

    // Find given activity and return its location - Thomas
    public int findActivity(String name, Project project) {
        for (int a = 0; a < project.getActivityList().size(); a++)
            if (project.getActivityList().get(a).getName().equals(name)) {
                return a;
            }
        return -1;

    }
 
    // Returns an array of userIDs of developers available in the whole period of an activity - Thomas 
    public String[] getFreeDevelopers() {
    	String[] freeDevelopers = new String[currentProject.getDevelopers().size()];
		int nmbrOfDevs = 0;
		
		for(Developer d : currentProject.getDevelopers()) {
			try {
				if(!currentProject.getCurrentActivity().getDevelopers().contains(d) && d.isFree(currentProject.getCurrentActivity())) {
					freeDevelopers[nmbrOfDevs] = d.getUserId();
					nmbrOfDevs++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    	return freeDevelopers;
    }

    // Add a developer, who is part of the current project to the current activity - Christian
    public void addDeveloperActivity(Developer userID){
        if ((getCurrentProject().getProjectmanager() != currentUser) && (!getCurrentProject().getCurrentActivity().getDevelopers().contains(currentUser))){
            new Errorhandler("You can't invite to this activity");
            errorMessage = "You can't invite to this activity";
        }
        else if (!userIDs.contains(userID)){
            new Errorhandler("User ID doesn't exists");
            errorMessage = "User ID doesn't exists";
        }
        else if (!getCurrentProject().getDevelopers().contains(userID)){
            new Errorhandler("The developer isn't added to the project");
            errorMessage = "The developer isn't added to the project";
        }    
        else if (getCurrentProject().getCurrentActivity().getDevelopers().contains(userID)){
            new Errorhandler("Developer is already contained in the activity.");
            errorMessage = "Developer is already contained in the activity.";
        }
        else{
            currentProject.getCurrentActivity().addDeveloper(userID);
            userID.addActivity(currentProject.getCurrentActivity());
        }
    }
    
}