package app;

import java.util.Scanner;

public class Controller {

    private UI ui = new UI();
    private Model model = new Model();
    private Scanner input = new Scanner(System.in);
    private String userInput = "";
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
                            ui.screen(4);
                        }else ui.screen(3);
                    }
                    screen = 2;
                    break;
                case 2: // General Overview Functions
                    userInput = input.nextLine();
                    if("1".equals(userInput)) {
                        ui.screen(5);
                        userInput = input.nextLine();
                        if (model.findProject(userInput)){
                            ui.screen(10);
                            screen = 3;
                            /*System.out.println(model.getCurrentUser().getUserId());
                            System.out.println(model.getCurrentProject().getdeveloper().remove(1));
                            if (model.getCurrentProject().findDeveloper(model.getCurrentUser().getUserId()) || model.getCurrentProject().getdeveloper().contains(model.getCurrentUser())){
                                ui.getProjectName(userInput);
                                ui.screen(10);
                                screen = 3;
                            } else {
                                ui.screen(11);
                                ui.screen(4);
                            }*/
                        } else {
                            ui.screen(6);
                            ui.screen(4);
                        }
                    }else if("2".equals(userInput)) {
                        ui.screen(7);
                        userInput = input.nextLine();
                        if(model.createProject(userInput, model.getCurrentUser())) {
                            ui.screen(8);
                            ui.screen(4);
                        }else {
                            
                            ui.getProjectName(userInput);
                            ui.screen(9);
                            ui.screen(4);
                        }
                    }else ui.screen(4);
                    break;
                case 3: // Project Overview Functions
                    userInput = input.nextLine();
                    if("1".equals(userInput)) {
                        
                    }
                    else if("2".equals(userInput)) {
                        if(model.getCurrentProject().getProjectmanager().getUserId() == model.getCurrentUser().getUserId()){
                            ui.screen(15);
                        } else{
                            ui.screen(14);
                        }
                    }
                    else if("3".equals(userInput)) {

                    }
                    else if("4".equals(userInput)) {

                    }
                    else if("5".equals(userInput)) {
                        System.out.println(model.getCurrentProject().getReport());
                    }
                    else if("6".equals(userInput)) {
                        ui.screen(4);
                        screen = 2;
                    } else ui.screen(10);
                    break;
                case 4: // Activity Overview Functions
                    
                break;
            }
        }
    }

}