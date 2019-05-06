package acceptance_tests;

import app.Calender;
import app.Developer;
import app.Model;
import app.Project;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class AssignProjectmanagerSteps {
    private Model model;
    private Developer currentCandidate;
    private Calender calendar;

    public AssignProjectmanagerSteps(Model model, Calender calendar){
        this.model=model;
        this.calendar=calendar;
    }

    @Given("These User IDs are contained in the project {string}")
    public void these_User_IDs_are_contained_in_the_project(String project, List<String> dataTable) {
        model.setCurrentProject(new Project(project, model.getCurrentUser()));
        model.getCurrentProject().addDeveloper(model.getCurrentUser());

        for(String s: dataTable){
            model.getCurrentProject().addDeveloper(new Developer(s));
        }
    }

    @When("add projectmanager {string}")
    public void add_projectmanager(String id) {
        currentCandidate=new Developer(id);
        model.assignProjectmanager(currentCandidate,model.getCurrentProject(),model.getCurrentUser());
    }

    @Then("The projectmanager is assigned to the project")
    public void the_projectmanager_is_assigned_to_the_project() {
        assertEquals(currentCandidate,model.getCurrentProject().getProjectmanager());
    }
}
