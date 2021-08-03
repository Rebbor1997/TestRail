package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BrowserService {
    private ReadProperties properties = new ReadProperties();
    private WebDriver  driver;
    private Waits wait;

    public BrowserService() {

            switch (properties.getBrowser().toLowerCase()) {
                case "chrome":
                    WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                default:
                    throw new AssertionError("Данный браузер не поддерживается.");
            }

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        wait = new Waits(driver, properties.getTimeOut());
    }
    public WebDriver getDriver() {
        return driver;
    }

    public Waits getWait(){
        return wait;
    }
}
