package app;

import java.util.Scanner;

public class Controller {

    private UI ui = new UI();
    private Model model = new Model();
    private Scanner input = new Scanner(System.in);
    private String userInput = "";
    private String userEndDate = "";
    private String userStartDate = "";
    private String[] report;
    private int screen = 1;

    Controller(){
    }

    void readUserInput() throws Exception{
        while(true){
            switch(screen) {
                case 1: // Login
                    while (!model.getLoggedIn()) {
                        ui.loginScreen(1);
                        userInput = input.nextLine();
                        if (model.Login(userInput)) {
                            ui.loginScreen(2);
                        } else ui.loginScreen(3);
                    }
                    screen = 2;
                    break;

                // General Overview Functions    
                case 2:
                    ui.startScreen(1);
                    userInput = input.nextLine();
                    if ("1".equals(userInput)) { //Go to/Manage project
                        ui.startScreen(2);
                        userInput = input.nextLine();
                        if (model.findProject(userInput)) {
                            model.setCurrentProject(model.getProject(userInput));
                            ui.setProjectName(userInput);
                            if (model.getCurrentProject().findDeveloper(model.getCurrentUser().getUserId())) {
                                screen = 3;
                            } else {
                                ui.startScreen(7);
                            }
                        } else {
                            ui.startScreen(3);
                        }
                    } else if ("2".equals(userInput)) { //Create new project
                        ui.startScreen(4);
                        userInput = input.nextLine();
                        if (model.createProject(userInput, model.getCurrentUser())) {
                            ui.startScreen(6);
                        } else {
                            ui.setProjectName(userInput);
                            ui.getProjectName();
                            ui.startScreen(5);
                        }
                    } else if ("3".equals(userInput)) {
                        ui.startScreen(8);
                        userInput = input.nextLine();
                        ui.setUserID(userInput);
                        if (!userInput.toUpperCase().matches("^[a-zA-Z]+$")) {
                            ui.startScreen(10);
                        } else if (userInput.length() > 4) {
                            ui.startScreen(11);
                        } else if (model.findDeveloper(userInput.toUpperCase())) {
                            ui.startScreen(12);
                        } else {
                            model.addDeveloper(userInput);
                            ui.startScreen(9);
                        }

                        //Logout option
                    } else if ("4".equals(userInput)) {
                        model.logout(model.getCurrentUser().getUserId());
                        screen = 1;
                    }
                    break;

                // Project Overview Functions
                case 3:

                    // INIT PROJECT OVERVIEW
                    if (model.getCurrentProject().getProjectmanager() == null) {
                        ui.projectScreen(1);
                        userInput = input.nextLine();
                        if ("1".equals(userInput)) { //Add developer to project
                            addDeveloperProject(input);
                        } else if ("2".equals(userInput)) { //Assign the project manager
                            assignProjectManager(input);
                        } else if ("3".equals(userInput)) { // Return to the General Overview
                            screen = 2;
                        }
                        // PROJECT MANAGER PROJECT OVERVIEW
                    } else if (model.getCurrentProject().getProjectmanager().getUserId() == model.getCurrentUser().getUserId()) {
                        ui.projectScreen(2);
                        userInput = input.nextLine();
                        if ("1".equals(userInput)) { // Pull project report
                            report = model.getReport();
                            for (int i = 0; i <= report.length - 1; i++) {
                                System.out.println(report[i]);
                            }
                            model.getCurrentProject().activityList();
                            //model.getCurrentProject().developerList();
                        } else if ("2".equals(userInput)) { // Add developer to project
                            addDeveloperProject(input);
                        } else if ("3".equals(userInput)) { // Add a new activity to project
                            ui.projectScreen(8); // Getting activity name
                            userInput = input.nextLine();
                            ui.projectScreen(9); // Getting startdate
                            userStartDate = input.nextLine();
                            ui.projectScreen(10); // Getting enddate
                            userEndDate = input.nextLine();
                            if (!model.addActivity(userInput, userStartDate, userEndDate, model.getCurrentProject())) {
                                ui.projectScreen(12); //Activity already exists
                            } else {
                                ui.setActivityName(userInput);
                                ui.projectScreen(11);
                            }
                        } else if ("4".equals(userInput)) { // Manage active project
                            manageActivity(input);
                        } else if ("5".equals(userInput)) { // Assign a new project manager
                            assignProjectManager(input);
                        } else if ("6".equals(userInput)) { // Return to general overview
                            screen = 2;
                        }

                        // DEVELOPER PROJECT OVERVIEW
                    } else {
                        ui.projectScreen(3);
                        userInput = input.nextLine();
                        if ("1".equals(userInput)) { // Manage active project
                            manageActivity(input);
                        } else if ("2".equals(userInput)) {
                            for (int i = 0; i < model.getCurrentProject().getActivityList().size(); i++) {
                                System.out.println(model.getCurrentProject().getActivityList().indexOf(1));
                            }
                        } else if ("3".equals(userInput)) {
                            screen = 2;
                        }
                    }
                    break;
                case 4: // Activity Overview Functions

                    // PROJECT MANAGER FUNCTIONS ACTIVITY
                    if (model.getCurrentProject().getProjectmanager().getUserId() == model.getCurrentUser().getUserId()) {
                        ui.activityScreen(1);
                        userInput = input.nextLine();
                        if ("1".equals(userInput)) {
                            userInput = input.nextLine();
                        }else if ("2".equals(userInput)){
                            String[] userIDs = model.getFreeDevelopers();
                            ui.setUserIDs(userIDs);
                            ui.activityScreen(8);
                            userInput = input.nextLine();
                            ui.setUserID(userInput);
                            if (model.getCurrentProject().findDeveloper(userInput)) {
                            	model.addDeveloperActivity(model.getDeveloper(userInput));
                                ui.activityScreen(9);
                            } else {
                                ui.activityScreen(10);
                            }
                        } else if ("3".equals(userInput)) {
                            screen = 5;
                        } else if ("4".equals(userInput)) {
                            getDevelopersActivity();
                        } else if ("5".equals(userInput)) {
                            screen = 3;
                        }

                        // DEVELOPER FUNCTIONS ON ACTIVITY
                    } else {
                        ui.activityScreen(2);
                        userInput = input.nextLine();
                        if ("1".equals(userInput)) {
                            userInput = input.nextLine();
                        } else if ("2".equals(userInput)) {
                            ui.activityScreen(8);
                            userInput = input.nextLine();
                            if (model.getCurrentProject().findDeveloper(userInput)) {
                                model.addDeveloperActivity(model.getDeveloper(userInput));
                                ui.setUserID(userInput);
                                ui.activityScreen(9);
                            } else {
                                ui.setUserID(userInput);
                                ui.activityScreen(10);
                            }
                        } else if ("3".equals(userInput)) {
                            getDevelopersActivity();
                        } else if ("4".equals(userInput)) {
                            screen = 3;
                        }
                    }
                    break;
                case 5:

                    ui.activityScreen(3);
                    userInput = input.nextLine();
                    if ("1".equals(userInput)) {
                        ui.activityScreen(17);
                        userInput = input.nextLine();
                        if (model.getCurrentProject().findActivity(userInput)) {
                            model.getCurrentProject().getCurrentActivity().setName(userInput);
                            ui.setActivityName(userInput);
                            ui.activityScreen(18);
                        } else {
                            ui.projectScreen(12);
                        }
                    } else if ("2".equals(userInput)) {
                        ui.activityScreen(11);
                        userInput = input.nextLine();
                        model.getCurrentProject().getCurrentActivity().setStartDate(userInput);
                    } else if ("3".equals(userInput)) {
                        ui.activityScreen(11);
                        userInput = input.nextLine();
                        model.getCurrentProject().getCurrentActivity().setEndDate(userInput);
                    } else if ("4".equals(userInput)) {
                        screen = 4;
                    }
                    break;
            }
        }
    }


