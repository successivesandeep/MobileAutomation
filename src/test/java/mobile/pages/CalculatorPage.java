package mobile.pages;

import mobile.utilities.PageHandler;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CalculatorPage extends PageHandler {
    private static String numberButton = "com.android.calculator2:id/digit_";
    private static String button = "com.android.calculator2:id/op_";
    private static String result = "com.android.calculator2:id/result";
    private static String formula = "com.android.calculator2:id/formula";
    private static String deleteButton = "com.android.calculator2:id/del";

    public static void selectNumber(String number) {
        clickOnElement(By.id(numberButton + number));
    }

    public static void performOperation(String buttonName) {
        clickOnElement(By.id(button + buttonName));
    }

    public static void seeResult(String expectedResult) {
        Assert.assertEquals(expectedResult, getText(By.id(result)));
    }

    public static void seeFormulaInCalculator(String expectedFormula) {
        Assert.assertEquals(expectedFormula, getText(By.id(formula)));
    }

    public static void clearResult() {
        while (!getText(By.id(formula)).equals("")) {
            clickOnElement(By.id(deleteButton));
        }
    }
}