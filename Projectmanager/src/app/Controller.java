package app;

import java.util.Scanner;

public class Controller {

    private UI ui;
    private Model model;
    Scanner input = new Scanner(System.in);

    public void readUserInput(){
        while(true){
            if(model.getLoggedIn() == false){
                ui.setScreen(1);
                model.Login(input.next());
            }
        }
    }

}