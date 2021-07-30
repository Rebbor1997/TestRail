package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final static By name_Input_By = By.id("name");
    private final static By password_Input_By = By.id("password");
    private final static By login_Button_By = By.id("button_primary");
    private final static By error_By = By.className("error-text");

    public LoginPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL());
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getLoginButton().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getUsernameInput() { return driver.findElement(name_Input_By); }
    public WebElement getPasswordInput() {return driver.findElement(password_Input_By); }
    public WebElement getLoginButton() {return driver.findElement(login_Button_By); }
    public WebElement getErrorLabel() {return driver.findElement(error_By); }

    public void setUsername(String text) {
        getUsernameInput().sendKeys(text);
    }
    public void setPassword(String text) { getPasswordInput().sendKeys(text); }
    public void clickLoginButton() { getLoginButton().click(); }


}
