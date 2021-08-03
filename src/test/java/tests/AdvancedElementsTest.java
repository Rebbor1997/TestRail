package tests;

import baseEntities.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class AdvancedElementsTest extends BaseTest {



    @Test
    public void contextTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(hotSpot)
                .contextClick()
                .build().perform();
        Thread.sleep(2000);
    }
    @Test
    public void dynamicControls() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
        WebElement remove = driver.findElement(By.xpath("//button[@onclick= 'swapCheckbox()']"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(checkbox)
                .click(checkbox)
                .build().perform();
        Thread.sleep(2000);
        actions
                .moveToElement(remove)
                .click(remove)
                .build().perform();
        waits.waitForVisibility(By.xpath("//p[@id= 'message']"));
        waits.waitForInvisibility(By.xpath("//input[@type = 'checkbox']"));
        Thread.sleep(2000);

        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        input.isEnabled();
        Assert.assertFalse(input.isEnabled());

        WebElement enable = driver.findElement(By.xpath("//button[@onclick= 'swapInput()']"));
        actions
                .moveToElement(enable)
                .click()
                .build().perform();
        waits.waitForVisibility(By.xpath("//p[@id= 'message']"));
        actions
                .moveToElement(input)
                .pause(5000)
                .click()
                .sendKeys("text")
                .build().perform();
        Thread.sleep(2000);
    }
    @Test
    public void uploadFileTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement uploadFile = driver.findElement(By.xpath("//input[@type = 'file' and @name='file']"));
        uploadFile.sendKeys("C:\\Users\\brebe\\Desktop\\11593aLuPkoNlFgmqwYBbvSt.jpg");
        driver.findElement(By.id("file-submit")).submit();
        waits.waitForVisibility(By.xpath("//h3[text()= 'File Uploaded!']"));
        waits.waitForVisibility(By.xpath("//div[contains(text(), '11593aLuPkoNlFgmqwYBbvSt.jpg')]"));
        Thread.sleep(3000);
    }
    @Test
    public void downloadFileTest() throws InterruptedException {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement downloadFile = driver.findElement(By.xpath("//a[contains(text(), 'test.txt')]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(downloadFile)
                .click().build().perform();

        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches(fileName)) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
        driver.quit();
    }
}
