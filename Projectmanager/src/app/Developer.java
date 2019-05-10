package app;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Developer {
	private Activity test = new Activity("0","","");
	private Activity test1 = new Activity("1","","");
	private Activity test2 = new Activity("2","","");
	private Activity test3 = new Activity("3","","");
	private Activity test4 = new Activity("4","","");
	private Activity test5 = new Activity("5","","");
	private Activity test6 = new Activity("6","","");
	private Activity test7 = new Activity("7","","");
	private Activity test8 = new Activity("8","","");
	private Activity test9 = new Activity("9","","");
	private Activity test10 = new Activity("10","","");
	private Activity test11 = new Activity("11","","");
	private Activity test12 = new Activity("12","","");
	private Activity test13 = new Activity("13","","");
	private Activity test14 = new Activity("14","","");
	private Activity test15 = new Activity("15","","");
	private Activity test16 = new Activity("16","","");
	private Activity test17 = new Activity("17","","");
	private Activity test18 = new Activity("18","","");
    private String userID;
    private List<Project> projects = new ArrayList<Project>();
    private List<Activity> activities = new ArrayList<Activity>(Arrays.asList(test,test1,test2,test3,test4,test5,test6,test7,test8,test9,test10,test11,test12,test13,test14,test15,test16,test17,test18));

    public Developer(String userID){
        this.userID = userID;
    }

    public String getUserId(){
        return userID;
    }

    public void setUserID(String ID){
        userID = ID;
    }

    public List<Activity> getDevelopersActivities(){
        return activities;
    }

    public void addProject(Project project){
        boolean projectExists = false;
        for(Project p : projects){
            if (p == project) projectExists = true;
        }
        if (projectExists){

        }
    }
    public void addActivity(Activity activity) {
    	activities.add(activity);
    }
    
    public int numberOfActivities (Date date) {
    	int numberOfActivities = 0;
		for(Activity a : activities) {
			Date start = a.getStartDate();
			Date end = a.getEndDate();
			
			if(start.before(date) && end.after(date)) numberOfActivities++;
		}
    	return numberOfActivities;
    }
    
    public boolean isFree(Activity activity) {
    	Date compareDate = activity.getStartDate();
    	Date end = activity.getEndDate();
    	
    	while(compareDate.compareTo(end)<0) {
    		if(numberOfActivities(compareDate) >= 20) {
    			return false;
    		}else {
    			compareDate.setTime(compareDate.getTime() + 86400000);
    		}
    	}
    	return true;
    	
    	
    }
}
