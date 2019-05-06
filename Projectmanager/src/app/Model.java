package app;

import java.util.ArrayList;
import java.util.Arrays;

public class Model{
    private Developer VWJ = new Developer("VWJ");
    private Developer NIC = new Developer("NIC");
    private Developer CP = new Developer("CP");
    private Developer TMY = new Developer("TMY");
    private Project TeleKipper = new Project("Tele-Kipper",TMY);
    private Project SortPick = new Project("Sort-Pick",VWJ);
    private Developer currentUser;
    private Project currentProject;
    private ArrayList<Developer> userIDs = new ArrayList<Developer>(Arrays.asList(VWJ,NIC,CP,TMY));
    public ArrayList<Project> projectNames = new ArrayList<Project>(Arrays.asList(TeleKipper, SortPick));
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
            new Error("Given projectname dosn't exist");
        }
        return nameExists;
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
            if (name.getdeveloper().contains(developer)){
                name.setProjectmanager(developer);
            }
            else {
                errorMessage = "User ID doesn't exist";
                new Errorhandler("User ID doesn't exist");
            }
        }
        else if (name.getProjectmanager() != null){
            if ((name.getProjectmanager()==assigner)&&(name.getdeveloper().contains(developer))) {
                name.setProjectmanager(developer);
            }
            else{
                errorMessage = "Only the projectmanager can assign a new projectmanager to this project";
                new Errorhandler("Only the projectmanager can assign a new projectmanager to this project");
            }
        }
    }

    public void addVacation(Developer developer, String start, String end) {
        if (!userIDs.contains(developer)){
            new Errorhandler("This User ID doesn't exists");
        } else {

        }
    }
}