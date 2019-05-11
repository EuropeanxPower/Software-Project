package app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//Skrevet af Vivian
public class Project{
    private Developer projectmanager;
    private SerialNumbers sn = new SerialNumbers();
    private List<Activity> activities = new ArrayList<Activity>();
    private String projectName;
    private String projectID;
    private ArrayList<Developer> developers = new ArrayList<Developer>();
    private String errorMessage;
    private Activity currentActivity;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Project(String name, Developer userID){
        projectName = name;
        projectID = sn.getProjectSN();
        developers.add(userID);
    }

    //add developer to the project
    public void addDeveloper(Developer userID){
        if (developers.contains(userID)){
            new Errorhandler("Developer is already contained in project.");
        } else{
        developers.add(userID);
        }
    }

    //return serialnumber for the project
    public String getProjectSN(){
        return projectID;
    }

    //return the projectname
    public String getName() {
        return projectName;
    }

    //Set an activity to current Activity
    public void setCurrentActivity(Activity activity){
        currentActivity = activity;
    }

    //return current activity
    public Activity getCurrentActivity(){
        return currentActivity;
    }

    //return the list of developers on the project
    public ArrayList<Developer> getDevelopers(){
        return developers;
    }

    //set a developer as projectmanager
    public void setProjectmanager(Developer userID){
        projectmanager = userID;
    }

    //return projectmanager for the project
    public Developer getProjectmanager(){
        return projectmanager;
    }

    //return an activity
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

    //check if an activity exist
    public boolean findActivity(String name){
        boolean nameExists = false;
        for (Activity a : activities){
            if(a.getName().equals(name)){
                nameExists = true;
            }
        }
        if (!nameExists){
            errorMessage = "Given activity does not exist";
            new Error("Given activity does not exist");
        }
        return nameExists;
    }

    //print a list of activities in the project, with the data
    public void activityList(){
        for (Activity activity : activities){
            System.out.println(activity.getName() + ", startdate: " + sdf.format(activity.getStartDate()) + ", enddate: " + sdf.format(activity.getEndDate()));
        }
    }

    //return a list of the activities in the project
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

    //Check if an developer is a part of the project
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

    //return developer in the project
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
    
}