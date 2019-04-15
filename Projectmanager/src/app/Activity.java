package app;

class Activity extends Project {
    private double totalActiviyTime;
    private double estimatedActivityTime;

    Activity(String inputActivity, int startTime, int endTime){
        super(inputActivity,startTime,endTime);
    }

    public void setTotalActivityTime(double inputTime){
        totalActiviyTime = inputTime;
    }

    public void setEstimateTime(double inputEstimateTime){
        estimatedActivityTime = inputEstimateTime;
    }

    public void setPlannedWeeks(int inputStartTime, int inputEndTime){
        setStartDate(inputStartTime);
        setEndDate(inputEndTime);
    }
}