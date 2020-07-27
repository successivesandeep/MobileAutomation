package mobile.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mobile.pages.LoginPage;
import mobile.pages.WorkOrderPage;

public class LoginStep {
    @When("^I enter emailId as \"([^\"]*)\"$")
    public void IEntersEmailIdAs(String emailId) {
        LoginPage.enterEmailAddress(emailId);
    }

    @And("^I enter password as \"([^\"]*)\"$")
    public void IEntersPasswordAs(String password) {
        LoginPage.enterPassword(password);
    }

    @And("^I click on SignIn Button$")
    public void IClicksOnSignInButton() {
        LoginPage.clickSignInButton();
    }

    @And("^I close app$")
    public void iCloseApp() {
        LoginPage.closeApp();
    }

    @When("^I launch app$")
    public void iLaunchApp() {
        LoginPage.launchApp();
    }

    @Then("^I can see message as \"([^\"]*)\"$")
    public void errorMessageIsDisplayingAs(String errorMessage) throws InterruptedException {
        LoginPage.veryMessageForInvalidCredential(errorMessage);
    }

    @And("^I press \"([^\"]*)\" button$")
    public void iPressButton(String expectedButtonName) {
        LoginPage.pressOkButton(expectedButtonName);
    }

    @When("^I login with credential$")
    public void iLoginWithCredential(DataTable dataTable) {
        String email = dataTable.asMaps(String.class, String.class).get(0).get("userEmail");
        String password = dataTable.asMaps(String.class, String.class).get(0).get("password");
        LoginPage.enterEmailAddress(email);
        LoginPage.enterPassword(password);
        LoginPage.clickSignInButton();
        WorkOrderPage.verifyUserOnWorkOrderPage("Work Order");
    }
}
