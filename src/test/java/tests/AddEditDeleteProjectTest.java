package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.ProjectsPage;
import steps.DeleteStep;
import steps.LoginStep;
import steps.ProjectStep;

public class AddEditDeleteProjectTest extends BaseTest {

    @Test(invocationCount = 2)
    public void addProject() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.Login(properties.getUsername(), properties.getPassword());

        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject(properties.getNameProject(),properties.getNewNameProject());

        DeleteStep deleteStep = new DeleteStep(driver);
        deleteStep.deleteProject();
    }
}
