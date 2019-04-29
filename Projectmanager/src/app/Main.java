package app;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {        
        Controller controller = new Controller();

        Scanner input = new Scanner(System.in);
        int screen = 1;

        while(true){
            switch (screen){
                case 1:
                    while (controller.loggedIn == false) {
                        System.out.println("Please enter your login");
                        controller.userID = input.next();
                        controller.Login(controller.userID);
                    }
                case 2:
                    controller.Overview();
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
