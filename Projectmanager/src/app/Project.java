package app;

import java.util.ArrayList;

public class Project {
    public String projectName;
    public double projectTime;
    //private ArrayList<Activity> activities = new ArrayList<Activity>();
    private String projectmanagerID = "VWJ";
    public ArrayList developers;
    private int startDate;
    private int endDate;

    public Project(String inputName, int inputStartDate, int inputEndDate, ArrayList developers){
        this.projectName = inputName;
        this.setStartDate(inputStartDate);
        this.setEndDate(inputEndDate);
        this.developers = developers;
    }

    public void addDeveloper(String userID){
        developers.add(userID);
    }

    public void setProjectmanager(String userID){
        projectmanagerID = userID;
    }

    public void setTotalActivityTime(double totalActivityTime){
        projectTime += totalActivityTime;
    }

    /*public void AddActivity(Activity activity){
        activities.add(activity);
    }*/

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

}
