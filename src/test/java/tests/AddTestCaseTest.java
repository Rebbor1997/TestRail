package tests;

import baseEntities.BaseTest;

import data.StaticProvider;
import org.testng.annotations.Test;

import steps.LoginStep;
import steps.ProjectStep;
import steps.TestCaseStep;

public class AddTestCaseTest extends BaseTest {

    @Test(dataProvider = "TestCase", dataProviderClass = StaticProvider.class )
    public void addTestCase(String one, String two, String three, String four) throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.Login(properties.getUsername(), properties.getPassword());

        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject(properties.getNameProject(),properties.getNewNameProject());

        TestCaseStep testCaseStep = new TestCaseStep(driver);
        testCaseStep.addTestCase(one, two, three, four);

        Thread.sleep(4000);
    }

}
