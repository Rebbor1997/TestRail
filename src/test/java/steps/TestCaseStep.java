package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.TestCasePage;

public class TestCaseStep extends BaseStep {

    public TestCaseStep(WebDriver driver) {
        super(driver);
    }

    public void addTestCase(String title, String preconds, String steps, String result) {
        TestCasePage testCasePage = new TestCasePage(driver, true);
        testCasePage.clickRunTestCase();
        testCasePage.clickTestCaseButton();
        testCasePage.setTittle(title);
        testCasePage.setPreconds(preconds);
        testCasePage.setSteps(steps);
        testCasePage.setResult(result);
        testCasePage.clickAddTestCase();


    }
}
