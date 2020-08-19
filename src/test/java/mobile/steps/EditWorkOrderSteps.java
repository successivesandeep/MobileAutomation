package mobile.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import mobile.pages.EditWorkOrderPage;

public class EditWorkOrderSteps {
    @Then("^I click on edit work order button$")
    public void iClickOnEditWorkOrderButton()
    {
        EditWorkOrderPage.editWorkorder();
    }

    @And("^I click on Save button$")
    public void iClickOnSaveButton()
    {

        EditWorkOrderPage.save();
    }
}
