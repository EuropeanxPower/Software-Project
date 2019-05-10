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


    public Developer getCurrentUser() {
        return currentUser;
    }

    public void setCurrentProject(Project p){
        currentProject=p;
    }

    public Project getCurrentProject(){
        return currentProject;
    }

    public boolean getLoggedIn(){
        return loggedIn;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public void setErrorMessage(String error){
        errorMessage = error;
    }

    public ArrayList<Project> getProjectNames(){
        return projectNames;
    }

    public void setProjectNames(ArrayList<Project> datatable){
        projectNames = datatable;
    }

    public void setUserIDs(ArrayList<Developer> datatable){
        userIDs = datatable;
    }

    public ArrayList<Developer> getUserIDs(){
        return userIDs;
    }

    public boolean findProject(String name){
        boolean nameExists = false;
        for (Project p : projectNames){
            if(p.getName().equals(name)){
                nameExists = true;
            }
        }
        if (!nameExists){
            errorMessage = "Given projectname dosn't exist";
            new Error("Given projectname doesn't exist");
        }
        return nameExists;
    }

    public boolean checkProjectSN(String SN){
        boolean snExists = false;
        for (Project p : projectNames){
            if(p.getProjectSN().equals(SN)){
                snExists = true;
            }
        }
        return snExists;
    }

    public boolean findDeveloper(String name){
        boolean nameExists = false;
        for (Developer d : userIDs){
            if(d.getUserId().equals(name)){
                nameExists = true;
            }
        }
        if (!nameExists){
            errorMessage = "Given developer does not exist";
            new Error("Given developer does not exist");
        }
        return nameExists;
    }

    public Developer getDeveloper(String name){
        boolean nameExists = false;
        for (Developer d: userIDs){
            if(d.getUserId().equals(name)){
                return d;
            }
            if (!nameExists){
                errorMessage = "Given projectname dosn't exist";
                new Error("Given projectname doesn't exist");
            }
        }
        return null;
    }

    public Project getProject(String name){
        boolean nameExists = false;    
        for (Project p : projectNames){
            if(p.getName().equals(name)){
                return p;
            }
        }
        if (!nameExists){
            errorMessage = "Given projectname dosn't exist";
            new Error("Given projectname doe" +
                    "sn't exist");
        }
        return null;
    }

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

    public void logout(String userID){
        loggedIn = false;
    }

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

    public void addDeveloper (String userID){
        Developer newUserID = new Developer(userID);
        newDeveloper(newUserID);
    }

    public String[] getReport(){
        String[] report = new String[3];
        report[0] = "Name of the project: " + getCurrentProject().getName() + " and the project ID: " + getCurrentProject().getProjectSN();
        report[1] = "Projectmanager: " + getCurrentProject().getProjectmanager().getUserId();
        report[2] = "Activities: ";
        return report;
    }

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
    public int findActivity(String name, Project project) {
        for (int a = 0; a < project.getActivityList().size(); a++)
            if (project.getActivityList().get(a).getName().equals(name)) {
                return a;
            }
        return -1;

    }
    
    public void addToActivity(String userID) {
    	currentProject.getCurrentActivity().addDeveloper(getDeveloper(userID));
    	getDeveloper(userID).addActivity(currentProject.getCurrentActivity());
    }
    
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

    public void addDeveloperActivity(Developer userID){
        if ((getCurrentProject().getProjectmanager() != currentUser) && (!getCurrentProject().getCurrentActivity().getDevelopers().contains(currentUser))){
            new Errorhandler("You are not the project manager nor assigned to this task.");
            errorMessage = "You are not the project manager nor assigned to this task.";
        }
        else if (!getCurrentProject().getDevelopers().contains(userID)){
            new Errorhandler("Developer isn't add to the project");
            errorMessage = "Developer isn't add to the project";
        }    
        else if (getCurrentProject().getCurrentActivity().getDevelopers().contains(userID)){
            new Errorhandler("Developer is already contained in the activity.");
            errorMessage = "Developer is already contained in the activity.";
        }
        else{
        getCurrentProject().getCurrentActivity().getDevelopers().add(userID);
        }
    }
    
}