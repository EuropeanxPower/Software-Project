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
            		userInput = input.next();
            		model.Login(userInput);
            	}
            	screen = 2;
        	case 2:
        		userInput = input.next();
        		if("1".equals(userInput)) {
        			ui.screen(5);
        			userInput = input.next();
        		}else if("2".equals(userInput)) {
        			ui.screen(6);
        			userInput = input.next();
        			
        		}
        	}
        }
    }

}