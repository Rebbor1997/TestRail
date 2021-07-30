package core;

import com.sun.deploy.association.AssociationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.sql.Driver;

public class BrowserService {
    private ReadProperties properties = new ReadProperties();
    private WebDriver driver;

    public BrowserService() {
        switch (properties.getBrowser().toLowerCase()) {
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                driver = new ChromeDriver();
                break;
            default:
                throw new AssertionError("Данный браузер не поддерживается.");
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
}
