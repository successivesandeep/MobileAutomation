package mobile.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import mobile.pages.MyProfilePage;

public class MyProfileSteps {
    @Then("^I am able to see profile detail$")
    public void iAmAbleToSeeProfileDetail(DataTable dataTable) {
        MyProfilePage.verifyMyProfile(dataTable);
    }

    @Then("^I am able to see profile detail is not updated$")
    public void iAmAbleToSeeProfileDetailIsNotUpdated(DataTable dataTable) {
        MyProfilePage.profileIsNotUpdated(dataTable);
    }

    @And("^I click on Edit Profile button$")
    public void iClickOnEditProfileButton() {
        MyProfilePage.clickOnEditProfileButton();
    }

    @Then("^profile created date is displaying as \"([^\"]*)\"$")
    public void profileCreatedDateIsDisplayingAs(String profileCreatedDate) {
        //MyProfilePage.seeProfileCreatedDate(profileCreatedDate);
    }
}
