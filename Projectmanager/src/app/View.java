package app;  

import java.util.Scanner;

public class View {

    Controller controller;

    public View() {
        controller = new Controller();
    }

    // Case 1 is Login Screen
    // Case 2 is General Overview

    public void screens(){
      int screen = 1;

      while(true){
        switch (screen){
          case 1: 
            controller.Login();
          case 2:
            controller.Overview();
            if (controller.userInput == 1){
              screen = 3;
            }
            else if (controller.userInput == 2){
              screen = 4;
            }
            else if (controller.userInput == 3){
              screen = 5;
            } else{
              System.out.println("Invalid input");
            }
            break;
          case 3:
            // Function
            screen = 2;
            break;
          case 4:
            // Function
            screen = 2;
            break;
        }
      }
    }

}