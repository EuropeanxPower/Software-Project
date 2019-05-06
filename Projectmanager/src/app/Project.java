package app;

import java.util.ArrayList;
import java.util.List;

public class Project{
    private Developer projectmanagerID;
    private List<Activity> activities = new ArrayList<Activity>();
    private double projectTime;
    private String projectName;
    private String projectID;
    private ArrayList<Developer> developers = new ArrayList<Developer>();

    public Project(String name, Developer userID){
        projectName = name;
        // Call function for setting project ID.
        developers.add(userID);
    }
    public void addDeveloper(Developer userID){
        if (developers.contains(userID)){
            new Errorhandler("Developer is already contained in project.");
        } else{
        developers.add(userID);
        }
    }

    public String getName() {
        return projectName;
    }

    public ArrayList<Developer> getdeveloper(){
        return developers;
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


    public void addActivity(String activityName, String start, String end, Developer userID){
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

    public String[] getActivityList(){
        String[] activityList = new String[activities.size()];
        int a = 0;
        for (Activity activity : activities){
            activityList[a] = activity.getName();
            a++;
        }
        return activityList;
    }
}