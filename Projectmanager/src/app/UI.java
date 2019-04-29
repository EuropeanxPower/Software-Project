package app;

import java.util.Scanner;

Class UI {

    public UI(){

    }

    public void start(){
        Scanner input = new Scanner(System.in);

        int screen = 1;

        while(true){
            switch (screen){
                case 1: //Login
                    while (controller.loggedIn == false) {
                        System.out.println("Please enter your login");
                        controller.currentUserID = input.next();
                        controller.Login(controller.currentUserID);
                    }
                case 2: //Overview
                    System.out.println("Press 1 to go to active project.");
                    System.out.println("Press 2 to create new project.");
                    System.out.println("Press 3 to add a new developer to the system.");
                    controller.userInput = getChar(input);
                    if (controller.userInput.equals("1")){
                        screen = 3;
                    }
                    else if (controller.userInput.equals("2")){
                        screen = 4;
                    }
                    else if (controller.userInput.equals("3")){
                        screen = 5;
                    }
                    else{
                        System.out.println("Invalid input");
                    }
                    break;
                case 3: //Go to project
                    System.out.println("Enter active project");
                    controller.userInput = input.next();
                    controller.GoToProject(controller.userInput);
                    screen = 6;
                    break;
                case 4: //Create project
                    System.out.println("Name of the project:");
                    controller.userInput = input.next();
                    controller.CreateProject(controller.userInput);
                    screen = 2;
                    break;
                case 5: //Add developer
                    System.out.println("Name of developer:");
                    controller.userInput = input.next();
                    controller.AddDeveloper(controller.userInput);
                    screen = 2;
                    break;
                case 6: //Project overview
                    // OPEN controller.userInput
            }
        }
    }

}