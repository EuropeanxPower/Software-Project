package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Activity {
    private Date startDate, endDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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

    public void addDeveloper(Developer userID){
        if (developers.contains(userID)){
            new Errorhandler("Developer is already contained in the activity.");
        } else{
        developers.add(userID);
        }
    }

    public ArrayList<Developer> getDevelopers(){
        return developers;
    }

    public void setStartDate(String start){
    	if(calendar.checkDate(start)) {
    		try {
				startDate = sdf.parse(start);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    	}else {
    		try {
				startDate = sdf.parse("2020-01-01");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }   
    public void setEndDate(String end) {
        if(calendar.checkDate(end)) {
        	try {
				endDate = sdf.parse(end);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
        }else {
        	try {
				endDate = sdf.parse("2020-07-01");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }   

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
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