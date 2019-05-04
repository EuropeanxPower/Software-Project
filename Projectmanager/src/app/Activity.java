package app;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Activity {
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private ArrayList<Developer> developers = new ArrayList<Developer>();
    private String name;
    //private double totalActiviyTime;
    //private double estimatedActivityTime;
    Model model;

    public Activity(String name, GregorianCalendar start, GregorianCalendar end, Developer userID){
        this.name = name;
        this.startDate = start;
        this.endDate = end;
        developers.add(userID);
    }

    public void addDeveloper(Developer userID){
        developers.add(userID);
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

    public GregorianCalendar getEndDate() {
		return endDate;
    }
    
    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setEndDate(int year, int month, int day) {
		endDate = model.createCalendar(year, month, day);
	}

    public void setStartDate(int year, int month, int day) {
		startDate = model.createCalendar(year, month, day);
    }

    public String getName() {
        return name;
    }

    

}