    private void addDeveloperProject(Scanner input) {
        ui.projectScreen(5);
        userInput = input.nextLine();
        if (model.findDeveloper(userInput)) {
            model.getCurrentProject().addDeveloper(model.getDeveloper(userInput));
            ui.setUserID(userInput);
            ui.projectScreen(6);
        } else {
            ui.setUserID(userInput);
            ui.projectScreen(7);
        }
    }

    private void assignProjectManager(Scanner input){
        ui.projectScreen(16);
        userInput = input.nextLine();
        ui.setUserID(userInput);
        if (model.getCurrentProject().findDeveloper(userInput)){
            model.assignProjectmanager(model.getCurrentProject().getDeveloper(userInput),model.getCurrentProject(),model.getCurrentUser());
            ui.projectScreen(17);
        } else {
            ui.projectScreen(18);
        }
    }

    private void manageActivity(Scanner input){
        ui.projectScreen(14);
        userInput = input.nextLine();
        ui.setActivityName(userInput);
        if (model.findActivity(userInput, model.getCurrentProject()) != -1){
            model.getCurrentProject().setCurrentActivity(model.getCurrentProject().getActivity(userInput));
            ui.setActivityName(userInput);
            screen = 4;
        } else {
            ui.projectScreen(15);
        }
    }

    private void getDevelopersActivity(){
        ui.activityScreen(17);
        model.getCurrentProject().getCurrentActivity().printDevelopers();
    }
}