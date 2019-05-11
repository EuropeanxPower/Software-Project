package acceptance_tests;

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
    private ArrayList<Project> currentProjects = new ArrayList<>();

    public CreateProjectSteps(Model model){//Vivian
        this.model=model;
    }

    @Given("These Projectnames are contained in the system")
    public void these_Projectnames_are_contained_in_the_system(List<String> datatable) {
        for(String s: datatable){
            currentProjects.add(new Project(s,model.getUserIDs().get(1)));
        }
        model.setProjectNames(currentProjects);
    }

    @Given("Developer is logged in")
    public void developer_is_logged_in() {
        model.Login("SKP");
    }

    @When("Add project with name {string}")
    public void add_project_with_name(String name) {
        model.createProject(name,model.getCurrentUser());
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