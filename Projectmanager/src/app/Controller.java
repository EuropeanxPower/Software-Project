package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Controller {
    public static String currentUserID;
    // public View view;
    public List<String> userIDs = new ArrayList<String>(Arrays.asList("VWJ", "NA", "CP", "TM"));
    public List<String> projectNames = new ArrayList<String>(Arrays.asList("Tele-Kipper", "Sort-Pick"));
    Scanner scanner = new Scanner(System.in);
    public Boolean loggedIn = false;
    public String errorMessage;

    String userInput;

    public Controller(){
    }

    public void Login(String userID){
        this.currentUserID = userID;
        if (userIDs.contains(userID)){
            loggedIn = true;
            System.out.println("Logged in");
        }
        else {
            errorMessage = "User ID doesn't exist";
            new Errorhandler("User ID doesn't exist");
            System.out.println("User ID doesn't exist");
        }
    }

    public void GoToProject(String name){
        if (projectNames.contains(name)){
            System.out.println("Welcome to " + name);
        }
        else{
            errorMessage = "To be determined";
            new Errorhandler("To be determined");
            System.out.println("No project named " + name + " exists");
        }
    }

    public void CreateProject(String name){
        if (projectNames.contains(name)){
            errorMessage = "A project with this name already exists";
            new Errorhandler("A project with this name already exists");
            System.out.println("A project with this name already exists");
        }
        else{
            projectNames.add(name);
            System.out.println("A project with name " +name+ " has been created");
        }
        
    }
    
    public void AddDeveloper(String name){
        if (userIDs.contains(name)){
            System.out.println(name +" is already in the system");
        }
        else{
            userIDs.add(name);
            System.out.println("Welcome to the team, " +name);
        }
    }

}