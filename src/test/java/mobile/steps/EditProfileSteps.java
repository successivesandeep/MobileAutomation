package mobile.steps;


import cucumber.api.java.en.And;
import mobile.pages.EditProfilePage;

public class EditProfileSteps {

    @And("^I change the name as \"([^\"]*)\"$")
    public void iChangeTheNameAs(String name) {
        EditProfilePage.changeName(name);
    }

    @And("^I save the changes$")
    public void iSaveTheChanges() {
        EditProfilePage.clickSaveButton();
    }

    @And("^I change the contact number as \"([^\"]*)\"$")
    public void iChangeTheContactNumberAs(String contactNumber) {
        EditProfilePage.changeMobileNumber(contactNumber);
    }

    @And("^user clicks on back button$")
    public void userClicksOnBackButton() {
        EditProfilePage.clickOnBackButton();
    }

    @And("^I click on change password button$")
    public void iClickOnChangePasswordButton() {
        EditProfilePage.changePasswordButton();
    }
}
