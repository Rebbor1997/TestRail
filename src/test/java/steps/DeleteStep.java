package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DeletePage;

public class DeleteStep extends BaseStep {
    public DeleteStep(WebDriver driver) {
        super(driver);
    }

    public void deleteProject(){
        DeletePage deletePage = new DeletePage(driver, true);
        deletePage.clickDelete();
        deletePage.clickDeleteYes();
        deletePage.clickDeleteOk();
    }
}
