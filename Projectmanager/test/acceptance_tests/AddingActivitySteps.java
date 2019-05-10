package acceptance_tests;

import app.Activity;
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

    public AddingActivitySteps(Model model, Calender calenadar){
        this.model=model;
        this.calendar=calenadar;
    }

    @Given("these activities are contained in the project {string}")
    public void these_activities_are_contained_in_the_project(String project, List<String> dataTable) {
        model.setCurrentProject(new Project(project, model.getCurrentUser()));
        for(String s: dataTable){
        model.addActivity(s,"2019/05/01","2019/09/01",model.getCurrentProject());
        }
    }

    @When("add activity {string}")
    public void add_activity(String string) {
        model.addActivity(string,"2019/05/01","2019/09/01",model.getCurrentProject());
    }

    @Then("An activity with name {string} is added")
    public void an_activity_with_name_is_added(String string) {
        for (Activity a: model.getCurrentProject().getActivityList()){
            if (a.getName()==string){
                assertEquals(a.getName(),string);
            }
        }
    }

}