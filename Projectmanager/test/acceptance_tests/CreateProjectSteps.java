package acceptance_tests;

import app.Calender;
import app.Developer;
import app.Model;
import app.Project;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CreateProjectSteps {
    private Model model;
    private Calender calendar;
    private ArrayList<Project> currentProjects = new ArrayList<>();

    public CreateProjectSteps(Model model, Calender calendar){
        this.model=model;
        this.calendar=calendar;
    }

    @Given("These Projectnames are contained in the system")
    public void these_Projectnames_are_contained_in_the_system(List<String> datatable) {
        for(String s: datatable){
            currentProjects.add(new Project(s,calendar.createCalendar(2019,5,1),calendar.createCalendar(2019,9,1),model.getUserIDs().get(1)));
        }
        model.setProjectNames(currentProjects);
    }

    @Given("Developer is logged in")
    public void developer_is_logged_in() {
        for (Developer d: model.getUserIDs()){
            if (d==model.getCurrentUser()){
                assertEquals(d,model.getCurrentUser());
            }
        }
    }

    @When("Add project with name {string}")
    public void add_project_with_name(String name) {
        model.createProject(name, calendar.createCalendar(2019,5,1),calendar.createCalendar(2019,9,1),model.getCurrentUser());
    }


    @Then("A project with name {string} is added")
    public void a_project_with_name_is_added(String name) {
        for (Project p: model.getProjectNames()){
            if (p.getName()==name){
                assertEquals(p.getName(),name);
            }
        }
    }
}