package app;

import java.util.Scanner;

    // Case 1 is Login Screen
    // Case 2 is General Overview
    // Case 3 is Project Overview
    // Case 4 is Create Project
    // Case 5 is Add New Developer to System
    // Case # is Go to project "..."

public class UI {

    private Controller controller;
    private Model model;
    private int screen1 = 1;

    public void start(){
        while(true){
            switch (screen1){
                case 1: //Login
                    System.out.println("Please enter your login");
                    break;
                case 2:
                    System.out.println("Logged in");
                    break;
                case 3:
                    System.out.println("User ID does not exist");
                    break;
                case 4: //Overview
                    System.out.println("Press 1 to go to active project.");
                    System.out.println("Press 2 to create new project.");
                    System.out.println("Press 3 to add a new developer to the system.");
                    break;
                case 5: //Go to project
                    System.out.println("Enter active project");
                    break;
                case 6: //Create project
                    System.out.println("Name of the project:");
                    break;
                case 7: //Add developer
                    System.out.println("Name of developer:");
                    break;
                case 8: //Project overview
                     // OPEN controller.userInput
            }
        }
    }

    public void setScreen(int screen){
        screen1 = screen;
    }
}