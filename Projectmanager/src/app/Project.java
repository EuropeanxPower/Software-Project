package app;

import java.util.ArrayList;
import java.util.List;

public class Project{
    private Developer projectmanager;
    private SerialNumbers sn = new SerialNumbers();
    private List<Activity> activities = new ArrayList<Activity>();
    private double projectTime;
    private String projectName;
    private String projectID;
    private ArrayList<Developer> developers = new ArrayList<Developer>();
    private String errorMessage;
    private Activity currentActivity;

    public Project(String name, Developer userID){
        projectName = name;
        projectID = sn.getProjectSN();
        developers.add(userID);
    }

    public void addDeveloper(Developer userID){
        if (developers.contains(userID)){
            new Errorhandler("Developer is already contained in project.");
        } else{
        developers.add(userID);
        }
    }

    public String getProjectSN(){
        return projectID;
    }

    public String getName() {
        return projectName;
    }

    public void setCurrentActivity(Activity activity){
        currentActivity = activity;
    }

    public Activity getCurrentActivity(){
        return currentActivity;
    }

    public ArrayList<Developer> getdeveloper(){
        return developers;
    }
    
    public void setProjectmanager(Developer userID){
        projectmanager = userID;
    }
    public Developer getProjectmanager(){
        return projectmanager;
    }

    public void setTotalActivityTime(double totalActivityTime){
        projectTime += totalActivityTime;
    }


    public Activity getActivity(String name){
        boolean nameExists = false;    
        for (Activity a : activities){
            if(a.getName().equals(name)){
                return a;
            }
        }
        if (!nameExists){
            errorMessage = "Given activity doesn't exist";
            new Error("Given activity doesn't exist");
        }
        return null;
    }

    public void activityList(){
        for (Activity activity : activities){
            System.out.println(activity.getName() + ", startdate: " + activity.getStartDate() + ", enddate: " + activity.getEndDate());
        }
    }

    public List<Activity> getActivityList(){
        return activities;
    }

    public void developerList(){
        String[] developerList = new String[developers.size()];
        int d = 0;
        for (Developer developer : developers){
            developerList[d] = developer.getUserId();
            d++;
        }
        for (int i = 0; i <= developerList.length - 1; i++){
            System.out.println(developerList[i]);
        }
    }
    
    public boolean findDeveloper(String userID){
        boolean userIDExists = false;
        if (developers.isEmpty()){
            return false;
        } else {
            for (Developer d :  developers){
                if(d.getUserId().equals(userID)){
                    userIDExists = true;
                }
            }
        }
        if (!userIDExists){
            new Errorhandler("You don't have access to this project");
            errorMessage = "You don't have access to this project";
        }
        return userIDExists;
    }

    public Developer getDeveloper(String name){
        boolean nameExists = false;    
        for (Developer d : developers){
            if(d.getUserId().equals(name)){
                return d;
            }
        }
        if (!nameExists){
            errorMessage = "Given developer is not a part of the project or does not exist";
            new Error("Given developer is not a port of the project or does not exist");
        }
        return null;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}