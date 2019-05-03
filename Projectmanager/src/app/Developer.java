package app;

import java.util.ArrayList;

public class Developer {
    private String userID;
    private ArrayList<Project> projects;
    private Boolean isAdministrator;

    public Developer(String userID){
        this.userID = userID;
    }

    public String getUserId(){
        return userID;
    }

    public void addProject(Project project){
        boolean projectExists = false;
        for(Project p : projects){
            if (p == project) projectExists = true;
        }
        if (projectExists){
            
        }
    }
    
}
