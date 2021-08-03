package baseEntities;

import core.ReadProperties;
import core.Waits;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 15;
    protected WebDriver driver;
    protected ReadProperties properties;

    protected abstract void openPage();
    public abstract boolean isPageOpened();
    protected Waits waits;


    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        waits = new Waits(driver, properties.getTimeOut());
        properties = new ReadProperties();

        if (openPageByUrl) {
            openPage();
        }
    }
}
