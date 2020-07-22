package mobile.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import mobile.pages.LoginPage;

public class LoginStep {
    @When("^user enters emailId as \"([^\"]*)\"$")
    public void userEntersEmailIdAs(String emailId) {
        LoginPage.enterEmailAddress(emailId);
    }

    @And("^user enters password as \"([^\"]*)\"$")
    public void userEntersPasswordAs(String password) {
        LoginPage.enterPassword(password);
    }

    @And("^user clicks on SignIn Button$")
    public void userClicksOnSignInButton() {
        LoginPage.clickSignInButton();
    }
}
