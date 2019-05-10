package app;

import java.util.ArrayList;

public class Activity {
    private String startDate, endDate;
    private ArrayList<Developer> developers = new ArrayList<Developer>();
    private String name;
    //private double totalActiviyTime;
    //private double estimatedActivityTime;
    private Calender calendar = new Calender();

    public Activity(String name, String startDate, String endDate){
        this.name = name;
        setStartDate(startDate);
        setEndDate(endDate);
        //developers.add(userID);
    }

    public ArrayList<Developer> getdeveloper(){
        return developers;
    }

    public void setDevelopers(ArrayList<Developer> team){
        developers = team;
    }

    /*public void setTotalActivityTime(double inputTime){
        totalActiviyTime += inputTime;
    }
    public void setEstimateTime(double inputEstimateTime){
        estimatedActivityTime = inputEstimateTime;
    }*/

    public void setEndDate(String date) {
        calendar.checkDate(date);
        if (endDate != null || startDate != null){
            if (!calendar.compareDates(startDate, endDate)) {
            new Errorhandler("Project must end after the project ends");
            }
        } else {
            try{
                endDate = Integer.parseInt(date.substring(0,3)) +"-"+ Integer.parseInt(date.substring(5,6)) +"-"+ Integer.parseInt(date.substring(8,9));
            }catch(Exception e){

            }
        }
    }   

    public void setStartDate(String date) {
        if (calendar.checkDate(date)){
            if (endDate != null || startDate != null){
                if (!calendar.compareDates(startDate, endDate)) {
                new Errorhandler("Project must start before the project ends");
                }
            } else {
                try {
                    startDate = Integer.parseInt(date.substring(0,3)) +"-"+ Integer.parseInt(date.substring(5,6)) +"-"+ Integer.parseInt(date.substring(8,9));
                }catch(Exception e){

                }
            }
        }
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printDevelopers(){
        for (Developer d : developers){
            System.out.println(d.getUserId());
        }
    }
}