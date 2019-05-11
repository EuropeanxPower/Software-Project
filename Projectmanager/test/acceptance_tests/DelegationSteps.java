package acceptance_tests;

import app.Activity;
import app.Developer;
import app.Model;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class DelegationSteps {
    Model model;

    public DelegationSteps(Model model){
        this.model=model;
    }


    @When("delegate {string} the activity {string}")
    public void delegate_the_activity(String d, String a) {
        for (Activity ac : model.getCurrentProject().getActivityList()){
            if (ac.getName().equals(a)) {
                model.getCurrentProject().setCurrentActivity(ac);
            }
        }
        Boolean tjek=false;
        for(Developer dev : model.getCurrentProject().getCurrentActivity().getDevelopers()){
            if (dev.getUserId()==d){
                model.addDeveloperActivity(dev);
                tjek = true;
            }
        }

        if (!tjek){
            model.addDeveloperActivity(model.getDeveloper(d));
        }

    }

    @Then("{string} are now on the activity with name {string}")
    public void are_now_on_the_activity_with_name(String d, String a) {
        for (Activity ac : model.getCurrentProject().getActivityList()){
            if (ac.getName().equals(a)) {
                model.getCurrentProject().setCurrentActivity(ac);
                assertEquals(ac.getName(), a);
            }
        }
        for(Developer dev : model.getCurrentProject().getCurrentActivity().getDevelopers()){
            if (dev.getUserId()==d){
                assertEquals(dev.getUserId(), d);
            }
        }


    }
}
