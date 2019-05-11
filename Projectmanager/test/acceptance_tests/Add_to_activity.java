package acceptance_tests;

import app.Activity;
import app.Developer;
import app.Model;
import com.sun.org.apache.xpath.internal.operations.Bool;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Add_to_activity {
    Model model;

    public Add_to_activity(Model model){
        this.model=model;
    }

    @Given("Developer is on the activity {string}")
    public void developer_is_on_the_activity(String string) {
        ArrayList<Developer> team = new ArrayList<>();

        for(Activity a : model.getCurrentProject().getActivityList()){
            if(a.getName().equals(string)){
                model.getCurrentProject().setCurrentActivity(a);
                team.add(model.getCurrentUser());
                model.getCurrentProject().getCurrentActivity().setDevelopers(team);
            }
        }
    }

    @When("Invite {string} to the activity {string}")
    public void invite_to_the_activity(String d, String a) {
        for (Activity ac : model.getCurrentProject().getActivityList()){
            if (ac.getName().equals(a)) {
                model.getCurrentProject().setCurrentActivity(ac);
            }
        }
        Boolean check = false;
        for(Developer dev : model.getCurrentProject().getCurrentActivity().getDevelopers()){
            if (dev.getUserId()==d){
                model.addDeveloperActivity(dev);
                check=true;
            }
        }

        if (!check){
            model.addDeveloperActivity(model.getDeveloper(d));
        }

    }

}