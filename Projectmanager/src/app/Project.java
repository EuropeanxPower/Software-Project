package app;

import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

public class Project extends Activity{
    private Developer projectmanagerID;
    private List<Activity> activities = new ArrayList<Activity>();
    private double projectTime;

    public Project(String name, GregorianCalendar start, GregorianCalendar end, Developer userID){
        super(name, start, end, userID);
    }

    public void setProjectmanager(Developer userID){
        projectmanagerID = userID;
    }
    public Developer getProjectmanager(){
        return projectmanagerID;
    }

    public void setTotalActivityTime(double totalActivityTime){
        projectTime += totalActivityTime;
    }
    
    public void addActivity(String activityName, GregorianCalendar start, GregorianCalendar end, Developer userID){
        if (findActivity(activityName) != -1) {
            System.out.println("Activity: " + activityName + " already exists");
        } else {
            activities.add(new Activity(activityName, start, end, userID));
        }            
    }

    public int findActivity(String name) {
        int status = -1;
        for (int a = 0; a < activities.size(); a++) {
            if (activities.get(a).getName() == name) {
                status = a;
            } else {
                status = -1;
            }
        }
        return status;
    }

}