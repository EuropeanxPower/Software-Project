package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

class Model{
    Developer VWJ = new Developer("VWJ");
    Developer NA = new Developer("NA");
    Developer CP = new Developer("CP");
    Developer TM = new Developer("TM");
    Project TeleKipper = new Project("Tele-Kipper", 0, 3,TM);
    Project SortPick = new Project("Sort-Pick", 0, 3,VWJ);
    private String currentUserID;
    private ArrayList<Developer> userIDs = new ArrayList<Developer>(Arrays.asList(VWJ,NA,CP,TM));
    private ArrayList<Project> projectNames = new ArrayList<Project>(Arrays.asList(TeleKipper, SortPick));
    private Boolean loggedIn = false;
    private String errorMessage;

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

    public ArrayList<Developer> getUserIDs(){
        return userIDs;
    }

    public void Login(String userID){
        this.currentUserID = userID;
        boolean idExists = false;
        for(Developer d : userIDs){
            if (d.getUserId() == userID){
                loggedIn = true;
                System.out.println("Logged in");
                idExists = true;
            }
        }
    
        if (!idExists) {
            errorMessage = "User ID doesn't exist";
            new Errorhandler("User ID doesn't exist");
            System.out.println("User ID doesn't exist");
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