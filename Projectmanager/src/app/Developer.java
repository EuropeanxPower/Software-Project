package app;

import java.util.ArrayList;

public class Developer {
    public String userID;
    private ArrayList activities;
    public ArrayList projects;
    public Boolean isDeveloper = true;
    public Boolean isProjectmanager = false;
    public Boolean isAdministrator = false;
    
    public Developer(String ID) {
    	this.userID = ID;
    }
    
    public void setProjectmanager(String projectName){
        isProjectmanager=true;
        isDeveloper = false;

    }


    public void checkRole(Boolean role){
        if (isDeveloper) {
           //Load Developer rights 
        } else if (isProjectmanager){
            isDeveloper = true;
            //Load Projectmanager rights
        } else if (isAdministrator){
            isProjectmanager = true;
            //Load Administrator rights
        }
    }
}
