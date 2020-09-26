package mobile.steps;

import com.robotium.solo.By;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mobile.pages.NotificationPage;

public class NotificationSteps {
    @When("^I navigate on \"([^\"]*)\" pages$")
    public void iNavigateOnNotificationPage(String pageName) {
        NotificationPage.clickOnNotificationButton(pageName);
    }

    @Then("^I can delete a notification$")
    public void iCanDeleteANotification() {
        NotificationPage.clickOnActionButtonForFirstNotification();
        NotificationPage.deleteANotification();
        NotificationPage.deletedNotificationIsNotDisplaying();
    }

    @And("^I click on \"([^\"]*)\" button$")
    public void iClickOnButton(String buttonName) {
        NotificationPage.readAllNotifications(buttonName);
    }

    @Then("^I can see popup with message \"([^\"]*)\"$")
    public void iCanSeePopupWithMessage(String readAllConfirmationMessage) {
        NotificationPage.verifyConfirmationMessageForReadAllMessage(readAllConfirmationMessage);
    }

    @Then("^I can see all notification marked as read$")
    public void iCanSeeAllNotificationMarkedAsRead() {
    }

    @Then("^I can mark a notification as read$")
    public void iCanMarkANotificationAsRead() {

    }
}
