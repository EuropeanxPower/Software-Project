package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Controller {
    public static String currentUserID;

    public List<String> userIDs = new ArrayList<String>(Arrays.asList("VWJ", "NA", "CP", "TM"));
    public List<String> projectNames = new ArrayList<String>(Arrays.asList("Tele-Kipper", "Sort-Pick"));

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public Boolean loggedIn = false;
    public String errorMessage;

    Scanner input = new Scanner(System.in);
    int userInput;

    public Controller() {
    }
    public void read()throws IOException {
        StringTokenizer operation = new StringTokenizer(in.readLine());

        String command = operation.nextToken();
    }
    public void Login(){
        while (loggedIn == false) {
            System.out.println("Please enter your login");
            currentUserID = input.next();
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
        System.out.println("Press 1 to go to active project.");
        System.out.println("Press 2 to go to create new project.");
        System.out.println("Press 3 to go to add a new developer to the system.");
        userInput = input.nextInt();
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