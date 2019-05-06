package app;

import java.util.Scanner;

public class Controller {

    private UI ui = new UI();
    private Model model = new Model();
    private Scanner input = new Scanner(System.in);
    private String userInput = "";
    private int screen = 1;

    public void readUserInput(){
        while(true){
            switch(screen) {
                case 1:
                    while(!model.getLoggedIn()){
                        ui.screen(1);
                        userInput = input.nextLine();
                        if (model.Login(userInput)) {
                            ui.screen(2);
                            ui.screen(4);
                        }else ui.screen(3);
                    }
                    screen = 2;
                case 2:
                    userInput = input.nextLine();
                    if("1".equals(userInput)) {
                        ui.screen(5);
                        userInput = input.nextLine();
                    }else if("2".equals(userInput)) {
                        ui.screen(6);
                        userInput = input.nextLine();
                        if(model.createProject(userInput, model.getCurrentUser())) {
                            ui.screen(7);
                            ui.screen(4);
                        }else {
                            ui.projectCreated(userInput);
                            ui.screen(4);
                        }
                    }else ui.screen(4);
            }
        }
    }

}