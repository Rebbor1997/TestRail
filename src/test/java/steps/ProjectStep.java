package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

public class ProjectStep extends  BaseStep {
    public ProjectStep(WebDriver driver) {
        super(driver);
    }
    public void addProject(String nameproject, String editnameproject){
        ProjectsPage projectsPage = new ProjectsPage(driver, true);
        projectsPage.clickAddProject();
        projectsPage.setNameProject(nameproject);
        projectsPage.clickAddProjectButton();
        projectsPage.clickEditProject();
        projectsPage.clearNameProject();
        projectsPage.setNewNameProject(editnameproject);
        projectsPage.clickEditProjectButton();
    }
}
