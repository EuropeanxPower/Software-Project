package app;

import java.util.Scanner;

public class Controller {

    UI ui;
    Model model;
    Scanner input = new Scanner(System.in);

    public void readUserInput(){
    	while(true) {
    		if(Boolean.FALSE.equals(model.getLoggedIn())){
                ui.setScreen(1);
                model.Login(input.next());
    		}
        }
    }

}