package mobile.pages;

import mobile.utilities.MobileDriver;
import org.junit.Assert;

public class CalculatorPage extends MobileDriver {
    private static String numberButton = "com.android.calculator2:id/digit_";
    private static String button = "com.android.calculator2:id/op_";
    private static String result = "com.android.calculator2:id/result";
    private static String formula = "com.android.calculator2:id/formula";
    private static String deleteButton = "com.android.calculator2:id/del";

    public static void selectNumber(String number) {
        getDriver().findElementById(numberButton + number).click();
    }

    public static void performOperation(String buttonName) {
        getDriver().findElementById(button + buttonName).click();
    }

    public static void seeResult(String expectedResult) {
        String actualResult = getDriver().findElementById(result).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    public static void seeFormulaInCalculator(String expectedFormula) {
        String actaulFormula = getDriver().findElementById(formula).getText();
        Assert.assertEquals(expectedFormula, actaulFormula);
    }

    public static void clearResult() {
        while (!getDriver().findElementById(formula).getText().equals("")) {
            getDriver().findElementById(deleteButton).click();
        }
    }
}