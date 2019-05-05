package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Model{
	private Calender calendar = new Calender();
	private Developer VWJ = new Developer("VWJ");
	private Developer NIC = new Developer("NIC");
	private Developer CP = new Developer("CP");
	private Developer TMY = new Developer("TMY");
	private Project TeleKipper = new Project("Tele-Kipper", calendar.createCalendar(2019,5,1), calendar.createCalendar(2019,7,15),TMY);
	private Project SortPick = new Project("Sort-Pick", calendar.createCalendar(2019,5,1), calendar.createCalendar(2019,9,1),VWJ);
    private Developer currentUser;
    private ArrayList<Developer> userIDs = new ArrayList<Developer>(Arrays.asList(VWJ,NIC,CP,TMY));
    private ArrayList<Project> projectNames = new ArrayList<Project>(Arrays.asList(TeleKipper, SortPick));
    private boolean loggedIn = false;
    private String errorMessage;

    public String getCurrentUserID(){
        return currentUser.getUserId();
    }
    
    public Developer getCurrentUser() {
    	return currentUser;
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

    public boolean createProject(String name, GregorianCalendar start, GregorianCalendar end, Developer userID){
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
            projectNames.add(new Project(name,start,end,userID));
        }
        return nameExists;
    }

    public void addToProject(Developer developer, Project name, Developer inviter){
        if (name.getProjectmanagerID == null){
            if (!userIDs.contains(developer)){
                errorMessage = "User ID doesn't exists";
                new Errorhandler("User ID doesn't exists");
            } else {
                name.add
            }
        }
        else if (name.getProjectmanagerID == inviter){
            if (!userIDs.contains(developer)){
                errorMessage = "User ID doesn't exists";
                new Errorhandler("User ID doesn't exists");
            } else {
    
            } 
        }
        else{
            errorMessage = "Only the projectmanager may add colleages to the project";
            new Errorhandler("Only the projectmanager may add colleages to the project");
        }
    }

    public void addVacation(Developer developer, GregorianCalendar start, GregorianCalendar end) {
        if (!userIDs.contains(developer)){
            new Errorhandler("This User ID doesn't exists");
        } else {

        }
    }
}