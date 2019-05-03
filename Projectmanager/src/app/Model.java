package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Model{
    Developer VWJ = new Developer("VWJ");
    Developer NIC = new Developer("NIC");
    Developer CP = new Developer("CP");
    Developer TMY = new Developer("TMY");
    Project TeleKipper = new Project("Tele-Kipper", createCalendar(2019,5,1), createCalendar(2019,7,15),TMY);
    Project SortPick = new Project("Sort-Pick", createCalendar(2019,5,1), createCalendar(2019,9,1),VWJ);
    private String currentUserID;
    private ArrayList<Developer> userIDs = new ArrayList<Developer>(Arrays.asList(VWJ,NIC,CP,TMY));
    public ArrayList<Project> projectNames = new ArrayList<Project>(Arrays.asList(TeleKipper, SortPick));
    private Boolean loggedIn = false;
    private String errorMessage;
    private UI ui;

    public String getCurrentUserID(){
        return currentUserID;
    }

    public void setCurrentUserID(String UserID){
        currentUserID = UserID;
    }

    public Boolean getLoggedIn(){
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
    
    public void setUserIDs(ArrayList<Developer> datatable){
        userIDs = datatable;
    }

    public ArrayList<Developer> getUserIDs(){
        return userIDs;
    }

    public void Login(String userID){
        this.currentUserID = userID;
        boolean idExists = false;
        for(Developer d : userIDs){
            if (d.getUserId() == userID){
                loggedIn = true;
                ui.setScreen(2);
                idExists = true;
            }
        }
    
        if (!idExists) {
            errorMessage = "User ID doesn't exist";
            new Errorhandler("User ID doesn't exist");
            ui.setScreen(3);
        }
    }

    public void CreateProject(String name, GregorianCalendar start, GregorianCalendar end, Developer userID){
        boolean nameExists = false;
        for (Project p : projectNames){
            if (p.getName() == name){
                nameExists = true;
                errorMessage = "A project with this name already exists";
                new Errorhandler("A project with this name already exists");
                System.out.println("A project with this name already exists");
                break;
            }
        }
        if(!nameExists){
            projectNames.add(new Project(name,start,end,userID));
            System.out.println("A project with name " +name+ " has been created");
        }
    }

    public GregorianCalendar createCalendar(int year, int month, int day){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(GregorianCalendar.YEAR, year);
        calendar.set(GregorianCalendar.MONTH, month);
        calendar.set(GregorianCalendar.DAY_OF_MONTH, day);

        return calendar;
    }
}