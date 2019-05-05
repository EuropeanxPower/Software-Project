package app;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Developer {
    private String userID;
    private ArrayList<Project> projects;
    private List<Activity> developersActivities = new ArrayList<Activity>();
    private List<GregorianCalendar> booked = new ArrayList<GregorianCalendar>();
    private Boolean isAdministrator;

    public Developer(String userID){
        this.userID = userID;
    }

    public String getUserId(){
        return userID;
    }

    public List<Activity> getDevelopersActivities(){
        return developersActivities;
    }




    public void addProject(Project project){
        boolean projectExists = false;
        for(Project p : projects){
            if (p == project) projectExists = true;
        }
        if (projectExists){

        }
    }

}
