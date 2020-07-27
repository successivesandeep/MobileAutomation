package mobile.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import mobile.pages.WorkOrderPage;

public class WorkOrderStep {
    @Then("^I navigate on \"([^\"]*)\" page$")
    public void iNavigateOnPage(String pageName) {
        WorkOrderPage.verifyUserOnWorkOrderPage(pageName);
    }

    @And("^I click on Menu button$")
    public void iClickOnMenuButton() {
        WorkOrderPage.clickOnMenuButton();
    }
}
