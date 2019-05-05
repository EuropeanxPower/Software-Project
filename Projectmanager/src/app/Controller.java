package app;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Controller {

    private UI ui = new UI();
    private Model model = new Model();
    private Calender calendar = new Calender();
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
        			ui.screen(7);
        			String startDate = input.nextLine();
        			GregorianCalendar start = readDate(startDate);
        			ui.screen(8);
        			String endDate = input.nextLine();
        			GregorianCalendar end = readDate(endDate);
        			if(model.createProject(userInput, start, end, model.getCurrentUser())) {
        				ui.screen(9);
        				ui.screen(4);
        			}else {
        				ui.projectCreated(userInput);
        				ui.screen(4);
        			}
        		}else ui.screen(4);
        	}
        }
    }
    
    private GregorianCalendar readDate(String input) {
    	String[] parts = input.split("/");
    	if(parts.length<3) {
    		parts = input.split("\\.");
    		if(parts.length<3) {
    			parts = input.split(" ");
    			if(parts.length<3) {
    				parts = input.split("-");
    			}
    		}
    	}
    	int day = Integer.parseInt(parts[0]);
    	int month = Integer.parseInt(parts[1]);
    	int year = Integer.parseInt(parts[2]);
    	
    	return calendar.createCalendar(year, month, day);
    }

}