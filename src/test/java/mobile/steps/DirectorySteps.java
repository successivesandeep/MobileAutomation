package mobile.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mobile.pages.DirectoryPage;

public class DirectorySteps {
    @When("^I navigate on directory page$")
    public void iNavigateOnDirectoryPage() {
        DirectoryPage.clickOnDirectoryTab();
    }

    @Then("^I can filter the directory by vendor name \"([^\"]*)\"$")
    public void iCanFilterTheDirectoryByVendorName(String vendorName) {
        DirectoryPage.clickOnSearchButton();
        DirectoryPage.enterKeyToSearchVendors(vendorName);
        DirectoryPage.verifySearchedVendorsWithFullText(vendorName);
    }

    @Then("^I can filter the directory by vendor partial name \"([^\"]*)\"$")
    public void iCanFilterTheDirectoryByVendorPartialName(String vendorNameHavingPartialText) {
        DirectoryPage.clickOnSearchButton();
        DirectoryPage.enterKeyToSearchVendors(vendorNameHavingPartialText);
        DirectoryPage.verifySearchedVendorsWithPartialText(vendorNameHavingPartialText);
    }

    @Then("^I can filter the directory by vendor type \"([^\"]*)\"$")
    public void iCanFilterTheDirectoryByVendorType(String vendorType) {
        DirectoryPage.clickOnSearchButton();
        DirectoryPage.enterKeyToSearchVendors(vendorType);
        DirectoryPage.verifySearchedVendorsWithFullVendorTypeText(vendorType);
    }

    @Then("^I can filter the directory by vendor type with partial text \"([^\"]*)\"$")
    public void iCanFilterTheDirectoryByVendorTypeWithPartialText(String vendorTypeHavingPartialText) {
        DirectoryPage.clickOnSearchButton();
        DirectoryPage.enterKeyToSearchVendors(vendorTypeHavingPartialText);
        DirectoryPage.verifySearchedVendorsWithPartialVendorTypeText(vendorTypeHavingPartialText);
    }

    @Then("^I can filter the directory by vendor type \"([^\"]*)\" by selecting through dropdown$")
    public void iCanFilterTheDirectoryByVendorTypeWithPartialTextBySelectingThroughDropdown(String vendorTypeHavingPartialText) {
        DirectoryPage.filterVendorsBasedOnVendorTypeBySelectingThroughDropdown(vendorTypeHavingPartialText);
    }
}
