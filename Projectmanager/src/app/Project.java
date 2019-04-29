package app;

/*import java.util.ArrayList;
import java.util.List;

public class Project extends Activity{
    private String projectmanagerID = "VWJ";
    public List<Activity> activities = new ArrayList<Activity>();
    public int startDate;
    public int endDate;
    public double projectTime;

    public Project(String inputName, int inputStartDate, int inputEndDate, String userID){
        super(name, start, end, userID);
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
    
    public void addActivity(String activityName, int start, int end, String userID){
        if (findActivity(activityName) != -1) {
            System.out.println("Activity: " + activityName + " already exists");
        } else {
            activities.add(new Activity(name, start, end, userID));
        }            
    }

    public int findActivity(String name) {
        int status = -1;
        for (int a = 0; a < activities.size(); a++) {
            if (activities.get(a).getActivityName() == name) {
                status = a;
            } else {
                status = -1;
            }
        }
        return status;
    }

}*/