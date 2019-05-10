package acceptance_tests;

import app.Developer;
import app.Model;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginSteps {
    private Model model;
    public String currentUserID;
    private ArrayList<Developer> currentUserIDs = new ArrayList<Developer>();

    public LoginSteps(Model model){
        this.model=model;
    }

    public String getCurrentUserID(){
        return currentUserID;
    }


    @Given("These User IDs are contained in the system")
    public void these_User_IDs_are_contained_in_the_system(List<String> datatable) {

        for(String s: datatable){
            currentUserIDs.add(new Developer(s));
        }
        model.setUserIDs(currentUserIDs);
    }
    @When("Login with {string}")
    public void login_with(String string) {
        model.Login(string);
        currentUserID = string;
    }


    @Then("User is logged in")
    public void user_is_logged_in() {
        for (Developer d: model.getUserIDs()){
            if (d.getUserId()==currentUserID){
                assertEquals(d.getUserId(),currentUserID);
            }
        }
    }

    @Then("Errormessage {string}")
    public void errormessage(String string) {
        assertEquals(string, model.getErrorMessage());
    }

}




