package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeletePage extends BasePage {
    private final static String endpoint = "index.php?/admin/projects/overview";
    private final static By delete_By =By.xpath("//*[text() = 'NewProjectBor']/ancestor::tr[@class = 'odd hoverSensitive']//div[@class ='icon-small-delete']");
    private final static By delete_Yes_By =By.xpath("//strong[.= 'Yes, delete this project (cannot be undone)']/ancestor::div[@style = 'margin-top: 12px; line-height: 1']//input[@type ='checkbox']");
    private final static By delete_Ok_By =By.xpath("//div[@class= 'button-group dialog-buttons-highlighted']/ancestor::div[@id = 'dialog-ident-deleteDialog']//a[@class= 'button button-ok button-left button-positive dialog-action-default']");




    public DeletePage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() { driver.get(properties.getURL()+endpoint);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public WebElement getDeleteProject() {return driver.findElement(delete_By);}
    public WebElement getDeleteYesProject() {return driver.findElement(delete_Yes_By);}
    public WebElement getDeleteOkProject() {return driver.findElement(delete_Ok_By);}

    public void clickDelete(){getDeleteProject().click();}
    public void clickDeleteYes(){getDeleteYesProject().click();}
    public void clickDeleteOk(){getDeleteOkProject().click();}
}
