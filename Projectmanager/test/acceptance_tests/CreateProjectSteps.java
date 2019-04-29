package acceptance_tests;

import app.Controller;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import acceptance_tests.LoginSteps;

import java.util.List;

import static org.junit.Assert.*;

public class CreateProjectSteps {
    public Controller controller;
    public String userID;

    public CreateProjectSteps(Controller controller, String userID){
        this.controller=controller;
        this.userID=userID;
    }

    @Given("These Projectnames are contained in the system")
    public void these_Projectnames_are_contained_in_the_system(List<String> dataTable) {
        controller.projectNames = dataTable;
    }

    @Given("Developer is logged in")
    public void developer_is_logged_in() {
        assertTrue(controller.userIDs.contains(userID));
    }

    @When("Add project with name {string}")
    public void add_project_with_name(String name) {
        controller.CreateProject(name);
    }


    @Then("A project with name {string} is added")
    public void a_project_with_name_is_added(String name) {
        assertTrue(controller.projectNames.contains(name));
    }
}