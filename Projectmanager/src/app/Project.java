package app;

import java.util.ArrayList;
import java.util.List;

public class Project{
    private Developer projectmanager;
    private SerialNumbers sn;
    private List<Activity> activities = new ArrayList<Activity>();
    private double projectTime;
    private String projectName;
    private String projectID;
    private ArrayList<Developer> developers = new ArrayList<Developer>();
    private String errorMessage;

    public Project(String name, Developer userID){
        projectName = name;
        //projectID = sn.getProjectSN();
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
        projectmanager = userID;
    }
    public Developer getProjectmanager(){
        return projectmanager;
    }

    public void setTotalActivityTime(double totalActivityTime){
        projectTime += totalActivityTime;
    }


    public void addActivity(String activityName, String start, String end){
        if (findActivity(activityName) != -1) {
            System.out.println("Activity: " + activityName + " already exists");
        } else {
            activities.add(new Activity(activityName, start, end));
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

    public void activityList(){
        String[] activityList = new String[activities.size()];
        int a = 0;
        for (Activity activity : activities){
            activityList[a] = activity.getName();
            a++;
        }
        for (int i = 0; i <= activityList.length -1;i++){
            System.out.println(activityList[i]);
        }
    }
    
    public boolean findDeveloper(String userID){
        boolean userIDExists = false;
        for (Developer d :  developers){
            if(d.getUserId().equals(userID)){
                userIDExists = true;
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

    public String[] getReport(){
        String[] report = new String[3];
        report[0] = "Name of the project: " + getName();
        report[1] = "Projectmanager: " + getProjectmanager();
        report[2] = "Developers on the project: " + developers;



        return report;
    }
}