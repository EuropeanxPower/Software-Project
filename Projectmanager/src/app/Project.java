package app;

import java.util.ArrayList;

class Project {
    private String projectName;
    private double projectTime;
    private ArrayList activities = new ArrayList<>();
    private String projectmanager;
    private ArrayList developers;
    private int startDate;
    private int endDate;

    Project(String inputName, int inputStartDate, int inputEndDate){
        projectName = inputName;
        startDate = inputStartDate;
        endDate = inputEndDate;
    }

    public void addDeveloper(String userID){
        developers.add(userID);
    }

    public void setProjectmanager(String userID){
        projectmanager = userID;
    }

    public void setTotalActivityTime(double totalActivityTime){
        projectTime += totalActivityTime;
    }

    public void AddActivity(Activity activity){
        activities.add(activity.activityName);
    }

}
