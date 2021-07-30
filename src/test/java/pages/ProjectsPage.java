package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private final static String endpoint = "index.php?/dashboard";
    private final static By add_Project = By.id("sidebar-projects-add");
    private final static By add_Name_Project = By.id("name");
    private final static By add_Project_Button = By.id("accept");
    private final static By edit_Project = By.xpath("//*[text() = 'ProjectBor']/ancestor::tr[@class = 'odd hoverSensitive']//div[@class ='icon-small-edit']");
    private final static By edit_New_Name_Project = By.id("name");
    private final static By edit_New_Name_Click = By.id("accept");

    public ProjectsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL()+endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getAddProjectButton().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getAddProject() {return driver.findElement(add_Project);}
    public WebElement getAddNameProject() {return driver.findElement(add_Name_Project);}
    public WebElement getAddProjectButton() {return driver.findElement(add_Project_Button);}
    public WebElement getEditProject() {return driver.findElement(edit_Project);}
    public WebElement getEditNewNameProject() {return driver.findElement(edit_New_Name_Project);}
    public WebElement getEditNewNameClick() {return driver.findElement(edit_New_Name_Click);}

    public void clickAddProject() {getAddProject().click();}
    public void setNameProject(String text) { getAddNameProject().sendKeys(text); }
    public void clickAddProjectButton() {getAddProjectButton().click();}
    public void clickEditProject() {getEditProject().click();}
    public void clearNameProject(){getEditNewNameProject().clear();}
    public void setNewNameProject(String text) { getEditNewNameProject().sendKeys(text); }
    public void clickEditProjectButton() {getEditNewNameClick().click();}




}
