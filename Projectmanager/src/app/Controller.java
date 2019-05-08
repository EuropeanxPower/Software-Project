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

    void readUserInput(){
        while(true){
            switch(screen) {
                case 1: // Login
                    while(!model.getLoggedIn()){
                        ui.screen(1);
                        userInput = input.nextLine();
                        if (model.Login(userInput)) {
                            ui.screen(2);
                        }else ui.screen(3);
                    }
                    screen = 2;
                    break;
                case 2: // General Overview Functions
                    ui.screen(4); 
                    userInput = input.nextLine();
                    if("1".equals(userInput)) {
                        ui.screen(5);
                        userInput = input.nextLine();
                        if (model.findProject(userInput)) {
                            model.setCurrentProject(model.getProject(userInput));
                            ui.setProjectName(userInput);
                            if (model.getCurrentProject().findDeveloper(model.getCurrentUser().getUserId())) {
                                ui.screen(10);
                                screen = 3;
                            } else {
                                ui.screen(11);
                            }
                        }
                    } else if ("2".equals(userInput)) {
                        ui.screen(7);
                        userInput = input.nextLine();
                        if (model.createProject(userInput, model.getCurrentUser())) {
                            ui.screen(8);
                        } else {
                            ui.getProjectName();
                            ui.screen(9);
                        }
                    }
                    break;
                case 3: // Project Overview Functions
                    ui.screen(10);
                    userInput = input.nextLine();
                    if("1".equals(userInput)) { //Manage project.
                        
                    }
                    else if("2".equals(userInput)) { //Assign project manager.
                        if(model.getCurrentProject().getProjectmanager() == null) {
                                ui.screen(15);
                                userInput = input.nextLine();
                                if (model.getCurrentProject().findDeveloper(userInput)){
                                    model.getCurrentProject().setProjectmanager(model.getCurrentProject().getDeveloper(userInput));
                                    ui.screen(24);
                                }else {
                                    ui.screen(25);
                                }
                        } else if (model.getCurrentProject().getProjectmanager().getUserId() == model.getCurrentUser().getUserId()){
                                ui.screen(15);
                                userInput = input.nextLine();
                                model.getCurrentProject().setProjectmanager(model.getCurrentProject().getDeveloper(userInput));
                                ui.screen(24);
                        }else{
                            ui.screen(14);
                        }
                    }
                    else if("3".equals(userInput)) { //Add developer to project.
                        
                    }
                    else if("4".equals(userInput)) { //Add an activity to project.
                        //ui.screen();
                        ui.screen(12);
                        userInput = input.nextLine();
                        if (model.getCurrentProject().findActivity(userInput) != -1){
                            ui.screen(21); //Activity already exists
                            break;
                        }
                        ui.screen(19); // Getting startdate
                        userStartDate = input.nextLine();
                        ui.screen(20); // Getting enddate
                        userEndDate = input.nextLine();                        
                        model.getCurrentProject().addActivity(userInput, userStartDate, userEndDate);
                    }
                    else if("5".equals(userInput)) { //Get projectreport.
                        report = model.getReport();
                        for(int i = 0; i <= report.length-1; i++){
                            System.out.println(report[i]);
                        } 
                        model.getCurrentProject().activityList();
                    }
                    else if("6".equals(userInput)) {//Return to general overview.
                        ui.screen(4);
                        screen = 2;
                    }
                    break;
                case 4: // Activity Overview Functions
                    
                break;
            }
        }
    }

}