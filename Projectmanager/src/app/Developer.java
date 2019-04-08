package app;

import java.util.ArrayList;

public class Developer {
    private String userID;
    private ArrayList activities;
    private ArrayList projects;
    private Boolean isDeveloper;
    private Boolean isProjectmanager;
    private Boolean isAdministrator;
    
    public void setProjectmanager(String projectName){
        isProjectmanager=true;

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
