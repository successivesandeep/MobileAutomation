package mobile.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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


    @When("^I click on Add work order button$")
    public void iClickOnAddWorkOrderButton() {
        WorkOrderPage.addWorkOrder();
    }

    @When("^I use below data to create a work order$")
    public void iUseBelowDataToCreateAWorkOrder(DataTable dataTable) {
    }

    @And("^I Enter data in title field as \"([^\"]*)\"$")
    public void iEnterDataInTitleFieldAs(String Title) {
        WorkOrderPage.selectTitle(Title);
    }

    @And("^I Enter data in description field as \"([^\"]*)\"$")
    public void iEnterDataInDescriptionFieldAs(String Description) {
        WorkOrderPage.fillDescription(Description);
    }

    @And("^I select date in due date field$")
    public void iSelectDateInDueDateField() {
        WorkOrderPage.selectCurrentDate();
    }

    @And("^I select \"([^\"]*)\" in facility field$")
    public void iSelectInFacilityField(String facility) {
        WorkOrderPage.selectFacility(facility);
    }

    @And("^I select \"([^\"]*)\" in unit field$")
    public void iSelectInUnitField(String unit) {
        WorkOrderPage.selectUnit(unit);
    }

    @And("^I select \"([^\"]*)\" in priority field$")
    public void iSelectInPriorityField(String priorityMessage) {
        WorkOrderPage.selectPriority(priorityMessage);
    }

    @And("^I click on create button$")
    public void iClickOnCreateButton() {
        WorkOrderPage.clickOnCreateButton();
    }

    @When("^I leave the mandatory fields eg \"([^\"]*)\",\"([^\"]*)\" blank$")
    public void iLeaveTheMandatoryFieldsEgBlank(String title, String description) {
        WorkOrderPage.selectTitle(title);
        WorkOrderPage.fillDescription(description);
    }

    @And("^I see the error message as \"([^\"]*)\"$")
    public void iSeeTheErrorMessageAs(String message) {
        WorkOrderPage.errorMessage(message);
    }


    @And("^I select \"([^\"]*)\" in category field$")
    public void iSelectInCategoryField(String category) {
        WorkOrderPage.selectCategory(category);
    }

    @And("^I check checkboxes in notification field$")
    public void iCheckCheckboxesInNotificationField() {
        WorkOrderPage.notification();
        WorkOrderPage.closeNotification();
    }

    @And("^I select \"([^\"]*)\" in assign to field$")
    public void iSelectInAssignToField(String assignee) {
        WorkOrderPage.selectAssignee(assignee);
    }


    @And("^I check checkbox of \"([^\"]*)\" in watchers field$")
    public void iCheckCheckboxOfInWatchersField(String selectedWatcher) {
        WorkOrderPage.selectWatchers(selectedWatcher);
    }


    @When("^I cancel the work order creation$")
    public void iCancelTheWorkOrderCreation() {
        WorkOrderPage.cancel();

    }

    @When("^I leave the mandatory fields blank$")
    public void iLeaveTheMandatoryFieldsEgTitleDescriptionBlank(DataTable dataTable) {
        for (int i = 0; i <= 1; i++) {
            String Title = dataTable.asMaps(String.class, String.class).get(i).get("title");
            String Description = dataTable.asMaps(String.class, String.class).get(i).get("description");
            WorkOrderPage.selectTitle(Title);
            WorkOrderPage.fillDescription(Description);
        }

    }

    @When("^I leave the mandatory facility,unit blank$")
    public void iLeaveTheMandatoryFacilityUnitBlank() {
        WorkOrderPage.blankFacility();
    }

    @Then("^I will see the work order created with title \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void iWillSeeTheWorkOrderCreatedWithTitleAndDescription(String titleDescription, String finalDescription) {
        WorkOrderPage.verifyCreatedTitle(titleDescription);
        WorkOrderPage.verifyCreatedTitle(finalDescription);
    }
}