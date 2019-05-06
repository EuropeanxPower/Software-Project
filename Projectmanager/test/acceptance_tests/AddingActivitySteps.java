package acceptance_tests;

import app.Calender;
import app.Model;
import app.Project;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class AddingActivitySteps {

    private Model model;
    private Calender calendar;

    public AddingActivitySteps(Model model, Calender calendar){
        this.model=model;
        this.calendar=calendar;
    }

    @Given("these activities are contained in the project {string}")
    public void these_activities_are_contained_in_the_project(String project, List<String> dataTable) {
        model.setCurrentProject(new Project(project, model.getCurrentUser()));
        for(String s: dataTable){
        model.getCurrentProject.addActivity(s,calendar.createCalendar(2019,5,1),calendar.createCalendar(2019,9,1),model.getCurrentUser());
        }
    }

    @When("add activity {string}")
    public void add_activity(String string) {

    }

    @Then("An activity is added")
    public void an_activity_is_added() {

    }

}