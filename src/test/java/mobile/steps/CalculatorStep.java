package mobile.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mobile.pages.CalculatorPage;

public class CalculatorStep {
    @When("^user press number \"([^\"]*)\"$")
    public void usersAddTwoNumbersAnd(String number) {
        CalculatorPage.selectNumber(number);
    }

    @Then("^user can see \"([^\"]*)\" in result$")
    public void userCanSeeInResult(String result) {
        CalculatorPage.seeResult(result);
    }

    @And("^user press \"([^\"]*)\" button$")
    public void userPressButton(String button) {
        CalculatorPage.performOperation(button);
    }

    @And("^formula is being displayed as \"([^\"]*)\"$")
    public void formulaIsBeingDisplayedAs(String formula) {
        CalculatorPage.seeFormulaInCalculator(formula);
    }

    @Given("^reset the calculator$")
    public void resetTheCalculatorUsingButton() {
        CalculatorPage.clearResult();
    }
}
