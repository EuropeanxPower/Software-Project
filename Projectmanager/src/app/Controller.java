package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Controller {

    public String ID;
    public List<String> userIDs = new ArrayList<String>(Arrays.asList("SKP", "PTRO", "AL"));

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public Boolean loggedIn = false;
    public String errorMessage;

    public Controller() {
        System.out.println("Please enter your login");
        Scanner login = new Scanner(System.in);
        ID = login.next();
        Login(ID);
    }
    public void read()throws IOException {
        StringTokenizer operation = new StringTokenizer(in.readLine());

        String command = operation.nextToken();
        switch (command){

        }
    }
    public void Login(String ID){
            if (userIDs.contains(ID)){
                loggedIn = true;
                System.out.println("True");
            }
            else{
                errorMessage = "User ID doesn't exists";
                new Errorhandler("User ID doesn't exists");
                System.out.println(errorMessage);
            }

    }
}
