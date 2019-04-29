package acceptance_tests;

import app.Errorhandler;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import app.Controller;

import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;

public class LoginSteps {
    public Controller controller;
    public String currentUserID;

    public LoginSteps(Controller controller){
        this.controller=controller;
    }


    @Given("These User IDs are contained in the system")
    public void these_User_IDs_are_contained_in_the_system(List<String> datatable) {
        controller.userIDs = datatable;
    }

    @When("Login with {string}")
    public void login_with(String string) {
        controller.Login(string);
        currentUserID = string;
    }


    @Then("User is logged in")
    public void user_is_logged_in() {
        assertTrue(controller.userIDs.contains(currentUserID));
        assertTrue(controller.loggedIn == true);
    }

    @Then("Errormessage {string}")
    public void errormessage(String string) {
        assertEquals(string, controller.errorMessage);
    }

}





