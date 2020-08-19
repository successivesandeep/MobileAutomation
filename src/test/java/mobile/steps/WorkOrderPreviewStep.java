package mobile.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import mobile.pages.WorkOrderPreviewPage;

public class WorkOrderPreviewStep {
    @And("^I click on Preview button$")
    public void iClickOnPreviewButton() {
        WorkOrderPreviewPage.preview();
    }

    @And("^I will see the heading as \"([^\"]*)\"$")
    public void iWillSeeTheHeadingAs(String Preview) {
        WorkOrderPreviewPage.headingPreview(Preview);
    }

    @Then("^I click on create button of preview screen$")
    public void iClickOnCreateButtonOfPreviewScreen() {
        WorkOrderPreviewPage.previewCreate();
    }
}
