package acceptance_tests;

import app.Developer;
import app.Model;
import app.Project;
import app.Calender;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class AddToProjectSteps {
    private Model model;
    private Developer invited;
    private Calender calendar;

    public AddToProjectSteps(Model model, Calender calendar){
        this.model=model;
        this.calendar=calendar;
    }

    @Given("Developer is a part of {string}")
    public void developer_is_a_part_of(String name) {
        model.setCurrentProject(new Project(name, calendar.createCalendar(2019,5,1),calendar.createCalendar(2019,9,1),model.getCurrentUser()));
        model.getCurrentProject().addDeveloper(model.getCurrentUser());
    }

    @Given("The project does not have a projectmanager")
    public void the_project_does_not_have_a_projectmanager() {
        model.getCurrentProject().setProjectmanager(null);
    }

    @When("add developer {string}")
    public void add_developer(String id) {
        invited = new Developer("id");
        model.addToProject(invited, model.getCurrentProject(), model.getCurrentUser());
    }

    @Then("A developer is added")
    public void a_developer_is_added() {
        for (Developer d: model.getUserIDs()){
            if (d==invited){
                assertEquals(d,invited);
            }
        }
    }

    @Given("The project has a projectmanager")
    public void the_project_has_a_projectmanager() {
        model.getCurrentProject().setProjectmanager(new Developer("HPJ"));
    }

    @Given("Developer is projectmanager of {string}")
    public void developer_is_projectmanager_of(String name) {
        model.setCurrentProject(new Project(name, calendar.createCalendar(2019,5,1),calendar.createCalendar(2019,9,1),model.getCurrentUser()));
        model.getCurrentProject().setProjectmanager(model.getCurrentUser());
    }
}
