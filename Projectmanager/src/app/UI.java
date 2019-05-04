package app;

import java.util.Scanner;

    // Case 1 is Login Screen
    // Case 2 is General Overview
    // Case 3 is Project Overview
    // Case 4 is Create Project
    // Case 5 is Add New Developer to System
    // Case # is Go to project "..."

public class UI {

    public void screen(int screen){
            switch (screen){
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
                	System.out.println("Please choose your next action:");
                    System.out.println("Type 1 to manage an active project.");
                    System.out.println("Type 2 to create new project.");
                    break;
                case 5: //Go to project
                    System.out.println("Enter active project");
                    break;
                case 6: //Create project
                    System.out.println("Please enter the name of the project");
                    break;
                case 7: 
                	System.out.println("Please enter the start date of the project");
                    break;
                case 8: 
                	System.out.println("Please enter the end date of the project");
                	break;
                case 9:
                	break;
            }
    	}
}