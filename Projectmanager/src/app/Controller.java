package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Controller {
    public static String currentUserID;
    // public View view;
    public List<String> userIDs = new ArrayList<String>(Arrays.asList("VWJ", "NA", "CP", "TM"));
    public List<String> projectNames = new ArrayList<String>(Arrays.asList("Tele-Kipper", "Sort-Pick"));
    Scanner scanner = new Scanner(System.in);
    public Boolean loggedIn = false;
    public String errorMessage;

    String userInput;

    public Controller(){
    }

}