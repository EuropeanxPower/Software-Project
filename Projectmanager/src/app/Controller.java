package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Controller {


    public List<String> userIDs = new ArrayList<String>(Arrays.asList("VWJ", "NA", "CP", "TM"));

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public Boolean loggedIn = false;
    public String errorMessage;

    public Controller() {

    }
    public void read()throws IOException {
        StringTokenizer operation = new StringTokenizer(in.readLine());

        String command = operation.nextToken();
        switch (command){

        }
    }
    public void Login(String userID){
        if (userIDs.contains(userID)){
            loggedIn = true;
            System.out.println("True");
        }
        else{
            errorMessage = "User ID doesn't exists";
            new Errorhandler("User ID doesn't exists");
        }

    }
}
