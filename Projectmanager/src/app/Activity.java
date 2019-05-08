package app;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Activity {
    private String startDate, endDate;
    private ArrayList<Developer> developers = new ArrayList<Developer>();
    private String name;
    //private double totalActiviyTime;
    //private double estimatedActivityTime;
    private Calender calendar = new Calender();

    public Activity(String name, String startDate, String endDate){
        this.name = name;
        this.startDate = setStartDate(startDate);
        this.endDate = setEndDate(endDate);
        //developers.add(userID);
    }

    public void addDeveloper(Developer userID){
        if (developers.contains(userID)){
            new Errorhandler("Developer is already contained in the activity.");
        } else{
        developers.add(userID);
        }
    }

    public ArrayList<Developer> getdeveloper(){
        return developers;
    }

    /*public void setTotalActivityTime(double inputTime){
        totalActiviyTime += inputTime;
    }
    public void setEstimateTime(double inputEstimateTime){
        estimatedActivityTime = inputEstimateTime;
    }*/

    private String setEndDate(String date) {
        calendar.checkDate(date);
        if (endDate != null || startDate != null){
            if (!calendar.compareDates(startDate, endDate)) {
            new Errorhandler("Project must end after the project ends");
            }
        } else {
            endDate = Integer.parseInt(date.substring(0,3)) +"-"+ Integer.parseInt(date.substring(5,6)) +"-"+ Integer.parseInt(date.substring(8,9));
            return endDate;
        }
        return null;
    }   

    private String setStartDate(String date) {
        if (calendar.checkDate(date)){
            if (endDate != null || startDate != null){
                if (!calendar.compareDates(startDate, endDate)) {
                new Errorhandler("Project must start before the project ends");
                }
            } else {
                startDate = Integer.parseInt(date.substring(0,3)) +"-"+ Integer.parseInt(date.substring(5,6)) +"-"+ Integer.parseInt(date.substring(8,9));
                return startDate;
            }
        }
        return null;
    }

    private String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getName() {
        return name;
    }
}