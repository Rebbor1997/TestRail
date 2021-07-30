package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginStep;
import steps.ProjectStep;

public class SmokeTest extends BaseTest {
    @Test(description = "Basic test")
    public void PositiveLoginTest() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.Login(properties.getUsername(), properties.getPassword());
    }

    @Test(enabled = false)
    public void NegativeLoginTest(){
        LoginStep loginStep = new LoginStep(driver);
        loginStep.Login("asfdfewe","pl,pl,porkew");
        Assert.assertEquals(new LoginPage(driver,false).getErrorLabel().getText(),
                        "Email/Login or Password is incorrect. Please try again.");
    }
}
