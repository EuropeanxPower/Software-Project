package app;

class Activity extends Project {
    public String activityName;
    private double totalActiviyTime;
    private double estimatedActivityTime;
    private int startTime;
    private int endTime;

    Activity(String inputActivity){
        super(inputActivity);
    }

    public Activity

    public void setTotalActivityTime(double inputTime){
        totalActiviyTime += inputTime;
    }

    public void setEstimateTime(double inputEstimateTime){
        estimatedActivityTime = inputEstimateTime;
    }

    public void setPlannedWeeks(int inputStartTime, int inputEndTime){
        startTime = inputStartTime;
        endTime = inputEndTime;
    }
}