package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//Skrevet af Thomas
public class Activity { 
    private Date startDate, endDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<Developer> developers = new ArrayList<Developer>();
    private String name;
    private Calender calendar = new Calender();

    public Activity(String name, String startDate, String endDate){
        this.name = name;
        setStartDate(startDate);
        setEndDate(endDate);
    }

    //Adds developer to the list of developers.
    public void addDeveloper(Developer userID){
        if (developers.contains(userID)){
            new Errorhandler("Developer is already contained in the activity.");
        } else{
        developers.add(userID);
        }
    }

    //Returns the list of developers 
    public ArrayList<Developer> getDevelopers(){
        return developers;
    }

    //Takes the input and creates the start date. If the input is in the wrong format, a standard date is used.
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
    
    //Used to create the developers list in the tests.
    public void setDevelopers(ArrayList<Developer> team){
        developers = team;
    }

    //Takes the input and creates the end date. If the input is in the wrong format, a standard date is used.
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

    //Returns the end date.
    public Date getEndDate() {
        return endDate;
    }

    //Returns the start date.
    public Date getStartDate() {
        return startDate;
    }

    //Sets the name of the activity
    public void setName(String name) {
        this.name = name;
    }

    //Gets the name of the activity
    public String getName() {
        return name;
    }

    //Prints all developers on the project
    public void printDevelopers(){
        for (Developer d : developers){
            System.out.println(d.getUserId());
        }
    }
}