package app;

class Project {
    private String projectName;
    private double projectTime;
    

    Project(String inputName){
        projectName = inputName;   
    }

    public void setTotalActivityTime(double totalActivityTime){
        projectTime += totalActivityTime;
    }

}
