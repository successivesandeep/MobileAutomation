package mobile.steps;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mobile.pages.ChangePasswordPage;

public class ChangePasswordSteps {

    @When("^I enters current password, new password and confirm password are$")
    public void userEntersCurrentPasswordNewPasswordAndConfirmPasswordAre(DataTable dataTable) {
        String currentPassword = dataTable.asMaps(String.class, String.class).get(0).get("currentPassword");
        String newPassword = dataTable.asMaps(String.class, String.class).get(0).get("newPassword");
        String confirmPassword = dataTable.asMaps(String.class, String.class).get(0).get("confirmPassword");
        ChangePasswordPage.currentPassword(currentPassword);
        ChangePasswordPage.newPassword(newPassword);
        ChangePasswordPage.confirmPassword(confirmPassword);
    }

    @And("^I Click on submit button$")
    public void iClickOnSubmitButton() {
        ChangePasswordPage.submit();
    }

    @Then("^I see the error message saying \"([^\"]*)\"$")
    public void iSeeTheErrorMessageSaying(String message) {
        ChangePasswordPage.seeMessage(message);
    }

    @And("^I Accept the dialog box$")
    public void iAcceptTheDialogBox() {
        ChangePasswordPage.acceptMessage();
    }

    @Then("^I can see message when required field is missing$")
    public void iCanSeeMessageWhenRequiredFieldIsMissing(DataTable dataTable) {
        String currentPassword = dataTable.asMaps(String.class, String.class).get(0).get("currentPassword");
        String newPassword = dataTable.asMaps(String.class, String.class).get(0).get("newPassword");
        String confirmPassword = dataTable.asMaps(String.class, String.class).get(0).get("confirmPassword");
        String expectedMessage = dataTable.asMaps(String.class, String.class).get(0).get("message");
        ChangePasswordPage.currentPassword(currentPassword);
        ChangePasswordPage.newPassword(newPassword);
        ChangePasswordPage.confirmPassword(confirmPassword);
        ChangePasswordPage.submit();
        ChangePasswordPage.seeMessage(expectedMessage);
    }
}
