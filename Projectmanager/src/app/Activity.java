package app;

import java.util.ArrayList;

public class Activity extends Project {
    private double totalActiviyTime;
    private double estimatedActivityTime;

    public Activity(String name, int start, int end, String userID){
        super(name, start, end, userID);
    }


    public void addDeveloper(String userID){
        developers.add(userID);
    }
    
    public ArrayList getdeveloper(){
        return developers;
    }

    public void setTotalActivityTime(double inputTime){
        totalActiviyTime += inputTime;
    }

    public void setEstimateTime(double inputEstimateTime){
        estimatedActivityTime = inputEstimateTime;
    }

    public void setPlannedWeeks(int inputStartTime, int inputEndTime){
        startDate = inputStartTime;
        endDate = inputEndTime;
    }

    public String getActivityName() {
        return name;
    }

}