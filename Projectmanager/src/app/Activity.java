package app;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Activity {
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private ArrayList<Developer> developers;
    private String name;
    private double totalActiviyTime;
    private double estimatedActivityTime;

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

    public void setTotalActivityTime(double inputTime){
        totalActiviyTime += inputTime;
    }

    public void setEstimateTime(double inputEstimateTime){
        estimatedActivityTime = inputEstimateTime;
    }

    public GregorianCalendar getEndDate() {
		return endDate;
    }
    
    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setEndDate(int year, int month, int day) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(GregorianCalendar.YEAR, year);
        calendar.set(GregorianCalendar.MONTH, month);
        calendar.set(GregorianCalendar.DAY_OF_MONTH, day);
		endDate = calendar;
	}

    public void setStartDate(int year, int month, int day) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(GregorianCalendar.YEAR, year);
        calendar.set(GregorianCalendar.MONTH, month);
        calendar.set(GregorianCalendar.DAY_OF_MONTH, day);
		startDate = calendar;
    }

    public String getName() {
        return name;
    }

    

}