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

    public Boolean loggedIn = false;
    public String errorMessage;

    Scanner scanner = new Scanner(System.in);
    String userInput;
    int screen;

    public Controller(){
        screen = 1;

        while(true){
            switch (screen){
            case 1: 
                Login();
            case 2:
                System.out.println("Press 1 to go to active project.");
                System.out.println("Press 2 to go to create new project.");
                System.out.println("Press 3 to go to add a new developer to the system.");
                Overview();
            break;
          case 3:
            // Function
            screen = 2;
            break;
          case 4:
            // Function
            screen = 2;
            break;
        }
      }        
    }

    public void Login(){
        while (loggedIn == false) {
            System.out.println("Please enter your login");
            currentUserID = scanner.next();
            if (userIDs.contains(currentUserID)){
                loggedIn = true;
                System.out.println("Logged in");
            }
            else{
                errorMessage = "User ID doesn't exist";
                new Errorhandler("User ID doesn't exist");
                System.out.println("User ID doesn't exist");
            }
        }
    }

    public void Overview(){
        userInput = scanner.next();
        if (userInput == "1"){
            screen = 3;
        }
        else if (userInput == "2"){
            screen = 4;
        }
        else if (userInput == "3"){
            screen = 5;
        } else{
            System.out.println("Invalid input");
        }
    }
    
    public void CreateProject(String name){
        if (projectNames.contains(name)){
            errorMessage = "There is already a project with this name";
            new Errorhandler("There is already a project with this name");
            System.out.println("There is already a project with this name");
        }
        else{
            projectNames.add(name);
            System.out.println("A project with name " + name + " is created");
        }
    }
}