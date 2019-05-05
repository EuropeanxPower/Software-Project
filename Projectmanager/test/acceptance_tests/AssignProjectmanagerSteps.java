package acceptance_tests;

import app.Developer;
import app.Model;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class AssignProjectmanagerSteps {
    private Model model;
    private Developer currentCandidate;

    public AssignProjectmanagerSteps(Model model){
        this.model=model;
    }

    @When("add projectmanager {string}")
    public void add_projectmanager(String id) {
        currentCandidate=new Developer(id);
        model.assignProjectmanager(currentCandidate,model.getCurrentProject(),model.getCurrentUser());
    }

    @Then("The projectmanager is assigned to the project")
    public void the_projectmanager_is_assigned_to_the_project() {
        assertTrue(currentCandidate==model.getCurrentProject().getProjectmanager());
    }
}
