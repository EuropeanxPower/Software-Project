package acceptance_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import app.Controller;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static net.bytebuddy.matcher.ElementMatchers.is;
public class LoginSteps {
    public Controller controller;


//    @Given("These User IDs are contained in the system")
//    public void these_User_IDs_are_contained_in_the_system(io.cucumber.datatable.DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//        throw new cucumber.api.PendingException();
//    }

    @When("Login with {string}")
    public void login_with(String string) {
        controller.ID = string;
        assertTrue(controller.userIDs.contains(string));
    }


    @Then("User is logged in")
    public void user_is_logged_in() {
        assertTrue(controller.loggedIn == true);
    }
//
//    @Then("Errormessage {string}")
//    public void errormessage(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
//    }

}

