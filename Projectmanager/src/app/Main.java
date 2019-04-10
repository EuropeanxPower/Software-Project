package app;
import app.Controller;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String userID;

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();

        System.out.println("Please enter your login");
        Scanner login = new Scanner(System.in);
        userID = login.next();
        controller.Login(userID);
    }
}
